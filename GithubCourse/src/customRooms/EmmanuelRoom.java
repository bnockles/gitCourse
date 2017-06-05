package customRooms;

import caveExplorer.CaveRoom;
import java.util.Date;
import javax.swing.JOptionPane;

public class EmmanuelRoom extends CaveRoom{
	
	Date today;
	Date lastDayOfSchool = new Date(2017-1900, 5, 28,15,20,13);
	public EmmanuelRoom() {
		// TODO Auto-generated constructor stub
		today = new Date();
	}
	
	public String getDescription()
	{
		int hour = today.getHours()%12;
		int min = today.getMinutes();
		String output;
		
		int month = today.getMonth()+1;
		int date = today.getDate();
		int year = today.getYear() + 1900;
		
		output = "You walk into the room and notice that there are only 2 things in the room."
				+"\n A big sign and a time machine.";
		output += "\n The sign says ";
		output += "\"Today is " + month + "/" + date + "/" + year + " and the time is ";
		if(min<10)
			output = hour + ":0" + min+"\".\n";
		else
			output = hour + ":" + min+"\".\n";
		
		
		System.out.println("***************************************"+lastDayOfSchool);
		long ms = lastDayOfSchool.getTime() - today.getTime();
		long secs = ms/1000;
		long mins = secs/60;
		long hours = mins/60;
		long days = hours/24;
		
		System.out.println("***************************************"+days);
		
		output += "You have the  option to move forward in time to the last day of school!!";
		output += "\nTo do this you must input into a keypad how many minutes from NOW to the last day of school!";
		output += "\nBUT be warned if you answer wrong there will be consequences!";
		output += "\nPRESS K to get the current time";
		output += "\nPRESS J to answer the question";
		
		
		return output;
	}
	@Override
	public String getActionKOutput() {
		
		today = new Date();
		int hour = today.getHours()%12;
		int min = today.getMinutes();
		String output;
		
		int month = today.getMonth()+1;
		int date = today.getDate();
		int year = today.getYear() + 1900;
		output += "\"Today is " + month + "/" + date + "/" + year + " and the time is ";
		if(min<10)
			output = hour + ":0" + min+"\".\n";
		else
			output = hour + ":" + min+"\".\n";
		return output;
	}

	@Override
	public String getActionJOutput() {
		// TODO Auto-generated method stub
		long ms = lastDayOfSchool.getTime() - today.getTime();
		long secs = ms/1000;
		long mins = secs/60;
		long hours = mins/60;
		long days = hours/24;
		
		String answer = JOptionPane.showInputDialog("How many minutes left until the last day of school?");
		
		int ans = Integer.parseInt(answer);
		
		if(ans == mins)
			return "You are correct, it is now the last day of school! enjoy your summer!";
		else
			return "You are wrong, it is now the first day of school! :-(";
		
	
	}

	@Override
	public String getActionJDescription() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getActionKDescription() {
		// TODO Auto-generated method stub
		return "";
	}

}
