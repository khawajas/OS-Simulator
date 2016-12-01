package Components;

//Simulates a CPU clock

public class Clock {
	private static int time;
	
	public void execute() {
		time++;
	 }
	
	public static int getClock() {
		return time;
	}
	public void resetClock(){
		time = 0;
	}

}
