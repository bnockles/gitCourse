package example;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.DefaultRoom;
import caveExplorer.Door;
import caveExplorer.EventRoom;
import caveExplorer.GameStartEvent;
import caveExplorer.Inventory;

public class ExampleGame extends CaveExplorer {

	public static ExpertRoomA expertRoomA;
	public static ExpertRoomB expertRoomB;

	public ExampleGame() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		in = new Scanner(System.in);
		setUpCaves();
		win = false;
		exploring = true;
		inventory = new Inventory();
		inventory.setMap(true);
		startExploring();
	}

	protected static void setUpCaves() {
		caves = new CaveRoom[3][3];
		for(int i = 0; i < CaveExplorer.caves.length; i++){
			for(int j = 0; j < CaveExplorer.caves[i].length; j++){
				caves[i][j] = new BasicRoom();
			}
		}



		caves[0][2] = new IntermediateRoom();
		expertRoomA = new ExpertRoomA();
		caves[1][2] = expertRoomA;
		expertRoomB = new ExpertRoomB();
		caves[1][0] = expertRoomB;

		currentRoom = caves[1][1];
		currentRoom.enter();
		currentRoom.setExplored(true);
		caves[0][0].setConnection(CaveRoom.EAST,CaveExplorer.caves[0][1],new Door());
		caves[0][1].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[1][1],new Door());
		caves[0][1].setConnection(CaveRoom.EAST,CaveExplorer.caves[0][2],new Door());
		caves[1][1].setConnection(CaveRoom.WEST,CaveExplorer.caves[1][0],new Door());
		caves[1][1].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[2][1],new Door());
		caves[2][1].setConnection(CaveRoom.EAST,CaveExplorer.caves[2][2],new Door());
		caves[2][2].setConnection(CaveRoom.NORTH,CaveExplorer.caves[1][2],new Door());

	}


}
