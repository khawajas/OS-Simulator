package Components;

import java.util.Random;

public class IOBurst {
	//Randomly determines IO burst times
	
	public int generateIOBurst(){
		Random num = new Random();
		int min = 25;
		int max = 50;
		int ioBurstTime = num.nextInt(max - min) + min;
		return ioBurstTime;
	}
}
