package ch09;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch09.domain.Product;
import ch09.service.InventoryService;

@SpringBootApplication
public class InventoryMain
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"application-context.xml");
		try
		{
			InventoryService inventoryService = (InventoryService) ctx.getBean("inventoryService");
			Product myBook = new Product("CJ", "CJ experiments with Aspect-J", 44.99);
			inventoryService.addProduct(myBook, 100000);
			inventoryService.removeProduct(myBook, 100000);
		}
		finally
		{
			ctx.close();
		}
	}
}
