package ch04.ch04;

public class StockService
{
	@Cachable(cacheStore = "Chart")
	public byte[] getQuoteGraph(String tickerName)
	{
		return tickerName.getBytes();
	}
}
