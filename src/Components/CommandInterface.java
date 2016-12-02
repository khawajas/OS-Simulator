package Components;

import java.awt.BorderLayout;

import java.awt.Button;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import java.util.Random;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		
		
		
	}
	
	public void prepareGUI() {
		mainFrame = new JFrame("Operating System Interface");
		mainFrame.setSize(600, 250);
		
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
		
		JLabel welcome = new JLabel("Welcome! Input a command in all caps");
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
					try {
						load1("src/Resources/jobFile1");
						load1("src/Resources/JobFileTwo.txt");
						load1("src/Resources/JobFileThree.txt");
						load1("src/Resources/JobFileFour.txt");
						load1("src/Resources/JobFileFive.txt");
						load1("src/Resources/JobFileSix");
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
		
		
		controlPanel.add( commandLabel);
		controlPanel.add(commandText);
		
		
		controlPanel.add(executeButton);
		controlPanel.add(welcome);
		mainFrame.setVisible(true);
		
	}

	public void proc(){
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String[] col = {"Process Name", "Process State", "CPU Time Needed","CPU Time Used", "Number of I/O Requests"};
		ProcessControlBlock pcb = new ProcessControlBlock();
		Clock c = new Clock();
		
		Object rowData[][] = { { programName ,pcb.getState(), numberOfCycles, runTimeLength ,counter } };
		    
		
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
		int num = numberOfCycles;
		double total = 256;
		double free = runtime.freeMemory();
		
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String[] col = {"Memory Type", "Value"};
		
		
		Object rowData[][] = { { "Used Memory", num},
								{"Total Memory", total},
								{"Free Memory", total-num}};
		    
		
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
	
	
	public void load1(String fileName) throws IOException {
		String line;
		String state = "READY";
		String command;
		File jobFile = new File(fileName);
		//File programFile = new File(progName);
		BufferedReader j = (new BufferedReader(new FileReader(jobFile)));
		ArrayList<Object> process = new ArrayList<Object>();
		while ((line = j.readLine()) != null){
			command = line;
			if (!line.contains("EXE")){
				runTimeLength = j.readLine();
				programName = j.readLine();
				newProcess.add(programName);
			}
			if (line.contains("EXE")){
				ProcessControlBlock pcb = new ProcessControlBlock();
				ProcessStates processState = null;
				
			    counter = 0;
				String ln;
				File programFile = new File("src/Resources/"+programName);
				BufferedReader p = (new BufferedReader(new FileReader(programFile)));
				int numberOfCycles = Integer.parseInt(p.readLine());
				while ((ln = p.readLine()) != null){
					
					if (ln.startsWith("CALC")){
						
						pcb.setEndTime(numberOfCycles);
						Scheduler s = new Scheduler();
						s.addCPUTime();
						
					}
					if (ln.startsWith("I")){
						counter++;
						Random random = new Random();
						int num = random.nextInt(100);
						pcb.setState(ProcessStates.WAIT);
					}
					if (ln.startsWith("YIELD")){
						
					}
					if (ln.startsWith("OU")){
						proc();
						JOptionPane.showMessageDialog(null, programName + " is loaded");
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
		
		if (newProcess.isEmpty()){
			JOptionPane.showMessageDialog(null, "Ready Queue is empty");
		}
		JFrame cyclesFrame = new JFrame("Enter Number of Cycles");
		cyclesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel numberOfCyclesLabel = new JLabel("Number of Cycles: ", JLabel.LEFT);
		if (!newProcess.isEmpty()){
			
		
		JTextField numberOfCyclesText = new JTextField(10);
		
		cyclesFrame.add(numberOfCyclesLabel);
		cyclesFrame.add(numberOfCyclesText);
		
		cyclesFrame.setSize(200, 200);
		cyclesFrame.setVisible(true);

		numberOfCyclesText.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e){
				JTextField text = (JTextField) e.getSource();
				String textField = text.getText();
				text.setText(textField);
				numberOfCycles = Integer.parseInt(text.getText());
				cyclesFrame.getDefaultCloseOperation();
			} 
		}
		);
		
		}
		
		

	}
		
	public void reset() {
			
			Clock clock = new Clock();
			clock.resetClock();
			
	}
		
	public void promptUser(){
			
	}
	public void exit() {
		mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
	}
		
}

