package Components;

public class CPU {
	//Aggregates and supervises Clock, CacheMemory, InterruptProcessor, and eventQueue
	
	public void advanceClock(Clock clock) {
		clock.execute();
		clock.getClock();
	}
	
	public void detectInterrupt() {
		
	}
		  
	public void detectPreemption() {
	
	}
}
