package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedSystem;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties;

@SuppressWarnings("all")
public class TimedSystemVisitorAspectTimedSystemAspectContext {
  public final static TimedSystemVisitorAspectTimedSystemAspectContext INSTANCE = new TimedSystemVisitorAspectTimedSystemAspectContext();
  
  public static TimedSystemVisitorAspectTimedSystemAspectProperties getSelf(final TimedSystem _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TimedSystem, TimedSystemVisitorAspectTimedSystemAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedSystem, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties>();
  
  public Map<TimedSystem, TimedSystemVisitorAspectTimedSystemAspectProperties> getMap() {
    return map;
  }
}
