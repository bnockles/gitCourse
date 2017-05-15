package example;

import caveExplorer.CaveRoom;

public class TofrRoom extends CaveRoom {

	//the basic room has no fields
	
	public TofrRoom() {
		//the constructor in the basic room does nothing
	}

	
	/**
	 * This method describes this room. Notice that in Java, a string must be surrounded by quotation marks
	 */
	@Override
	public String getDescription() {
		//notice how the following character combination:
		//     \n
		//creates a new line when displayed in-game
		//I use the 'newline character' to visually separate the movement choices.
		return "A cavernous space dimly lit by torches mounted on the walls. This room smells musty. "
				+ "You wonder how long it has been since someone last arrived.\n   Enter 'J' to yell aloud.\n   Enter 'K' to stomp on the ground";
	}

	/**
	 * This method is called after the 'J' key is entered.
	 */
	@Override
	public String getActionJOutput() {
		return "Your voice echoes off the walls, but nothing else appears to happen.";
	}

	/**
	 * This method is called after the 'K' key is entered.
	 */
	@Override
	public String getActionKOutput() {
		return "It sounds as if there is space under the ground. An underground tunnel, perhaps?";
	}

	/**
	 * This method describes what happens when the 'J' key is entered.
	 */
	@Override
	public String getActionJDescription() {
		//Note that when you wish to include quotation marks in a string
		//you must use the 'escape character', '\' before each mark
		return "You scream, \"Is anybody HERE!?\"";
	}

	/**
	 * This method describes what happens when the 'K' key is entered.
	 */
	@Override
	public String getActionKDescription() {
		return "You stomp on the ground";
	}

}
