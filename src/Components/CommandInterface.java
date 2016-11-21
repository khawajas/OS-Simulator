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
import java.io.FileReader;
import java.io.IOException;
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

public class CommandInterface {
	//Executes commands to the Operating System and the simulators
	
	long memory;
	int memoryValue;
	int counter = 0;
	String line = null;
	String programName = null;
	String num;
	int numberOfCycles;
	Queue<String> newProcess = new LinkedList<String>();
	
	private JFrame mainFrame;
	private JPanel controlPanel;
	
	public CommandInterface(){
		prepareGUI();
	}
	
	public static void main(String[] args) throws IOException{
		
		CommandInterface commandInterface = new CommandInterface();
		commandInterface.runGUI();
		
		//commandInterface.load("jobFile.txt");
		
		
	}
	
	public void prepareGUI() {
		mainFrame = new JFrame("Operating System Interface");
		mainFrame.setSize(900, 900);
		
		mainFrame.setLayout(new GridLayout(3,1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		
		
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		//JTable table = new JTable();
		
		//JScrollPane tableContainer = new JScrollPane(table);
		//controlPanel.add(tableContainer, BorderLayout.CENTER);
		
		mainFrame.getContentPane().add(controlPanel);
		
		
		mainFrame.add(controlPanel);
		//mainFrame.add(table);
		mainFrame.setVisible(true);
	}
	private void runGUI() {
		
		
		JLabel commandLabel = new JLabel("Command: ", JLabel.RIGHT);
		final JTextField commandText = new JTextField(10);
		JLabel numberOfCyclesLabel = new JLabel("Number of Cycles: ", JLabel.RIGHT);
		final JTextField numberOfCyclesText = new JTextField(10);
		JButton executeButton = new JButton("Execute");
		executeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = commandText.getText();

				switch (command) {
				case "PROC":
					
					proc();
					break;
				case "MEM":
					JLabel memoryLabel = new JLabel("",JLabel.LEFT);
					memoryLabel.setText(mem());
					controlPanel.add(memoryLabel);
					mainFrame.setVisible(true);
					break;
				case  "LOAD":
					try {
						load("jobFile.txt");
					} catch (IOException e1) {
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
		controlPanel.add(numberOfCyclesLabel);
		controlPanel.add(numberOfCyclesText);
		
		controlPanel.add(executeButton);
		mainFrame.setVisible(true);
		
	}
	
	
	
	
	
	
	public void proc(){
		String[] col = {"Process State", "CPU Time Needed", "CPU Time Used", "Priority", "Number of I/O Requests"};
		DefaultTableModel  tableModel = new DefaultTableModel(col, 0);
		JTable table = new JTable(tableModel);
		JScrollPane tableContainer = new JScrollPane(table);
		tableContainer.getViewport().setViewPosition(new Point(5,5));
		mainFrame.add(tableContainer, BorderLayout.CENTER);
		mainFrame.setSize(300, 150);
		//controlPanel.setLayout(new BorderLayout());
		//controlPanel.add(tableContainer, BorderLayout.CENTER);
		//controlPanel.add(tableContainer,  BorderLayout.PAGE_START);
		//mainFrame.getContentPane().add(controlPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);
		
	}
	
	//	current usage of memory
	public String mem(){
		Runtime runtime = Runtime.getRuntime();
		memory = runtime.totalMemory() - runtime.freeMemory();
		String num = Long.toString(memory);
		String output = "Memory used: "+ num;
		return output;
			
	}
	//read a program file by name, called in load method when "EXE" is read
	public void readProgramFile(String name){
		int counter = 0;
		String program = name;
		FileReader reader = null;
		String line = null;
		try {
			reader = new FileReader(program);
			BufferedReader bReader = new BufferedReader(reader);
			while((line = bReader.readLine()) != null) {
				counter++;
				if (counter == 1){
				 memoryValue = Integer.parseInt(bReader.readLine());
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
	public void load(String name) throws IOException{
			File f = new File(name);
			line = null;
			
				BufferedReader bRead = new BufferedReader(new FileReader(f));
				
				while((line = bRead.readLine()) != null) {
					programName = null;
					
					String command = null;
					
					
					if (line.contains(" ")) {
						
						command = line.substring(0, line.indexOf(" "));
						newProcess.add(command);
						num = line.substring(line.indexOf(" "), line.lastIndexOf(" "));
						newProcess.add(num);
						programName = line.substring(line.lastIndexOf(" "), line.length());	
						List<String> newProcessList = new ArrayList<String>(newProcess);
					} 
					
					if (line.startsWith("EXE")){
						readProgramFile(programName);
						
					}
					
					
				
					
				} 
				
			//} catch (IOException e) {
			//	System.out.println("no");
			}
			
	

	//getter for program file name
	public String getProgramName(){
		return programName;
	}
	
	//	
	public void exe() {
		
		
		
		
			
	}
		
	public void reset() {
			mainFrame.repaint();
			mainFrame.setVisible(true);
	}
		
	public void promptUser(){
			
	}
	public void exit() {
		mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
	}
		
}

