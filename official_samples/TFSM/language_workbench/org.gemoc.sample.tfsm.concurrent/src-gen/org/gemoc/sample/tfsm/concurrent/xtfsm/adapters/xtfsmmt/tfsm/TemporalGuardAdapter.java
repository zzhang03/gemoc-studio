/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TemporalGuard;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.FSMClock;

@SuppressWarnings("all")
public class TemporalGuardAdapter extends EObjectAdapter<TemporalGuard> implements org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TemporalGuard {
  private XTfsmMTAdaptersFactory adaptersFactory;
  
  public TemporalGuardAdapter() {
    super(org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory.getInstance());
    adaptersFactory = org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory.getInstance();
  }
  
  @Override
  public String getName() {
    return adaptee.getName();
  }
  
  @Override
  public void setName(final String o) {
    adaptee.setName(o);
  }
  
  @Override
  public int getAfterDuration() {
    return adaptee.getAfterDuration();
  }
  
  @Override
  public void setAfterDuration(final int o) {
    adaptee.setAfterDuration(o);
  }
  
  @Override
  public FSMClock getOnClock() {
    return (FSMClock) adaptersFactory.createAdapter(adaptee.getOnClock(), eResource);
  }
  
  @Override
  public void setOnClock(final FSMClock o) {
    if (o != null)
    	adaptee.setOnClock(((org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.FSMClockAdapter) o).getAdaptee());
    else adaptee.setOnClock(null);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static int AFTER_DURATION_EDEFAULT = 0;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.eINSTANCE.getTemporalGuard();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TEMPORAL_GUARD__NAME:
    		return getName();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TEMPORAL_GUARD__ON_CLOCK:
    		return getOnClock();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TEMPORAL_GUARD__AFTER_DURATION:
    		return new java.lang.Integer(getAfterDuration());
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TEMPORAL_GUARD__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TEMPORAL_GUARD__ON_CLOCK:
    		return getOnClock() != null;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TEMPORAL_GUARD__AFTER_DURATION:
    		return getAfterDuration() != AFTER_DURATION_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TEMPORAL_GUARD__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TEMPORAL_GUARD__ON_CLOCK:
    		setOnClock(
    		(org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.FSMClock)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TEMPORAL_GUARD__AFTER_DURATION:
    		setAfterDuration(((java.lang.Integer) newValue).intValue());
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
