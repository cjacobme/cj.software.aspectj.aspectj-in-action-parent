package cj.software.aspectj.own.cflow;

import java.util.Collection;

public class BillingMachine
{
	public double calcTotalSum(Contract contract)
	{
		double result = 0.0;
		Collection<ContractDetail> details = contract.getDetails();
		for (ContractDetail detail : details)
		{
			double detailTotal = detail.getEinzelpreis() * detail.getMenge();
			result += detailTotal;
		}
		return result;
	}
}
