package Components;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class InterruptProcessor {
	//Simulates an interrupt processor

	static boolean interruptOn;

	//Constructs a new interrupt processor

	public InterruptProcessor() {
		interruptOn = false;
	}

 	static PriorityQueue<Object> nxtUp = new PriorityQueue<Object>();

	
	public void signalInterrupt(boolean interrupt) {
		InterruptProcessor.interruptOn = true;
	}
	  
	public static void addEvent(EventControlBlock flag) {
		nxtUp.add(flag);
	    
	}
	  
	public EventControlBlock getEvent(int element_number) {
		//nxtUp.remove(element_number);
		return nxtUp.getEvent(element_number);
	}

	public static boolean hasInterruptOnStarted() {
		return interruptOn;
	}

}
