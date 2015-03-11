package org.gemoc.execution.engine.core;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IFutureAction;

public class PlainK3ExecutionEngine extends AbstractExecutionEngine implements IMSEOccurrenceListener
{

	private Runnable _runnable;
	
	public PlainK3ExecutionEngine(final IExecutionContext context, final Object caller, final Method method, final ArrayList<Object> parameters) 
	{
		super(context);
		_runnable = new Runnable() {			
			@Override
			public void run() {
				try
				{
					MSEManager.getInstance().addListener(PlainK3ExecutionEngine.this);
					method.invoke(caller, parameters.get(0));
				} 						
				catch (Exception e) {
					throw new RuntimeException(e);
				}
				finally
				{
					MSEManager.getInstance().removeListener(PlainK3ExecutionEngine.this);
				}
			}
		};
	}

	@Override
	public void addFutureAction(IFutureAction action) 
	{
	}

	@Override
	protected void executeSelectedLogicalStep() 
	{
		if (_isStopped)
		{
			throw new RuntimeException(getName() + " is stopped");
		}
		notifyAboutToExecuteLogicalStep();
		notifyLogicalStepExecuted();
	}
	
	@Override
	protected Runnable getRunnable() 
	{
		return _runnable;
	}

	@Override
	public void mseOccurenceRaised(MSEOccurrence occurrence) 
	{
		// before coming here, i is absolutely necessary to have visited the solver first.
		try {
			performExecutionStep();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
