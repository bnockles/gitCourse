package customRooms;

import caveExplorer.CaveRoom;
import java.util.Date;

public class EmmanuelRoom extends CaveRoom{
	
	Date today;
	
	public EmmanuelRoom() {
		// TODO Auto-generated constructor stub
		today = new Date();
	}
	
	public String getDescription()
	{
		int hour = today.getHours()%12;
		int min = today.getMinutes();
		String output;
		
		if(min<10)
			output = "It is now " + hour + ":0" + min;
		else
			output = "It is now " + hour + ":" + min;
		
		int month = today.getMonth();
		int date = today.getDate();
		int 
		
		return output;
	}
	@Override
	public String getActionKOutput() {
		return "Testing Emmanuel room1";
	}

	@Override
	public String getActionJOutput() {
		// TODO Auto-generated method stub
		return "Testing Emmanuel room2";
	}

	@Override
	public String getActionJDescription() {
		// TODO Auto-generated method stub
		return "Testing Emmanuel room3";
	}

	@Override
	public String getActionKDescription() {
		// TODO Auto-generated method stub
		return "Testing Emmanuel room4";
	}

}
