package customRooms;

import caveExplorer.CaveRoom;

public class ArendRoom extends CaveRoom {
	
	private boolean glassPickedUp;
	private boolean beerPoured;

	public ArendRoom() {
		glassPickedUp = false;
		beerPoured = false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String room = "The room is hazy and humid and smells like sweet oatmeal.\n"+
		"You recognize this smell. It's a brewery. Magic happens here.\n" + 
		"There is collection of large conical vessels in one corner.\n  There is a valve near the bottom of each.\n" +
		"There is also a shelf lined with glasses.\n";
		String choice = "Do you pick up a glass? Turn a valve? One and then the other?\n Press j to grab a glass and k to turn the valve.\n";
		return room + choice;
	}

	@Override
	public String getActionJOutput() {
		String glass;
		// TODO Auto-generated method stub
		if(beerPoured){
			glass = "Place the glass under the spout next time.";
		}
		else{
			glass = "You are holding the glass.";
		}
		return glass;
	}

	@Override
	public String getActionKOutput() {
		// TODO Auto-generated method stub
		String beerCollected;
		if(glassPickedUp){
			beerCollected = "You fill a glass with a beautiful hazy elixir. A heady aroma of cirtus and pine wafts up. Well done.";
		}
		else{
			beerCollected = "You turn the valve and a hazy liquid gushes onto the floor. Ouch, what a waste.";
		}
		return beerCollected;
	}

	@Override
	public String getActionJDescription() {
		// TODO Auto-generated method stub
		glassPickedUp = true;
		return "You pick up a glass";
		
	}

	@Override
	public String getActionKDescription() {
		// TODO Auto-generated method stub
		beerPoured = true;
		return "Whoops.";
	}
		
}

