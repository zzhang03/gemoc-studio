/*******************************************************************************
 * Copyright (c) 2015, 2017  Inria  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State;

@SuppressWarnings("all")
public class StateMachineAspectStateMachineAspectProperties {
  public State currentState;
  
  public String unprocessedString;
  
  public String consummedString;
  
  public String producedString;
}