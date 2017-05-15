package customRooms;

import caveExplorer.CaveRoom;

public class DanielRoom extends CaveRoom {

	public DanielRoom() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "The Octocat Love Room. You, Jimmy and Katie are in this room together."
				+ "Jimmy asks Katie on a date! Katie does not know what to do."
				+ "Jimmy outlines the date itinerary for Katie: a romantic walk in the underwater park,"
				+ "an adventure through the binary, catnip forest, and then a special dinner of"
				+ "Octocat tentacles. Katie looks at you and asks, \"Should I go on the date?\""
				+ "Should Katie accept the date or not!?";
	}

	@Override
	public String getActionJOutput() {
		// TODO Auto-generated method stub
		return "You chose yes. Thus, you are okay with Octocat cannibalism.";
	}

	@Override
	public String getActionKOutput() {
		// TODO Auto-generated method stub
		return "You saved Katie from Octocat cannibalist Jimmy!";
	}
	
	@Override
	public String getActionJDescription() {
		// TODO Auto-generated method stub
		return "Katie has been eaten by Jimmy! It is all your fault. You condone Octocat cannibalism.";
	}

	@Override
	public String getActionKDescription() {
		// TODO Auto-generated method stub
		return "You are a hero! Not only do you feel"
				+ "good about yourself, but you also get an ice cream cake to celebrate..."
				+ "But then Daniel ate it, so you get nothing but good feelings :)";
	}

}
