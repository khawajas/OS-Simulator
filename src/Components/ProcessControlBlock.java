package Components;

import java.util.ArrayList;

/*A ProcessControlBlock/PCB is a data structure within the OS, allows the OS to locate certain processes
 *contains:
 * 	the state of the process
 * 	the unique ID of the process - pID
 * 	Pointer to the parent process or child process
 * 	Program Counter - pointer to address of the next instruction to be executed
 * 	CPU register -  where process need to be stored for execution for running state
 * 	CPU scheduling - 
 *	Memory allocated to the process
 *	CPU used - priorities, scheduling queue pointers  
 *	Clock time elapsed
 *	I/O devices allocated to process
 *	List of open files
 *	
 * 
 */
public class ProcessControlBlock {	
	private ProcessStates processState;
	private int pID;
	private Clock clock;
	private String processName;
	
	private int startTime;
	private int endTime;
	
	private int wait;
	private int arrival;
	
	public ArrayList<String> processList = new ArrayList<String>();
	
	public ProcessControlBlock(){
		
	}
	public ProcessControlBlock(String pName, ProcessStates pState, int id, int sTime, int arrival){
		this.processName = pName;
		this.processState = pState;
		this.pID = id;
		this.arrival = arrival;
		this.startTime = sTime;
		this.clock = new Clock();
		
		
	}
	
	//setters and getters for Process States
	public ProcessStates getState(){
		return processState;
	}
	
	public void setState(ProcessStates pState){
		this.processState = pState;
	}
	
	//setters and getters for Process Id
	public int getPid(){
		return pID;
	}
	
	public void setPid(int id){
		this.pID = id;
	}
	
	//setter and getters for the time it takes to complete the process
	public void setEndTime(int eTime){
		this.endTime = eTime;
	}
	
	public int getEndTime(){
		return endTime;
	}
	public int getWait() {
		return wait;
	}
	public void setWait(int wait) {
		this.wait = wait;
		
	}
	public int getArrival() {
		return arrival;
	}
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	
	
	

}
