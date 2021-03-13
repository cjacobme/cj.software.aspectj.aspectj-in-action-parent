package cj.software.aspectj.own.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;

public class Util01
{
	void doSomething(DelegateExecution execution)
	{

	}

	@SuppressWarnings("unused")
	private void doSomething(DelegateTask task)
	{

	}
}
