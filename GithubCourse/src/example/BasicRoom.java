package example;

import caveExplorer.CaveRoom;

public class BasicRoom extends CaveRoom {

	//the basic room has no fields
	
	public BasicRoom() {
		//the constructor in the basic room does nothing
	}

	@Override
	public String getDescription() {
		//notice how the following character combination:
		//     \n
		//creats a new line when displayed in-game
		return "A cavernous space dimly lit by torches mounted on the walls. This room smells musty. "
				+ "You wonder how long it has been since someone last arrived.\n   Enter 'J' to yell aloud.\n   Enter 'K' to stomp on the ground";
	}

	@Override
	public String getActionJOutput() {
		// TODO Auto-generated method stub
		return "Your voice echoes off the walls, but nothing else appears to happen.";
	}

	@Override
	public String getActionKOutput() {
		return "It sounds as if there is space under the ground. An underground tunnel, perhaps?";
	}

	@Override
	public String getActionJDescription() {
		//Note that when you wish to include quotation marks in a string
		//you must use the 'excape character' '\' before each mark
		return "You scream, \"Is anybody HERE!?\"";
	}

	@Override
	public String getActionKDescription() {
		return "You stomp on the ground";
	}

}
