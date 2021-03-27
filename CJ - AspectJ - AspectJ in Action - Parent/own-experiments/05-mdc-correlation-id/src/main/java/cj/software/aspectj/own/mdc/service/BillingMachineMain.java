package cj.software.aspectj.own.mdc.service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cj.software.aspectj.own.mdc.entity.Contract;
import cj.software.aspectj.own.mdc.entity.Party;
import cj.software.aspectj.own.mdc.entity.Service;

public class BillingMachineMain
{
	private Logger logger = LogManager.getFormatterLogger();

	public static void main(String[] args)
	{
		BillingMachineMain machine = new BillingMachineMain();
		machine.scenario1();
	}

	private void scenario1()
	{
		Party customer = new Party(
				UUID.fromString("56fa1042-6792-46e1-ba2a-a1294556f32e"),
				"Customer 01",
				LocalDate.of(2000, 5, 13));
		Party serviceProvider = new Party(
				UUID.fromString("bd6ab644-ccd2-463d-9927-03498c2551ce"),
				"Service Provider",
				LocalDate.of(2004, 8, 1));
		Contract contract = new Contract(
				UUID.fromString("7434a8b5-28aa-4ba2-abbb-0d77a7de0810"),
				serviceProvider,
				customer,
				"Program Billing");
		Service concept = new Service(
				OffsetDateTime.of(2021, 2, 27, 17, 58, 0, 0, ZoneOffset.ofHours(1)),
				"concept");
		contract.addService(concept);
		concept.finish(OffsetDateTime.of(2021, 3, 15, 16, 17, 0, 0, ZoneOffset.ofHours(1)), 234.5);
		Service implementation = new Service(
				OffsetDateTime.of(2021, 3, 18, 8, 0, 0, 0, ZoneOffset.ofHours(1)),
				"implementation");
		contract.addService(implementation);
		implementation.finish(
				OffsetDateTime.of(2021, 6, 18, 16, 0, 0, 0, ZoneOffset.ofHours(2)),
				44555.6);
		Service deploy = new Service(
				OffsetDateTime.of(2021, 6, 19, 8, 0, 0, 0, ZoneOffset.ofHours(2)),
				"deploy");
		contract.addService(deploy);

		BillingMachine billingMachine = new BillingMachine();
		double returned = billingMachine.calculateTotalToBePayed(contract);
		this.logger.info("result is %10.3f", returned);
	}
}
