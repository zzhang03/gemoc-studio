package org.gemoc.sample.legacytfsm.tfsm.k3dsa

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.Step

import org.gemoc.sample.legacytfsm.tfsm.TimedFSM
import org.gemoc.sample.legacytfsm.tfsm.State
import org.gemoc.sample.legacytfsm.tfsm.Transition
import org.gemoc.sample.legacytfsm.tfsm.NamedElement
import org.gemoc.sample.legacytfsm.tfsm.Guard
import org.gemoc.sample.legacytfsm.tfsm.TemporalGuard
import org.gemoc.sample.legacytfsm.tfsm.EventGuard
import org.gemoc.sample.legacytfsm.tfsm.FSMEvent
import org.gemoc.sample.legacytfsm.tfsm.FSMClock
import org.gemoc.sample.legacytfsm.tfsm.TimedSystem
import org.gemoc.sample.legacytfsm.tfsm.EvaluateGuard

import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.TimedFSMAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.TimedFSMVisitorAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.StateAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.TransitionAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.FSMEventAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.FSMClockAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.TimedSystemAspect.*
import org.eclipse.emf.common.util.EList

@Aspect(className=TimedFSM)
class TimedFSMAspect {

	public State currentState
	
	@Step
	def public void init() {

		_self.currentState = _self.initialState;
		_self.localClock.numberOfTicks = 0
		_self.localEvents.forEach[e|e.isTriggered = false]
		_self.stepNumber = 0
		_self.lastStateChangeStepNumber = 0

		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".Init()]Initialized " + _self.name)
	}

}

@Aspect(className=FSMClock)
class FSMClockAspect {

	public Integer numberOfTicks
	
	// Clock tick
	@Step
	def public Integer ticks() {
		_self.numberOfTicks = _self.numberOfTicks + 1
		println(
			"[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".ticks()]New number of ticks : " +
				_self.numberOfTicks.toString)
		return _self.numberOfTicks
	}

}

@Aspect(className=State)
class StateAspect {
	def public void onEnter() {
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".onEnter()]Entering " + _self.name)
	}

	def public void onLeave() {
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".onLeave()]Leaving " + _self.name)
	}
}

@Aspect(className=Transition)
class TransitionAspect {
	@Step
	def public void fire() {
		_self.source.owningFSM.currentState = _self.target
		println(
			"[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".fire()]Fired " + _self.name + " -> " +
				_self.action)
	}
}

@Aspect(className=FSMEvent)
class FSMEventAspect {

	public boolean isTriggered
	
	@Step
	def public void trigger() {
		_self.isTriggered = true
	}

	@Step
	def public void unTrigger() {
		_self.isTriggered = false
	}

}

@Aspect(className=TimedSystem)
class TimedSystemAspect {
       
       @fr.inria.diverse.k3.al.annotationprocessor.Main
       def public void main() {
       	       val tfsm = _self.tfsms.get(0)
               var i = 0
               while (i != 20)
               {

                       if (i == 10)
                       {
                               tfsm.localEvents.forEach [ e |
                                       e.trigger
                               ]
                       }

                       tfsm.visit

                       if (i == 10)
                       {
                               tfsm.localEvents.forEach[e|e.unTrigger]
                       }

                       i++
               }
               println("Normal stop after "+i+" iterations (set in main)");
       }
       
       
       @fr.inria.diverse.k3.al.annotationprocessor.InitializeModel
       def public void initializeModel(EList<String> args){
       		val tfsm = _self.tfsms.get(0)
            tfsm.init	
       }
}
