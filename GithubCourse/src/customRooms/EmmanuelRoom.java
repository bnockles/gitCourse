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
			output = "It is now " + hour + ":" + min;
	}

}
