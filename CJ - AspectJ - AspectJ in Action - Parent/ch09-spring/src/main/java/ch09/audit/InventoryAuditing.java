package ch09.audit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import ch09.domain.Product;

@Component
@Aspect
public class InventoryAuditing
{
	private Logger logger = LogManager.getFormatterLogger();

	@Pointcut("execution (* *(ch09.domain.Product, int)) && args(product, quantity)")
	public void audited(Product product, int quantity)
	{
	}

	@Before("audited(product, quantity)")
	public void audit(JoinPoint joinPoint, Product product, int quantity)
	{
		this.logger.info(
				"about to %s (%s, %d)",
				joinPoint.getSignature().getName(),
				product,
				quantity);
	}
}
