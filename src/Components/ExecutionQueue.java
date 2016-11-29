package Components;

import java.util.Queue;

public class ExecutionQueue {
	//Encapsulates the queue structure used by Scheduler
	
	private Queue<ProcessControlBlock> eQueue;
	
	public void enQueue(ProcessControlBlock process) {
		eQueue.add(process);
	}
		  
	public void deQueue(ProcessControlBlock process) {
		eQueue.remove(process);
	}

}