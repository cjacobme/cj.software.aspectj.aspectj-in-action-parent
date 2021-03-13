package ch04.ch04;

import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface Cachable
{
	String cacheStore();
}
