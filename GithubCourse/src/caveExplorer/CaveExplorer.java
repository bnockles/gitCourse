package caveExplorer;


import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][] caves;
	public static Scanner in;
	public static CaveRoom currentRoom;
	public static Inventory inventory;

	
	public static void main(String[] args){
		in = new Scanner(System.in);
		setUpCaves();

		inventory = new Inventory();
		startExploring();
	}

	private static void setUpCaves() {
		CaveExplorer.caves = new CaveRoom[5][5];
		for(int i = 0; i < CaveExplorer.caves.length; i++){
			for(int j = 0; j < CaveExplorer.caves[i].length; j++){
				CaveExplorer.caves[i][j] = new DefaultRoom("This cave has coordinates "+i+", "+j);
			}
		}
		CaveExplorer.caves[0][2] = new EventRoom("This is the room"
				+ " where that guy with a tail met you.",
				new GameStartEvent());
		CaveExplorer.currentRoom = CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		CaveExplorer.caves[0][1].setConnection(CaveRoom.EAST,CaveExplorer.caves[0][2],new Door());
		CaveExplorer.caves[0][2].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[1][2],new Door());
		CaveExplorer.caves[1][2].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[2][2],new Door());
	}
	
	private static void startExploring() {
		
		while(true){
			System.out.println(inventory.getDescription());
			System.out.println(currentRoom.getDescription());
			System.out.println(currentRoom.getDirections());
			System.out.println("What would you like to do?");
			String input = in.nextLine();
			interpretInput(input);
		}
	}
	
	public static boolean isValid(String s){
		String[] keys = {"w","a","s","d"};
		for(String key:keys){
			if (s.equals(key))return true;
		}
		return false;
	}
	
	private static void interpretInput(String input) {
		while(!isValid(input)){
			System.out.println("You can only enter "
					+ "'w','a','s', or 'd' to move or 'i','j','k', or 'l' to try an action.");
			input = CaveExplorer.in.nextLine();
		}
		String[] keys = {"w","d","s","a", "i","j","k","l"};
		int indexFound = -1;
		for(int i = 0; i < keys.length; i++){
			if(input.equals(keys[i])){
				indexFound = i;
				break;
			}
		}
		//directional input
		if(indexFound >-1 && indexFound < 4){
			if(!currentRoom.exitIsBlocked(indexFound)){
				goToRoom(currentRoom.getBorderRoom(indexFound), currentRoom.getDoor(indexFound));				
			}else{
				System.out.println(currentRoom.getObstacleDescription(indexFound));
			}
		}else{
			switch (indexFound){
			//i
			case 4:
				System.out.println(currentRoom.getActionIDescription());
				currentRoom.getActionIOutput();
				//j
			case 5:
				System.out.println(currentRoom.getActionJDescription());
				currentRoom.getActionJOutput();
				//k
			case 6:
				System.out.println(currentRoom.getActionKDescription());
				currentRoom.getActionKOutput();
				//l
			case 7:
				System.out.println(currentRoom.getActionLDescription());
				currentRoom.getActionLOutput();
			}
				
		}
	}

	public static void goToRoom(CaveRoom room, Door door){
		if(room != null &&
				door.isOpen()){
			currentRoom.leave();
			currentRoom = room;
			currentRoom.enter();
			inventory.updateMap();
		}
	}

	

	public static void print(String string) {
		System.out.println(string);
	}
	
	
}

















