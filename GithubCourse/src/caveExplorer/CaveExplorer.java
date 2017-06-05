package caveExplorer;


import java.util.Scanner;

import customRooms.*;


public class CaveExplorer {

	public static CaveRoom[][] caves;
	public static Scanner in;
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	public static boolean win;
	public static boolean exploring;
	
	public static YuliaRoom yuliaRoom;
	public static ChristaRoom christaRoom;
	public static DanielRoom danielRoom;
	public static HuoRoom huoRoom;
//	public static RobertRoom robertRoom;
	public static ArendRoom arendRoom;
//	public static ShanuaRoom shuanaRoom;
	public static EmmanuelRoom emmanuelRoom;
	public static TofrRoom brownRoom;
//	public static EricRoom ericRoom;
	public static AndrewRoom andrewRoom;
	public static CorinneRoom corrineRoom;
	public static LynchRoom lynchRoom;

	
	public static void main(String[] args){
		in = new Scanner(System.in);
		setUpCaves();
		win = false;
		exploring = true;
		inventory = new Inventory();
		startExploring();
	}

	private static CaveRoom assignRoom(CaveRoom room, int r, int c){
		caves[r][c] = room;
		return room;
	}
	
	protected static void setUpCaves() {
		CaveExplorer.caves = new CaveRoom[4][4];
		for(int i = 0; i < CaveExplorer.caves.length; i++){
			for(int j = 0; j < CaveExplorer.caves[i].length; j++){
				CaveExplorer.caves[i][j] = new DefaultRoom("This cave has coordinates "+i+", "+j);
			}
		}
		yuliaRoom = (YuliaRoom) assignRoom(new YuliaRoom(),0,0);
		caves[0][1] = new EventRoom("This is the room"
				+ " where that creepy octopus-cat thing met you.",
				new GameStartEvent());
		christaRoom = (ChristaRoom) assignRoom(new ChristaRoom(),0,2);
		danielRoom = (DanielRoom) assignRoom(new DanielRoom(),0,3);
		arendRoom = (ArendRoom) assignRoom(new ArendRoom(),1,0);
//		robertRoom = assignRoom(new RobertRoom(),1,2);
		huoRoom = (HuoRoom) assignRoom(new HuoRoom(),1,3);
//		shaunaRoom = assignRoom(new ShaunaRoom(),2,0);
		emmanuelRoom = (EmmanuelRoom) assignRoom(new EmmanuelRoom(),2,1);
		brownRoom = (TofrRoom) assignRoom(new TofrRoom(),2,2);
//		ericRoom = assignRoom(new EricRoom(),2,3);
		lynchRoom = (LynchRoom) assignRoom(new LynchRoom(),3,0);
		corrineRoom = (CorinneRoom) assignRoom(new CorinneRoom(),3,1);
		andrewRoom = (AndrewRoom) assignRoom(new AndrewRoom(),3,2);

		caves[0][1]=christaRoom; //notes to self: testing change this room
		
		
		currentRoom = caves[1][1];
		currentRoom.enter();
		currentRoom.setExplored(true);
		caves[0][0].setConnection(CaveRoom.EAST,CaveExplorer.caves[0][1],new Door());
		caves[0][0].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[1][0],new Door());
		caves[0][1].setConnection(CaveRoom.EAST,CaveExplorer.caves[0][2],new Door());
		caves[0][1].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[1][1],new Door());
		caves[0][2].setConnection(CaveRoom.EAST,CaveExplorer.caves[0][3],new Door());
		caves[0][3].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[1][3],new Door());
		caves[1][0].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[2][0],new Door());
		caves[1][2].setConnection(CaveRoom.EAST,CaveExplorer.caves[1][3],new Door());
		caves[1][2].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[2][2],new Door());
		caves[2][0].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[3][0],new Door());
		caves[2][1].setConnection(CaveRoom.EAST,CaveExplorer.caves[2][2],new Door());
		caves[2][1].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[3][1],new Door());
		caves[2][2].setConnection(CaveRoom.EAST,CaveExplorer.caves[2][3],new Door());
		caves[2][3].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[3][3],new Door());
		caves[3][0].setConnection(CaveRoom.EAST,CaveExplorer.caves[3][1],new Door());
		caves[3][1].setConnection(CaveRoom.EAST,CaveExplorer.caves[3][2],new Door());
		caves[3][2].setConnection(CaveRoom.EAST,CaveExplorer.caves[3][3],new Door());
	}
	
	public static void lose(){
		exploring = false;
	}
	
	
	
	public static void print(String s){
		String newline = System.getProperty("line.separator");
		if(s!= null){
		String[] words = s.split(" ");
		int limit = 80;
		String toPrint = "";
		String line = "";
		int i = 0;
		
		while(i< words.length){
		while (line.length() < limit && i<words.length){
			if (words[i].contains(newline)){
				line += words[i].substring(0,words[i].indexOf(newline));
				i++;
				break;
			}
			line += words[i]+" ";
			i++;
		}
		toPrint+=line+"\n";
		
		line = "";
		}
		System.out.println(toPrint);
		}else{
			System.out.println("The author of this room did not write a description for what happens when you do that.");
		}
	}
	
	protected static void startExploring() {
		
		while(exploring){
			System.out.println(inventory.getDescription());
			print(currentRoom.getDescription());
			System.out.println(currentRoom.getDirections());
			print("What would you like to do?");
			String input = in.nextLine();
			interpretInput(input);
			checkWin();
		}
		if(win){
			print("You have explored all the rooms! You win!");
		}else{
			print("GAME OVER");
		}
	}
	
	private static void checkWin() {
		
		for(CaveRoom[] cs: caves){
			for(CaveRoom cv: cs){
				
				if(!cv.isExplored())return;
			}
		}
		exploring = false;
		win = true;
	}

	public static boolean isValid(String s){
		String[] keys = {"w","a","s","d","i","j","k","l"};
		for(String key:keys){
			if (s.equals(key))return true;
		}
		return false;
	}
	
	private static void interpretInput(String input) {
		while(!isValid(input)){
			print("You can only enter "
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
				print(currentRoom.getObstacleDescription(indexFound));
			}
		}else{
			switch (indexFound){
			//i
			case 4:
				print(currentRoom.getActionIDescription());
				print(currentRoom.getActionIOutput());
				break;
				//j
			case 5:
				print(currentRoom.getActionJDescription());
				print(currentRoom.getActionJOutput());
				break;
				//k
			case 6:
				print(currentRoom.getActionKDescription());
				print(currentRoom.getActionKOutput());
				break;
				//l
			case 7:
				print(currentRoom.getActionLDescription());
				print(currentRoom.getActionLOutput());
				break;
			}
			print(" - - Press 'Enter' - -");
				in.nextLine();
		}
	}

	public static void goToRoom(CaveRoom room, Door door){
		if(room != null &&
				door.isOpen()){
			currentRoom.leave();
			currentRoom = room;
			currentRoom.enter();
			currentRoom.setExplored(true);
			inventory.updateMap();
		}else if (room != null && !door.isOpen() && door.isLocked()){
			print("You cann't go out that way because the door is shut and locked. Maybe something in the room can help you open it.");
			print(" - - Press 'Enter' - -");
			in.nextLine();
		}
	}
	
	
}

















