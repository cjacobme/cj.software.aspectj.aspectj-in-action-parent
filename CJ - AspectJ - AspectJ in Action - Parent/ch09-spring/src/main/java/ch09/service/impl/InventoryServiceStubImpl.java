package ch09.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import ch09.domain.Product;
import ch09.service.InventoryService;

@Component(value = "inventoryService")
public class InventoryServiceStubImpl
		implements
		InventoryService
{
	private Logger logger = LogManager.getFormatterLogger();

	@Override
	public void addProduct(Product product, int quantity)
	{
		this.logger.info(
				"InventoryServiceStubImpl.addProduct (%s, %d)",
				product.getName(),
				quantity);
	}

	@Override
	public void removeProduct(Product product, int quantity)
	{
		this.logger.info(
				"InventoryServiceStubImpl.removeProduct (%s, %d)",
				product.getName(),
				quantity);
	}

	@Override
	public boolean isProductAvailable(Product product, int quantity)
	{
		this.logger.info(
				"InventoryServiceStubImpl.isProductAvailable (%s, %d)",
				product.getName(),
				quantity);
		return true;
	}

}
