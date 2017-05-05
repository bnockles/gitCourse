package caveExplorer;

public abstract class CaveRoom {

	private String directions;
	private String contents;
	private String defaultContents;
	public static final String defaultActionText ="You gesture about wildly.";
	public static final String defaultActionOutput ="Nothing happens.";
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	private boolean explored;

	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;


	
	public CaveRoom(){
		setDefaultContents(" ");
		contents = defaultContents;
		explored = false;
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		for(int i = 0 ; i < borderingRooms.length; i++){
			borderingRooms[i] = null;
			doors[i] = null;
		}
		setDirections();
	}

	protected void setDirections() {
		directions	= "";
		if(doors[NORTH] == null && 
				doors[EAST] == null &&
				doors[SOUTH] == null &&
				doors[WEST] == null){
			directions = "\n\nThis is a room with no exit. You will die here.";		
		}else{
			for(int dir = 0; dir < doors.length; dir++){
				if(doors[dir] != null){
					directions += "\n   There is a "+doors[dir].getDescription()+" to "+toDirection(dir)+". "+doors[dir].getDetails();
				}
			}
		}
	
	}
	
	public final String getDirections(){
		return directions;
	}

	public static String toDirection(int dir) {
		String[] directions = {"the North","the East",
				"the South", "the West"};
		
		return directions[dir];
	}

	public String getContents(){
		return contents;
	}
	
	/**
	 * 
	 * This code is executed IMMEDIATELY after a CaveRoom is entered. 
	 * This happens even before the description of the room is printed
	 * Default sets the contents to 'X' (to represent the presence of a player)
	 * 
	 */
	public void enter(){
		contents = "X";
	}
	
	/**
	 * if the door had contents (visible on the map) this icon is restored to contents (replacing the 'X' that represents the location of that player
	 */
	public void leave(){
		contents = defaultContents;
	}
	
	public void setDefaultContents(String symbol){
		defaultContents = symbol;
	}
	

	/**
	 * 
	 * @param direction the direction of the room being added
	 * @param anotherRoom the room to connect to
	 * @param door the door that must be passed through to enter the room
	 * 
	 * After this method is called, whichever door had previously been in the direction is 
	 * replaced with another room
	 */
	public void addRoom(int direction, CaveRoom anotherRoom, Door door){
		borderingRooms[direction] = anotherRoom;
		doors[direction] = door;
		setDirections();
	}
	
	/**
	 * Gives this room access to anotherRoom (and vice-versa) and
	 * sets a door between them, and updates the directions
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door){
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}

	/**
	 * 
	 * @param dir
	 * @return opposite direction of dir (NORTH returns SOUTH...)
	 */
	public static int oppositeDirection(int dir){
		return (dir+2)%4;
	}

	
	public abstract String getDescription();
	

	
	public Door getDoor(int dir){
		return doors[dir];
	}



	





	public final CaveRoom getBorderRoom(int index) {
		return borderingRooms[index];
	}

	public String getActionIOutput() {
		return defaultActionOutput;
	}
	
	/**
	 * 
	 * @return a String describing the results AFTER pressing the 'J' button
	 * For example: "return "There is not one to reply to your call.""
	 */
	public abstract String getActionJOutput();
	
	/**
	 * 
	 * @return a String describing the results AFTER pressing the 'K' button
	 * For example: "return "The monster cowers in fear. You can safely proceed.""
	 */
	public abstract String getActionKOutput();
	

	public String getActionLOutput() {
		return defaultActionOutput;
	}
	
	public final Door[] getDoors() {
		int count = 0;
		for(Door d: doors){
			if (d!= null) count ++;
		}
		Door[] nonNullDoors = new Door[count];
		count = 0;
		for(Door d: doors){
			if (d!= null){ 
				nonNullDoors[count] = d;
				count ++;			
			}
		}
		return nonNullDoors;
	}
	
	public String getActionIDescription() {
		return defaultActionText;
	}
	
	/**
	 * 
	 * @return a String describing what the user "does" when 'J' is entered. For example: "return "You scream for help.""
	 */
	public abstract String getActionJDescription();
	
	/**
	 * 
	 * @return a String describing what the user "does" when 'K' is entered. For example "return "You draw your sword...""
	 */
	public abstract String getActionKDescription();
	

	public String getActionLDescription() {
		return defaultActionText;
	}

	/**
	 * 
	 * @param index the direction the user wishes to exit through
	 * @return whether or not the door in the direction 'index' is blocked (i.e. by a monster)
	 */
	public boolean exitIsBlocked(int index) {
		return false;
	}

	
	/**
	 * 
	 * @param  index the direction the user wishes to exit through
	 * @return a description of the obstacle blocking the exit
	 */
	public String getObstacleDescription(int indexFound) {
		return "There is nothing in your way in this direction";
	}

	public final boolean isExplored() {
		return explored;
	}

	public final void setExplored(boolean explored) {
		this.explored = explored;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
 