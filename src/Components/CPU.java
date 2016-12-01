package Components;

public class CPU {
	//Aggregates and supervises Clock, CacheMemory, InterruptProcessor, and eventQueue
	private Clock clock;
	private ProcessControlBlock process;
	
	public void advanceClock(Clock clock) {
		clock.execute();
		clock.getClock();
	}
	
	public ProcessControlBlock getCurrentProcess(){
		return process;
	}
	
	
	public boolean detectInterrupt() {
		return InterruptProcessor.interruptOn;
	}
		  
	public void detectPreemption() {
	
	}
}
