package cj.software.aspectj.own.camunda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class TaskListener01
		implements
		TaskListener
{
	private Logger logger = LogManager.getFormatterLogger();

	@Override
	public void notify(DelegateTask delegateTask)
	{
		this.logger.info("TaskListener01");
	}

}
