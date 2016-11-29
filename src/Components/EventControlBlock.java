package Components;
/*The Event Control Block
any event waiting service will be represented by an Event Control Block, and
will wait for the service on EventQueue.  

Used primarily to assist the priority queue, which needs an object, which this will be
*/

public class EventControlBlock {
	
	//the time the event started
	int bigBang;
	ProcessControlBlock process;

	public EventControlBlock(ProcessControlBlock process, int timeIn) {
		process = process;
		timeIn = bigBang;
	}

	public void setService(ProcessControlBlock process) {
		process = process;
	}

	public void setBigBang(int timeIn){
		timeIn = bigBang;
	}

	public ProcessControlBlock getProcess() {
		return process;
	}
	
	public int getTimeIn() {
		return bigBang;
	}
	

}
