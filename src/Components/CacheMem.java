public class CacheMem
{
	static final int MAXMEM = 256;
	//static final int WORKINGWIT;
	
	public CacheMem (int task){

		if (task <= MAXMEM)
		{
			System.out.print("Your A Ok!");
		}
		else
		{
			System.out.println("Lets take it down a notch.");
			System.out.print("Your over cache by: " + (task - MAXMEM));
		}
	}
}