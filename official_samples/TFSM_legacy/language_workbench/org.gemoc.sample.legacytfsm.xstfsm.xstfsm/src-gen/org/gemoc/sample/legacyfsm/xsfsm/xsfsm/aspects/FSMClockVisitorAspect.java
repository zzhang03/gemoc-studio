package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockAspect;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties;

@Aspect(className = FSMClock.class)
@SuppressWarnings("all")
public class FSMClockVisitorAspect {
  public static void visit(final FSMClock _self) {
	final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockVisitorAspectFSMClockAspectContext
			.getSelf(_self);
	_privk3_visit(_self_, _self);
	;
}
  
  protected static void _privk3_visit(final FSMClockVisitorAspectFSMClockAspectProperties _self_, final FSMClock _self) {
    FSMClockAspect.ticks(_self);
  }
}
