package ch06.ch03;

public class Age
{
	private int value;

	public Age()
	{
		this.value = 12;
	}

	public void perform()
	{
		System.out.println(String.format("<perform value=\"%d\"/>", this.value));
	}

	public int getValue()
	{
		return this.value;
	}
}
