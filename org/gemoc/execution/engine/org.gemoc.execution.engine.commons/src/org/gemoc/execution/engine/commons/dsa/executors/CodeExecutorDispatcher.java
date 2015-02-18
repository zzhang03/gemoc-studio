package org.gemoc.execution.engine.commons.dsa.executors;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutionException;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;

/**
 * An aggregation of several CodeExecutors.
 * The actual invoke command will be dispatched to the first CodeExecutor that is able to handle it 
 * @author dvojtise
 * @author flatombe
 * 
 */
public class CodeExecutorDispatcher implements ICodeExecutor 
{

	protected List<ICodeExecutor> _executors = null;

	public CodeExecutorDispatcher() 
	{
		_executors = new ArrayList<ICodeExecutor>();
	}

	public CodeExecutorDispatcher(ICodeExecutor codeExecutor) 
	{
		this();
		addExecutor(codeExecutor);
	}

	public CodeExecutorDispatcher(List<ICodeExecutor> codeExecutors) 
	{
		this();
		for (ICodeExecutor codeExecutor : codeExecutors) 
		{
			addExecutor(codeExecutor);
		}
	}

	public void addExecutor(ICodeExecutor executor) 
	{
		_executors.add(executor);
	}

	@Override
	public Object execute(MSEOccurrence mseOccurrence) throws CodeExecutionException 
	{		
		for (ICodeExecutor executor : _executors) 
		{
			try {
				return executor.execute(mseOccurrence);
			} catch (CodeExecutionException e) 
			{
				e.printStackTrace();
			}
		}
		throw new CodeExecutionException("No code executor could perform the action call. (a commons mistake is : missing package export of the called class or aspect)", mseOccurrence);
	}

	@Override
	public Object execute(Object caller, String methodName,
			List<Object> parameters) throws CodeExecutionException {
		for (ICodeExecutor executor : _executors) 
		{
			try {
				return executor.execute(caller, methodName, parameters);
			} catch (CodeExecutionException e) 
			{
				e.printStackTrace();
			}
		}
		throw new CodeExecutionException("No code executor could perform the action call. (a commons mistake is : missing package export of the called class or aspect)", null);
	}
}