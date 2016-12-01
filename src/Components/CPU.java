package Components;

public class CPU {
	//Aggregates and supervises Clock, CacheMemory, InterruptProcessor, and eventQueue
			InterruptProcessor interrupt = new InterruptProcessor();

	public void advanceClock(Clock clock) {
		clock.execute();
		clock.getClock();
	}
	
	public void detectInterrupt() {
		InterruptProcessor.hasInterruptOnStarted();
	}
		  
	public void detectPreemption() {
		
	}
}
