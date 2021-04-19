package ch09;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch09.domain.Product;
import ch09.service.InventoryService;
import ch09.service.impl.InventoryServiceStubImpl;

@SpringBootApplication
public class InventoryMain
{
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		try
		{
			ctx.register(InventoryServiceStubImpl.class);
			ctx.refresh();

			Product myBook = new Product("CJ", "CJ experiments with Aspect-J", 44.99);
			InventoryService inventoryService = (InventoryService) ctx.getBean("inventoryService");
			inventoryService.addProduct(myBook, 100000);
			inventoryService.removeProduct(myBook, 100000);
		}
		finally
		{
			ctx.close();
		}
	}
}
