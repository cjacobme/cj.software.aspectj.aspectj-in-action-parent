package cj.software.aspectj.own.cflow;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BillingMain
{
	private Logger logger = LogManager.getFormatterLogger();

	public static void main(String[] args)
	{
		new BillingMain().execute();
	}

	private BillingMain()
	{

	}

	private void execute()
	{
		List<ContractDetail> details = List.of(
				new ContractDetail(3.14, 42),
				new ContractDetail(2.22, 10));
		Contract contract = new Contract(details);
		BillingMachine machine = new BillingMachine();
		double total = machine.calcTotalSum(contract);
		this.logger.info("total is %7.2f", total);
	}
}
