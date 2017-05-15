package customRooms;

import caveExplorer.CaveRoom;

public class CorinneRoom extends CaveRoom {

	public CorinneRoom() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "I am a String";
	}

	@Override
	public String getActionJOutput() {
		// TODO Auto-generated method stub
		return "I am another String!";
	}

	@Override
	public String getActionKOutput() {
		// TODO Auto-generated method stub
		return "EXPLOSIONS!";
	}

	@Override
	public String getActionJDescription() {
		// TODO Auto-generated method stub
		return "More explosions!";
	}

	@Override
	public String getActionKDescription() {
		// TODO Auto-generated method stub
		return "POW!!!";
	}

}
