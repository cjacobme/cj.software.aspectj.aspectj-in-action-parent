package ch04.ch03;

import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface NetworkRetries
{
	int numTries();
}
