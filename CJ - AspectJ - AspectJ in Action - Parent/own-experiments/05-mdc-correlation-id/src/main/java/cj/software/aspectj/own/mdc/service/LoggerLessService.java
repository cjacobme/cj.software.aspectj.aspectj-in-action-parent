package cj.software.aspectj.own.mdc.service;

import org.apache.logging.log4j.Logger;

import cj.software.aspectj.own.mdc.entity.Contract;

/**
 * this class has no object variable of type {@link Logger}. Therefore, the aspect should applied to
 * its methods.
 */
public class LoggerLessService
{
	public void doNothing(Contract contract)
	{
	}
}
