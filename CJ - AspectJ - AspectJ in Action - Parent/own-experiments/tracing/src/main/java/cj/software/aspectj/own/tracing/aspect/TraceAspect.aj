package cj.software.aspectj.own.tracing.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.reflect.MethodSignature;

public aspect TraceAspect 
{
	private pointcut trace() : execution(@Trace  * *.*(..));
	
	before() : trace() 
	{
		Logger logger = LogManager.getFormatterLogger(thisJoinPoint.getTarget().getClass());
		MethodSignature signature = (MethodSignature)thisJoinPoint.getSignature();
		String methodName = signature.getName();
		Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
		try
		{
			Method method = thisJoinPoint.getTarget().getClass().getMethod(methodName,parameterTypes);
			Class<?> returnType = method.getReturnType();
			StringBuilder sb = new StringBuilder();
			if (returnType != null)
			{
				sb.append(returnType.getSimpleName()).append(" ");
			}
			sb.append(methodName).append("(");
			Object[] args = thisJoinPoint.getArgs();
			if (args != null)
			{
				int numArgs = args.length;
				Annotation[][] 	annotations = method.getParameterAnnotations();
				for (int iArg = 0; iArg < numArgs; iArg++)
				{
					Annotation[] annotationsOfArg = annotations[iArg];
					boolean hasNoTrace = false;
					for (Annotation annotation : annotationsOfArg)
					{
						if (annotation.annotationType().equals(NoTrace.class))
						{
							hasNoTrace = true;
							break;
						}
					}
					if (! hasNoTrace)
					{
						Object arg = args[iArg];
						sb.append(arg);
					}
					sb.append(",");
				}
				if (numArgs > 0)
				{
					int stringLength = sb.length();
					sb.deleteCharAt(stringLength - 1);
				}
			}
			sb.append(")");
			logger.info(sb.toString());
		}
		catch (Exception exception)
		{
			throw new RuntimeException (exception);
		}
	}
}
