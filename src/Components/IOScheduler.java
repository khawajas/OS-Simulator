package Components;

import java.util.Queue;

public class IOScheduler {
	//Simulates I/O devices.
	//uses FIFO algorithm
	//Kernel schedules a set of I/O requests to determine a good order in which to execute them. 
	//When an application issues a blocking I/O system call, the request is placed on the queue for that device. 
	//The Kernel I/O scheduler rearranges the order of the queue to improve the overall system efficiency 
	//and the average response time experienced by the applications.

	
	public int scheduleIO(ProcessControlBlock process, int timeIn) {
		int bigBang = IOBurst.generateIOBurst();

		InterruptProcessor.addEvent(process, timeIn + bigBang);

		if (!InterruptProcessor.hasInterruptOnStarted())
		{
			startIO();
		}

		return bigBang;

	}
	  
	public void startIO() {
		//.signalInterrupt(true);
		InterruptProcessor.signalInterrupt(true);
	}

}
