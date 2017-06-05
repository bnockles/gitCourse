package customRooms;

import caveExplorer.CaveRoom;

public class ChristaRoom extends CaveRoom {

	public ChristaRoom() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "You are in a dusty bell tower in an empty church in a small, desolate town on the northern border of New Mexico. You have been warned of a dangerous \n"
				+ "pod of octokitties approaching. You have climbed up to the bell tower to warn the residents of the town about this terrible problem, but you realize \n"
				+ "that if you ring the bell, you might not make it out of the tower and into your car in time to leave the town before the octokitties find you. \n"
				+"Press J to ring the bell and call the town's residents \n"
				+ "into the town square in order to warn them of the pod of attack octokitties approaching.\n"
				+ "Press K to climb down the ladder of the \n"
				+ "bell tower, walk out of the church and drive away from the town \n"
				+ "WITHOUT warning the residents of the imminent danger. YOLO";
	}

	@Override
	public String getActionJOutput() {
		// TODO Auto-generated method stub
		return "You are a true hero! By calling the townfolks you can create an army that can take back your town together." ;
	}

	@Override
	public String getActionKOutput() {
		// TODO Auto-generated method stub
		return "Phew! You got in your car just in time! You race out of town and arrive in the neighboring town and stop in a local bar.";

	}

	@Override
	public String getActionJDescription() {
		// TODO Auto-generated method stub
		return "Press J to ring the bell and call the town's residents \n"
				+ "into the town square in order to warn them of the pod of attack octokitties approaching.";
	}

	@Override
	public String getActionKDescription() {
		// TODO Auto-generated method stub
		return "Press K to climb down the ladder of the \n"
				+ "bell tower, walk out of the church and drive away from the town \n"
				+ "WITHOUT warning the residents of the imminent danger. YOLO";
	}

}
