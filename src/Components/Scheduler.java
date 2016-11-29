package Components;

public class Scheduler {
	
	//Schedules processes according to round robin algorithm 
	//with a time quantum of 10 cycles
	
	private static ExecutionQueue ready = new ExecutionQueue();
	
	
	
	public void insertPCB(ProcessControlBlock process){
		ready.enQueue(process);
		
	}
	    
	public void removePCB(ProcessControlBlock process){
		ready.deQueue(process);
		
	}
	    	    
	public ProcessStates getState(ProcessControlBlock process){
		return process.getState();
		
	}
	    
	public void setState(){
	    	
	}
	
	public void getWait(){
	    	
	}
	    
	public void setWait(){
	    	
	}
	    
	public void getArrival(){
	    	
	}
	    
	public void setArrival(){
	}
	    
	public void getCPUTime(){    	

	}

	public void setCPUTime(){

	}

	public void addCPUTime(){
	     
	}

}
