package Components;

import java.util.Random;

public class IOBurst {
	//Randomly determines IO burst times
	//the simulator shall have I/O operations taking between 25 and 50 cycles. The simulator runs in steps defined cycles.
	private static int min = 25;
	private static int max = 50;
	
	public int generateIOBurst(){
		Random num = new Random();
		int ioBurstTime = num.nextInt(max - min) + min;
		return ioBurstTime;
	}
}
