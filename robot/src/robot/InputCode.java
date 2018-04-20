package robot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import states.East;
import states.North;
import states.South;
import states.State;
import states.West;

public class InputCode {
	
	public static void main(String[] args){
	      Robot robot = new Robot();
	      CommandToRobot turnLeft = new Left(robot);
	      CommandToRobot turnRight = new Right(robot);
	      CommandToRobot report = new Report(robot);
	      CommandToRobot move = new Move(robot);
	      CommandInvoker commander = new CommandInvoker();
	      
	      File file = new File("/Users/vibhanshu/Desktop/workspace/robot/src/robot/inputFile.txt");
		  BufferedReader br = null;
			try {
			 br = new BufferedReader(new FileReader(file));
			String buffer = null ;		
				while((buffer=br.readLine())!=null){
					String[] command = buffer.split(" ");
					if(command[0].equalsIgnoreCase("MOVE")){
					commander.storeAndExecute(move);	
					}else if(command[0].equalsIgnoreCase("REPORT")){
					 commander.storeAndExecute(report); 	
					}else if(command[0].equalsIgnoreCase("LEFT")){
					 commander.storeAndExecute(turnLeft);
					}else if(command[0].equalsIgnoreCase("RIGHT")){
					 commander.storeAndExecute(turnRight);
					}else if(command[0].equalsIgnoreCase("PLACE")){
						StringTokenizer data = new StringTokenizer(command[1],",");
						String x = data.nextToken();
						String y = data.nextToken();
						String direction = data.nextToken();
					    robot.place(Integer.parseInt(x), Integer.parseInt(y), direction)	;
					}						
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
	   }
	
  }
