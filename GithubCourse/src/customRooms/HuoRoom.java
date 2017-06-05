package customRooms;

import caveExplorer.CaveRoom;

public class HuoRoom extends CaveRoom {

	public HuoRoom() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		
		return "You are now in Huo's room. Welcome!\nPress\'J\' to ask for dinner.\nPress\'K\'to say \"hi\".";
	}

	@Override
	public String getActionJOutput() {
		
		return "Be our guest~ be our guest~Put our service to...(singing, dancing)";
	} 

	@Override
	public String getActionKOutput() { 
		return "Hi~~~~~~~~~";
	}

	@Override
	public String getActionJDescription() {
		// TODO Auto-generated method stub
		return "Dinner!";
	}
 
	@Override
	public String getActionKDescription() {
		// TODO Auto-generated method stub
		return "Hi";
	}

}
