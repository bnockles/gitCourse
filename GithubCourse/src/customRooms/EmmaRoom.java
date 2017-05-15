package customRooms;

import caveExplorer.CaveRoom;

public class EmmaRoom extends CaveRoom {

	public EmmaRoom() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "You have entered a large, well-lit room.  Is this really a cave?";
	}

	@Override
	public String getActionJOutput() {
		// TODO Auto-generated method stub
		return "Suddenly, the room goes dark";
	}

	@Override
	public String getActionKOutput() {
		// TODO Auto-generated method stub
		return "ouch!";
	}

	@Override
	public String getActionJDescription() {
		// TODO Auto-generated method stub
		return "What's going on?";
	}

	@Override
	public String getActionKDescription() {
		// TODO Auto-generated method stub
		return "The lighting is good, but the ceiling is low.  You bump your head.";
	}

}
