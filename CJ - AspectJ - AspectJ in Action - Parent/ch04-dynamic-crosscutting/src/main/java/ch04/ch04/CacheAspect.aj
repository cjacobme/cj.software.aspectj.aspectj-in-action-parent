package ch04.ch04;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public aspect CacheAspect
{
	private Logger logger = LogManager.getFormatterLogger();
	private Map<String, Object> cache = new HashMap<>();
	
	public pointcut cachedAccess(Object arg, Cachable cachable)
	: execution(@Cachable * *(*))
	&& args(arg) 
	&& @annotation(cachable);
	
	Object around(Object arg, Cachable cachable) : cachedAccess(arg, cachable) 
	{
		if (arg == null)
		{
			logger.info("no arg");
			return proceed(arg, cachable);
		}
		Object cachedValue = null;
		String key = cachable.cacheStore() + ":" + arg;
		if (cache.containsKey(key))
		{
			logger.info("from cache: %s", key);
			cachedValue = cache.get(key);
		}
		else
		{
			cachedValue = proceed (arg, cachable);
			cache.put(key, cachedValue);
			logger.info("into cache: %s",  key);
		}
		return cachedValue;
	}
}
