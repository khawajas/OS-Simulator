package Components;

//Simulates a CPU clock

public class Clock {
	private int time;
	
	public void execute() {
		time++;
	 }
	
	public void getClock() {
		return time;
	}

}
