package example;
/**
 * This is an example of a room for an intermediate programmer. It showcases the use of fields, booleans and arrays
 */
import caveExplorer.CaveRoom;
import caveExplorer.Door;

public class IntermediateRoom extends CaveRoom {

	//this is an "instance variable" or "field" that describes the start of the 
	//treasure in the room. 'true' for available to pick up, 'false' for having already been picked up
	//this statement is called a declaration. It says there is a private variable called treasure  that is of type 'boolean'
	private boolean treasurePickedUp;
	//the whistle is the tool that unlocks the doors 
		private boolean whistleFound;

	
	public IntermediateRoom() {
		treasurePickedUp = false;
		whistleFound = false;
	}

	@Override
	public String getDescription() {
		//Instead of simply returning a string, a string is concatenated
		//from a variable string that describes the availability of the treasure
		//When a variable is created, the variable's type must be declared in Java. In this case 'describingTreasure' is a String
		String describingTreasure = "There is a beautiful jem resting on a pedastal in the center of the room.";
		String describingJAction = " \n   - Press 'J' to grab the treasure.";
		String describingKAction = "";
		//treasure is a boolean instance variable
		if(treasurePickedUp){
			describingTreasure = "There is a pedestal in the center of the room.";
			describingJAction = " \n   - Press 'J' to look around.";
		}
		if(whistleFound){
			describingKAction = " \n   - Press 'K' to blow the wooden whistle.";
		}
		
		String room = "A grand and ornate room that appears to belong in a palace rather than a cave. ";
		return room + describingTreasure+describingJAction+describingKAction;
	}

	@Override
	public String getActionJOutput() {
		//when J is entered, there are two results, if the gem has been taken, all the doors slam shut.
		//Otherwise, a magical whistle is discovered in one of the room's corners
		
		//output will be returned regardless of what happens, but value differs
		String output;
		if(!treasurePickedUp && !whistleFound){
			for(Door d: getDoors()){
				d.setOpen(false);
				d.setLock(true);
			}
			output = "All of the doors slam shut. You hear a bolt sliding into place on each one. Paniced, you try the nearest door. It doesn't budge.";
			//the treasure is no longer available
			treasurePickedUp = true;
		}else if (!whistleFound){
			output = "You pick up the whistle and slip it in your pocket";
			whistleFound = true;
		}else{
			output = "Unfortunately, your search yields no new discoveries.";
		}
		//in Java, this is a 'for-each loop'
		//it is read as "for each Door, d, in the (array of doors)"
		//in this application, this loop closes and locks all the doors.
		//Note that 
		
		return output;
	}

	@Override
	public String getActionKOutput() {
		String output;
		if(whistleFound){
			for(Door d: getDoors()){
				d.setOpen(true);
				d.setLock(false);
			}
			output = "All of the doors reopen. This is some whistle. It might be useful later.";
			
		}else{
			output = "Nothing happens, of course";
		}
		return output;
	}

	@Override
	public String getActionJDescription() {
		if(!treasurePickedUp){
			return "You greedily snatch up the treasure, only to find that it was an illusion. There is no treasure. But suddenly...";
			//after the return statement, this method call is finished. The code below will not execute.
		}else if(!whistleFound){
			return "You begin searching the room, first by pacing the center, then by carefully examinging the reoom's perimeter. You figure there must be some way to escape... a key, maybe a secret exit... then you find a wooden whistle in the far corner of the room.";
			
		}
		return "The room is very pretty. You figure, why not look around a little longer?";
	}

	@Override
	public String getActionKDescription() {
		if(whistleFound){
			return "You blow the whistle. It sounds like a train.";
			//after the return statement, this method call is finished. The code below will not execute.
		}
		return "You hum a little song to yourself.";
	}

}
