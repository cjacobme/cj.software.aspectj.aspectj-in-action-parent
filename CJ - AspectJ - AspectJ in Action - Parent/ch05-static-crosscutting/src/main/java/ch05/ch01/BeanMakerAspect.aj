package ch05.ch01;

import java.beans.Introspector;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public aspect BeanMakerAspect
{
	private PropertyChangeSupport Customer.propertyChangeSupport;
	
	public void Customer.addPropertyChangeListener (PropertyChangeListener listener)
	{
		propertyChangeSupport.addPropertyChangeListener(listener);
	}
	
	public void Customer.removePropertyChangeListener (PropertyChangeListener listener)
	{
		propertyChangeSupport.removePropertyChangeListener(listener);
	}
	
	pointcut beanCreation (Customer bean) 
	: initialization( Customer+.new(..)) 
	&& this(bean);
	
	pointcut beanPropertyChange (Customer bean, Object newValue)
	: execution( void Customer+.set*(*))
	&& args(newValue)
	&& this(bean);
	
	after(Customer bean) returning() : beanCreation(bean) 
	{
		bean.propertyChangeSupport = new PropertyChangeSupport(bean);
	}
	
	void around(Customer bean, Object newValue)
	: beanPropertyChange(bean, newValue)
	{
		String methodName = thisJoinPoint.getSignature().getName();
		String propertyName = Introspector.decapitalize(methodName.substring(3));
		Object oldValue = getPropertyValue(bean, propertyName);
		proceed(bean, newValue);
		bean.propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}
	
	private static Object getPropertyValue (Object bean, String propertyName)
	{
		try
		{
			return BeanUtils.getProperty(bean, propertyName);
		}
		catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException exception)
		{
			throw new RuntimeException(exception);
		}
	}
}
