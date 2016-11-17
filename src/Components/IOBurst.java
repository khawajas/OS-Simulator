package Components;

import java.util.Random;

public class IOBurst {
	//Randomly determines IO burst times
	//the simulator shall have I/O operations taking between 25 and 50 cycles. The simulator runs in steps defined as “looped” cycles.
	
	public int generateIOBurst(){
		Random num = new Random();
		int min = 25;
		int max = 50;
		int ioBurstTime = num.nextInt(max - min) + min;
		return ioBurstTime;
	}
}
