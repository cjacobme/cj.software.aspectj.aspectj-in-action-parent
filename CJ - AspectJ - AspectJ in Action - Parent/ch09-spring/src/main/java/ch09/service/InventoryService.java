package ch09.service;

import ch09.domain.Product;

public interface InventoryService
{
	public void addProduct(Product product, int quantity);

	public void removeProduct(Product product, int quantity);

	public boolean isProductAvailable(Product product, int quantity);
}
