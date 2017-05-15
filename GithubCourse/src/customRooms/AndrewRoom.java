package customRooms;

import caveExplorer.CaveRoom;

public class AndrewRoom extends CaveRoom {

	public AndrewRoom() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "This place is totally chill...no chilly... \n"
				+"It's so cold the vapor from your breathe starts to freeze in mid-air and you start shivering \n"
				+"Enter 'J' to bundle up and start doing burpees.\n   Enter 'K' to lie on the ground and go into the fetus position. ";
	}

	@Override
	public String getActionJOutput() {
		// TODO Auto-generated method stub
		return "Great job - you survived and your legs are burning!";
	}

	@Override
	public String getActionKOutput() {
		// TODO Auto-generated method stub
		return "and you start to feel warm...this is the last thought you have...";
	}

	@Override
	public String getActionJDescription() {
		// TODO Auto-generated method stub
		return "You did 20 burpees";
	}

	@Override
	public String getActionKDescription() {
		// TODO Auto-generated method stub
		return "Eventually you stop shivering...";
	}

}
