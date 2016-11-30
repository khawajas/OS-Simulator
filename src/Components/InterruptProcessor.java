package Components;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class InterruptProcessor {
	//Simulates an interrupt processor
	//Constructs a new interrupt processor

	public static boolean interruptOn = false;

	
	public void signalInterrupt(boolean interrupt) {
		InterruptProcessor.interruptOn = true;
	}
	  
	public static void addEvent(EventControlBlock flag) {
		EventQueue.enQueue(flag);
	    
	}
	  
	public static EventControlBlock getEvent() {
		//nxtUp.remove(element_number);
		//return nxtUp.getEvent(element_number);
		return EventQueue.poll();
	}

	public static boolean hasInterruptOnStarted() {
		return interruptOn;
	}

}
