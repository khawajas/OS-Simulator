package Components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CommandInterface {
	//Executes commands to the Operating System and the simulators
	int timeNeeded, timeUsed, priority, numberOfIO;
	long memory;
	int counter = 0;
	String line = null;
	String programName = null;
	String num;
	public static void main(String[] args){
		
		
		
	}
	
	/*Scanner scanner = new Scanner(System.in);
	String command = scanner.next();
	switch (command) {
	case 1: command == "PROC";
		proc();
		break;
	case 2: command == "MEM";
		mem();
		break;
	case 3: command == "LOAD";
		load();
		break;
	case 4: command == "EXE";
		exe();
		break;
	case 5: command == "RESET";
		reset();
		break;
	case 6: command == "EXIT";
		promptUser();
		break;
	}
	*/
	
	
	
	public void proc(){
		
		
	}
	
	//	current usage of memory
	public void mem(){
		Runtime runtime = Runtime.getRuntime();
		memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory: " + memory);
			
	}
	//read a program file by name, called in load method when "EXE" is read
	public void readProgramFile(String name){
		int counter1 = 0;
		String program = name;
		FileReader reader = null;
		String line = null;
		try {
			reader = new FileReader(program);
			BufferedReader bReader = new BufferedReader(reader);
			while((line = bReader.readLine()) != null) {
				counter1++;
				if (counter1 == 1){
				int memoryValue = Integer.parseInt(bReader.readLine());
				}
				else if (line.startsWith("CALCULATE")){
					
					
				}
				else if (line.startsWith("I/O")){
					
				}
				else if (line.startsWith("YIELD")){
					
				}
				else if (line.startsWith("OUT")){
					
				}
			}  
				
			
		}  catch(IOException e) {
			
		}
			
		
	}
		//load a job file when this is called
	public void load(File file){
			int counter2 = 0;
			line = null;
			FileReader r = null;
			try {
				r = new FileReader(file);
				BufferedReader bRead = new BufferedReader(r);
				
				while((line = bRead.readLine()) != null) {
					programName = null;
					
					counter2++;
					String command = null;
					int cycleTime;
					Queue<String> newProcess = new LinkedList<String>();
					if (line.contains(" ")) {
						
						command = line.substring(0, line.indexOf(" "));
						newProcess.add(command);
						num = line.substring(line.indexOf(" "), line.lastIndexOf(" "));
						//cycleTime = Integer.parseInt(num);
						newProcess.add(num);
						programName = line.substring(line.lastIndexOf(" "), line.length());	
						List<String> newProcessList = new ArrayList<String>(newProcess);
						
					} 
					
					if (line.startsWith("EXE")){
						readProgramFile(programName);
					}
					
					
				
					
				}
				
			} catch (IOException e) {
				
			}
			
	}
	//getter for program file name
	public String getProgramName(){
		return programName;
	}
	
	//	
	public void exe() {
		
		
		
		
			
	}
		
	public void reset() {
			
	}
		
	public void promptUser(){
			
	}
	public void exit() {
		
	}
		
}

