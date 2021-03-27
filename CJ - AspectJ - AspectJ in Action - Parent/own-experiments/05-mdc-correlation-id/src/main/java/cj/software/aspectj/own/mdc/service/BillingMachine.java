package cj.software.aspectj.own.mdc.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cj.software.aspectj.own.mdc.entity.Contract;
import cj.software.aspectj.own.mdc.entity.Service;

public class BillingMachine
{
	private Logger logger = LogManager.getFormatterLogger();

	public double calculateTotalToBePayed(Contract contract)
	{
		this.logger.info("calculate total to be payed for %s", contract.toString());
		privateMethodIsNotReferenced(contract);
		double result = 0.0;
		for (Service service : contract.getServices())
		{
			result += service.getToBePayed();
		}
		this.logger.info("sum is %7.2f", result);
		return result;
	}

	public void withMultipleArguments(Contract contract, String additional)
	{
		this.logger.info("with multiple arguments %s %s", contract.toString(), additional);
	}

	private void privateMethodIsNotReferenced(Contract contract)
	{

	}

	void packageMethodIsReferenced(Contract contract)
	{

	}

	protected void protectedMethodIsReferenced(Contract contract)
	{

	}
}
