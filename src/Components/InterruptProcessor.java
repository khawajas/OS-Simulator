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

 	PriorityQueue<Object> nxtUp = new PriorityQueue<Object>();

	
	public void signalInterrupt(boolean interrupt) {
		InterruptProcessor.interruptOn = interrupt;
	}
	  
	public void addEvent(ECB flag) {
		nxtUp.add(flag);
	    
	}
	  
	public ECB getEvent(int element_number) {
		nxtUp.remove(element_number);
		//return nxtUp.getEvent(element_number);
	}

	public boolean hasInterruptOnStarted() {
		return interruptOn;
	}
}
