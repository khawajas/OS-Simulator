package Components;


public class Scheduler {
	
	//Schedules processes according to round robin algorithm 
	//with a time quantum of 10 cycles
	
	public static ExecutionQueue queue = new ExecutionQueue();
	
	public int maxQuantam = 10;
	
	
	public void insertPCB(ProcessControlBlock process){
		process.setArrival(Clock.getClock());
		queue.enQueue(process);
		
	}
	    
	public void removePCB(ProcessControlBlock process){
		queue.deQueue(process);
	}
	    	    
	public ProcessStates getState(ProcessControlBlock process){
		return process.getState();
		
	}
	    
	public void setState(ProcessControlBlock process, ProcessStates state){
		process.setState(state);
		
	}
	
	public int getWait(ProcessControlBlock process){
		return process.getWait();
	    	
	}
	    
	public void setWait(ProcessControlBlock process, int wait){
		process.setWait(wait);
	    	
	}
	    
	public int getArrival(ProcessControlBlock process){
		return process.getArrival();
	    	
	}
	    
	public void setArrival(ProcessControlBlock process, int arrival){
		process.setArrival(arrival);
	}
	
	    
	public void getCPUTime(ProcessControlBlock process){  
		//return process.getCPUTime();
	}

	public void setCPUTime(){

	}

	public void addCPUTime(){
	     
	}

}
