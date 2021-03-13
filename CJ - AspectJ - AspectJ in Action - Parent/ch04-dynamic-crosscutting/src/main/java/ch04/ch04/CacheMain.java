package ch04.ch04;

public class CacheMain
{
	public static void main(String[] args)
	{
		StockService stockService = new StockService();
		stockService.getQuoteGraph("GOOG");
		stockService.getQuoteGraph("GOOG");
		stockService.getQuoteGraph("YHOO");
		stockService.getQuoteGraph("YHOO");
		stockService.getQuoteGraph("GOOG");
	}
}
