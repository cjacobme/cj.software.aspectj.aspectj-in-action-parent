package ch09.ch02;

import java.lang.reflect.Proxy;

import ch09.domain.Product;
import ch09.service.InventoryService;
import ch09.service.impl.InventoryServiceStubImpl;

public class ProxyMain
{
	public static void main(String[] args)
	{
		InventoryService inventoryService = new InventoryServiceStubImpl();
		InventoryService inventoryServiceProxy = (InventoryService) Proxy.newProxyInstance(
				InventoryService.class.getClassLoader(),
				new Class[]
				{ InventoryService.class
				},
				new TracingInvocationHandler(inventoryService));
		Product brv = new Product("BRV", "Berlin Recycling Volleys", 34.56);
		inventoryServiceProxy.addProduct(brv, 20000);
		inventoryServiceProxy.removeProduct(brv, 20000);
	}
}
