package cj.software.aspectj.own.cflow;

import java.io.Serializable;

public class ContractDetail
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private double einzelpreis;

	private int menge;

	public ContractDetail(double einzelpreis, int menge)
	{
		super();
		this.einzelpreis = einzelpreis;
		this.menge = menge;
	}

	public double getEinzelpreis()
	{
		return this.einzelpreis;
	}

	public int getMenge()
	{
		return this.menge;
	}

}
