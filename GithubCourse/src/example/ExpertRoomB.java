package example;

/**
 * In this room, the player comes face-to-face with an ogre. The only way to escape is to either run out of the room before the doors close 
 * or defeat the monster by brushing its teeth. You can only brush its teeth if you have the Cinderella toothbrush from ExpertRoomA
 */

import caveExplorer.CaveRoom;
import caveExplorer.Door;

public class ExpertRoomB extends CaveRoom{

	private boolean decidedToStay;
	private String weapon;
	private boolean battleWon;

	public ExpertRoomB() {
		decidedToStay = false;
		battleWon = false;
	}

/**
 * This method overrides a method in the CaveRoom class. The 'enter' method is called immediately upon entering a room. 
 * In this case, the 'weapon' field is updated to reflect whatever was taken from room ExperRoomA 
 */
	public void enter(){
		super.enter();
		this.weapon = ExampleGame.expertRoomA.getWeapon();
	}

	
	/**
	 * In this room, there are many different outputs depending on choices that were made at other points in the game
	 */
	@Override
	public String getDescription() {
		String initialDescription = "A terrifying room, there are human bones lining the perimeter. "
				+ "You suspect this is the liar of some sort of horrific beast. "
				+ "Perhaps you should turn around now.\n   Press 'J' to stay.\n   Press 'K' to leave now.";
		String laterDescription = "This is the liar of a horrible ogre. Ther doors are all locked. You must fight or die. You fist tightens around your " + weapon+".\n   Press 'J' to fight.";
		if(this.weapon.equals(ExpertRoomA.CINDERELLA_TOOTHBRUSH)){
			laterDescription+=" \n   Press 'K' to brush the monster's teeth.";
		}
		if(decidedToStay && !battleWon){
			return laterDescription;	
		}else if (!battleWon){
			return initialDescription;
		}else{
			return "A once terrifying room now simply houses an ogre with dramatically improved oral hygiene.";
		}
	}

	@Override
	public String getActionJOutput() {
		if(battleWon){
			return "The monster is still smiling.";
		}else if (decidedToStay){
			if(this.weapon.equals(ExpertRoomA.WEAPONLESS)){ 
				ExampleGame.lose();
				return "You don't even get a chance to throw a punch. In the blink of an eye, the ogre slices your body into two halves.";
			}else if (!this.weapon.equals(ExpertRoomA.CINDERELLA_TOOTHBRUSH)){
				ExampleGame.lose();
				return "Though you make a valiant effort, the ogre slaughters you.";

			}else{
				ExampleGame.lose();
				return "With great zeal, you begin slapping the ogre with the britles of the brush. It looks down on you, then literally bites your head off.";
			}
		}else{
			//lock all the doors
			for(Door d: getDoors()){
				d.setOpen(false);
				d.setLock(true);
			}
			decidedToStay = true;
			return "Then, from out of the shadows, a hideous ogre steps into the center of the room. As it roars, saliva spews from its mouth like a rabid animal. This creature must be twice your size, with skin like armor, fangs like a viper and claws like a lion. Its sinewy muscles ripple as it flexes in preparation for an attack.";
		}
	}

	@Override
	public String getActionKOutput() {
		if(battleWon){
			return "The monster is still smiling.";
		}else if (decidedToStay && weapon.equals(ExpertRoomA.CINDERELLA_TOOTHBRUSH)){
			//unlock all the doors
			for(Door d: getDoors()){
				d.setLock(false);
				d.setOpen(true);
			}
			battleWon = true;
			return "The monster cocks its head to the side, intrigued by the lovely blue dress designed by Ciderella's godmother. It scampers up to you on its fists like a gorrila, stopping inches before your face. You look it in the eyes, it looks you in the eyes. "
			+ "You look it in the eyes and say \"Open up and say, 'Aah'!\" \n The monster actually complies. "
			+ "Its breath wafts over you like a Yellowstone sulfuric geyser. "
			+ "You extend the toothbrush into the beast's mouth and slowly begin to brush its hideous fangs. The process takes about ten minutes, all the while, the beast holds perfectly still. \n When you finish, the beast flashes a beaming grin and scampers back into its monster den. The doors autmoatically reopen. You are free.";
		}else if (decidedToStay){
			return "...but no good ideas occur to you ";
		}else{
			ExampleGame.print("Fortunately, you are able to excape right before the door slams shut behind you. You would have been trapped!");
			ExampleGame.goToRoom(getBorderRoom(EAST), getDoor(EAST));
			return "";
		}
	}

	@Override
	public String getActionJDescription() {
		if(battleWon){
			return "There is nothing left to do here.";
		}else if (decidedToStay){
			if(this.weapon.equals(ExpertRoomA.WEAPONLESS)){ 
				return "Pathetically, you raise your fists to take on the ogre. You realize you are hopeless.";
			}else if (!this.weapon.equals(ExpertRoomA.CINDERELLA_TOOTHBRUSH)){
				return "Fearlessly, You raise your "+weapon+" and yell a fierce war cry.";
			}else{
				return "Like a lunatic, you raise your Cinderella toothbrush high into the air. The ogre grunts at you.";
			}
		}else{
			return "You determine it is best to stay and explore further.";
		}

	}

	@Override
	public String getActionKDescription() {
		if(battleWon){
			return "There is nothing left to do here.";
		}else if (decidedToStay && weapon.equals(ExpertRoomA.CINDERELLA_TOOTHBRUSH)){

			return "You pull out the Cinderella toothbrush and extend it in front of you, Cinderella artwork facing outward, like a vampre slayer wielding a cross. You don't have any better ideas. \n \"Let me brush you.\" you declare like some sort of intern dentist.";
		}else if (decidedToStay){
			return "You ponder your options for a moment...";
		}else{
			return "Something about this room bothers you and you decide its best to high tail it outta here.";
		}

	}

}
