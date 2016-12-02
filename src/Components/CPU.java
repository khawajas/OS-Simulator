//package Components;

public class CPU {
	//Aggregates and supervises Clock, CacheMemory, InterruptProcessor, and eventQueue

	InterruptProcessor interrupt = new InterruptProcessor();
	Even

	Clock clock;
	ProcessControlBlock process;
	
	public CPU() {
		this.clock = new Clock();
		this.process = new ProcessControlBlock();

		if (process.Clock() == null){
			System.out.print("Still waiting... ");
		}
		else if (process.ProcessControlBlock().arrival != null)
		{
			process.setState(RUN);
			process.advanceClock();
		}
	}

	public void advanceClock(ProcessControlBlock processClock) {
	 this.pClock = processClock;

		if (pClock.getState() == RUN)
		{
			EventControlBlock bootHerUp = new EventControlBlock();
			bootHerUp(pClock, pClock.ProcessControlBlock().getArrival())
			if (bootHerUp.getInstruction() == "CALCULATE")
			{

			}
			else if(bootHerUp.getInstruction() == "I/O")
			{
				detectInterrupt();
			}
			else if(bootHerUp.getInstruction() == "YIELD")
			{
				detectPreemption();
			}
			else if(bootHerUp.getInstruction() == "OUT")
			{

			}
			break;

			bootHerUp.
			

			
		}
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
