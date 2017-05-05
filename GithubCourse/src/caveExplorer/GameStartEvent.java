package caveExplorer;


public class GameStartEvent implements Event {

	public final String[] SEQ_1 = {
			"A dark figure approaches you from across the cave. There is something suspicious about the stranger's stride, is it limping?",
			"As the figure draw nearer, you realize a \"stride\" fails to describe the unusual movement. It's appears to be pulsing or rolling like some sort of amorphous  glob or... ",
			"...an octopus?",
			"It purrs as it heaves its gelatenous body toward you, moving into the light. The flicker of a torch reflects off its catlike eyes.",
			"You stand in stunned silence as it waves a tentacle in what appears to be a greeting.",
			"The \"octocat\" speaks, its voice reverberating along the walls of the cave like the hum of an engine.",
			"\"Welcome to the Dungeon of Git.\" it softly speaks."};
	public final String[] SEQ_2 = {
			"\"If you are COMMITed to learning Git, you have come to the right place.",
			"\"This is the HEAD of the path to Git mastery. This room BRANCHES off into many REPOSITORIES of great riches and deep secrets.",
			"\"Each repository is the work of a Git apprentice.",
			"\"PUSH and PULL your way through each repository to demonstrate you have MASTERed the apprentices' challenges",
			"\"And you will become the WIZARD OF GIT!",
			"\"Here is a map to aid you on your quest.\""};

	
	
	public GameStartEvent() {
		// TODO Auto-generated constructor stub
	}

	public void play() {
		readSequence(SEQ_1);
		CaveExplorer.print("What is your quest?");
		while(CaveExplorer.in.nextLine().toLowerCase().indexOf("git") < 0){
			CaveExplorer.print("Yeah sure. What are you REALLY here for?");
		}
		readSequence(SEQ_2);
		CaveExplorer.inventory.setMap(true);
	}

	public static void readSequence(String[] seq) {
		for(String s : seq){
			CaveExplorer.print(s);
			CaveExplorer.print(" - - - Press enter - - -");
			CaveExplorer.in.nextLine();
		}
	}

}















