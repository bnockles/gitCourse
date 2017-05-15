package customRooms;

import caveExplorer.CaveRoom;

public class ChristaRoom extends CaveRoom {

	public ChristaRoom() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "You are in a dusty bell tower in an empty church in a small, desolate town on the northern border of New Mexico.";
	}

	@Override
	public String getActionJOutput() {
		// TODO Auto-generated method stub
		return "Press J to ring the bell and call the town's residents \n"
				+ "into the town square in order to warn them of attack octokitties approaching.";
	}

	@Override
	public String getActionKOutput() {
		// TODO Auto-generated method stub
		return "Press K to climb down the ladder of the \n"
				+ "bell tower, walk out of the church and drive away from the town \n"
				+ "without warning the residents of the imminent danger.";

	}

	@Override
	public String getActionJDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getActionKDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
