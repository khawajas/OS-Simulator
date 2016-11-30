package Components;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class CommandInterface extends JFrame {
	//Executes commands to the Operating System and the simulators
	
	long memory;
	int numOfIO = 0;
	int memoryValue;
	int counter = 0;
	String line = null;
	String programName = null;
	String runTimeLength;
	int numberOfCycles;
	Queue<Object> newProcess = new LinkedList<Object>();
	
	private JFrame mainFrame;
	private JPanel controlPanel;
	
	public CommandInterface(){
		prepareGUI();
	}
	
	public static void main(String[] args) throws IOException{
		Clock c = new Clock();
		CommandInterface commandInterface = new CommandInterface();
		commandInterface.runGUI();
		c.execute();
		
		//commandInterface.load("jobFile.txt");
		
		
	}
	
	public void prepareGUI() {
		mainFrame = new JFrame("Operating System Interface");
		mainFrame.setSize(300, 250);
		
		mainFrame.setLayout(new GridLayout(3,1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		
		
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		
		mainFrame.getContentPane().add(controlPanel);
		
		
		mainFrame.add(controlPanel);
		//mainFrame.add(table);
		mainFrame.setVisible(true);
	}
	private void runGUI() {
		
		
		JLabel commandLabel = new JLabel("Command: ", JLabel.RIGHT);
		final JTextField commandText = new JTextField(10);
		
		JButton executeButton = new JButton("Run");
		executeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = commandText.getText();

				switch (command) {
				case "PROC" :
					
					
					proc();
					break;
				case "MEM":
					mem();
					
					break;
				case  "LOAD":
					CommandInterface c = new CommandInterface();
					try {
						load();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case  "EXE":
					
					exe();
					break;
				case  "RESET":
					reset();
					break;
				case  "EXIT":
					exit();
					break;
				}
			}
		});
		//numberOfCycles = Integer.parseInt(numberOfCyclesText.getText());
		
		controlPanel.add( commandLabel);
		controlPanel.add(commandText);
		//controlPanel.add(numberOfCyclesLabel);
		//controlPanel.add(numberOfCyclesText);
		
		controlPanel.add(executeButton);
		mainFrame.setVisible(true);
		
	}
	
	
	
	
	
	
	public void proc(){
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String[] col = {"Process Name", "Process State", "CPU Time Needed","CPU Time Used", "Number of I/O Requests"};
		ProcessControlBlock pcb = new ProcessControlBlock();
		Clock c = new Clock();
		Object rowData[][] = { { programName,pcb.getState(), runTimeLength , "",numOfIO } };
		    
		
		JTable table = new JTable(rowData, col);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(300, 150);
		frame.setVisible(true);
	
		
		
	}
	
	//	current usage of memory
	public void mem(){
		Runtime runtime = Runtime.getRuntime();
		memory = runtime.totalMemory() - runtime.freeMemory();
		String num = Long.toString(memory);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String[] col = {"Memory Used"};
		
		
		Object rowData[][] = { { num} };
		    
		
		JTable table = new JTable(rowData, col);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(300, 150);
		frame.setVisible(true);
	
		
			
	}
	
			
		
	
	//load a job file by name when this is called
	//File structure example:
	//*Command* *number of cycles* *Name of program*
	//EXE
	//...Each part is separated by a space
	//Last line is "EXE"
	
	public void load() throws IOException{
		String line;
		File jobFile1 = new File("src/Resources/jobFile1");
		File programFile1 = new File("src/Resources/programFile1");
		BufferedReader j = (new BufferedReader(new FileReader(jobFile1)));
		BufferedReader  p = (new BufferedReader(new FileReader(programFile1)));
		while ( (line = j.readLine()) != null){
			programName = null;
			
			String command = line;
			if (!line.contains("EXE")){
				runTimeLength = j.readLine();
				newProcess.add(command);
				programName = j.readLine();
				newProcess.add(Integer.parseInt(runTimeLength));
				
				
			}
			if (line.contains("EXE")){
				String memoryValue = p.readLine();
				String prog;
				String cycleNumber;
				int counter = 0;
				while((prog = p.readLine()) != null) {
				
				
					 if (line.startsWith("CALCULATE")){
						cycleNumber = p.readLine();
						
						
					}
					else if (line.startsWith("I/O")){
						numOfIO++;
						

					}
					else if (line.startsWith("YIELD")){

					}
					else if (line.startsWith("OUT")){
						JFrame fr = new JFrame();
						fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						String[] col = {"Process Name","Process State", "CPU Time Needed","CPU Time Used", "Number of I/O Requests"};
						ProcessControlBlock pcb = new ProcessControlBlock();
						Clock c = new Clock();
						Object rowData[][] = { { programName ,pcb.getState(), runTimeLength , "","" } };
						    
						
						JTable table = new JTable(rowData, col);
						JScrollPane scrollPane = new JScrollPane(table);
						fr.add(scrollPane, BorderLayout.CENTER);
						fr.setSize(300, 150);
						fr.setVisible(true);
						
					}	
					}
				}
		}
				
				
			
	
		
		
	}
	
	
	
	

	//getter for program file name
	public String getProgramName(){
		return programName;
	}
	
	//	
	public void exe() {
		JFrame cyclesFrame = new JFrame("Enter Number of Cycles");
		cyclesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel numberOfCyclesLabel = new JLabel("Number of Cycles: ", JLabel.LEFT);
		JTextField numberOfCyclesText = new JTextField(5);
		cyclesFrame.add(numberOfCyclesLabel);
		cyclesFrame.add(numberOfCyclesText);
		cyclesFrame.setSize(300, 200);
		cyclesFrame.setVisible(true);
		
		
		
		
			
	}
		
	public void reset() {
			Clock clock = new Clock();
			clock.resetClock();
			mainFrame.setVisible(false);
			CommandInterface t = new CommandInterface();
			t.prepareGUI();
			mainFrame.repaint();
			mainFrame.setVisible(true);
			
	}
		
	public void promptUser(){
			
	}
	public void exit() {
		mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
	}
		
}

