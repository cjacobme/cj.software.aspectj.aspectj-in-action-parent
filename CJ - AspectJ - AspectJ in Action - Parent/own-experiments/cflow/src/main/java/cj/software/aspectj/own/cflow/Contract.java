package cj.software.aspectj.own.cflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Contract
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private Collection<ContractDetail> contractDetails = new ArrayList<>();

	public Contract(Collection<ContractDetail> details)
	{
		if (details != null)
		{
			this.contractDetails.addAll(details);
		}
	}

	public boolean add(ContractDetail contractDetail)
	{
		boolean result = this.contractDetails.add(contractDetail);
		return result;
	}

	public boolean addAll(Collection<ContractDetail> contractDetails)
	{
		boolean result = contractDetails.addAll(contractDetails);
		return result;
	}

	public Collection<ContractDetail> getDetails()
	{
		return Collections.unmodifiableCollection(this.contractDetails);
	}
}
