package example;

import caveExplorer.CaveRoom;

/**
 * 
 * @author Ben Nockles
 * This class represents half of a collaboration between two people. 
 * In this class, the player can choose a weapon that is required to defeat the ogre in the other room (ExpertRoomB)
 *
 */
public class ExpertRoomA extends CaveRoom {

	//CONSTANTS
	//The following fields are constants. Their values cannot be modified (as evidenced by the keyword "final"
	//they are "public" so ExperRoomB can access their values
	public static final String HALBERD = "rather rusty halberd";
	public static final String MACE = "massive mace";
	public static final String SWORD = "short sword";
	public static final String CINDERELLA_TOOTHBRUSH = "Cinderella toothbrush";
	public static final String WEAPONLESS = "no weapon";


	//FIELDS
	private String weapon;
	//this is an array in Java. In Java, arrays are of a constant size. Here, we declar and instantiate it
	private static String[] weaponSelection = {HALBERD, MACE, SWORD, CINDERELLA_TOOTHBRUSH};
	//design-wise I am mapping each weapon to a button by listing the button names in a parallel array
	//Note: I could also use a 2D array to do this, but this is easier to read for people who may be unfamiliar with Java :)
	private static String[] buttonSelection = {"I","J", "K", "L"};

	public ExpertRoomA() {
		weapon = WEAPONLESS;

	}

	@Override
	public String getDescription() {
		String description = "A room littered with discarded weapons of varying sizes, conditions, and types. Each looks deadly, but then you notice something purple among the clutter of iron objects. It appears to be a Cinderella toothbrush, made by Oral B for chilrdren between the ages of 2 and 5.";

		if(weapon.equals(WEAPONLESS)){
			description +="\nYou are currently without a weapon.";
		}else{
			description+= "\n You are currently weilding the "+weapon+".";

		}
		//in Java, this is a standard loop
		//it creates an index and increases it after each execution of the loop body until the condition, (index < weaponSelection.length) is false
		for(int index = 0; index < weaponSelection.length; index++){{
			if (weapon != weaponSelection[index]){
				description+="\n   - Enter '"+buttonSelection[index]+"' to pick up "+weaponSelection[index]+".";				
			}else{
				description+="\n   - Enter '"+buttonSelection[index]+"' to to put back the "+weaponSelection[index]+".";
			}
		}

		}

		return description;
	}

	//a helper method to quickly swap weapons
	private String swapWeapons(String weaponName){
		if (weapon.equals(weaponName)){
			weapon = WEAPONLESS;
			return "You set down the "+weaponName+".";
		}else{
			weapon = weaponName;
			return "You picked up the "+weaponName+".";
		}
	}

	//a helper method to quickly swap weapons
	private String describeWeapons(){
		if (weapon.equals(HALBERD)){
			return "It feels off-balance. ";
		}else if (weapon.equals(MACE)){
			return "It's so heavy and intimidating! ";
		}else if (weapon.equals(SWORD)){
			return "It makes you feel like a hobbit";
		}else if (weapon.equals(CINDERELLA_TOOTHBRUSH)){
			return "What a wonderful little instrument. You know brushing with it would make you feel like a princess.";
		}else{
			return "You feel tougher fighting with your bare fists anyway.";
		}
	}

	/**
	 * Note: This method is not required. It OVERRIDES a method in the CaveRoomClass
	 */
	@Override
	public String getActionIOutput() {
		return describeWeapons();
	}

	@Override
	public String getActionJOutput() {
		return describeWeapons();
	}

	@Override
	public String getActionKOutput() {
		// TODO Auto-generated method stub
		return describeWeapons();
	}


	/**
	 * Note: This method is not required. It OVERRIDES a method in the CaveRoomClass
	 */
	@Override
	public String getActionLOutput() {
		return describeWeapons();
	}


	/**
	 * Note: This method is not required. It OVERRIDES a method in the CaveRoomClass
	 */
	@Override
	public String getActionIDescription() {
		return swapWeapons(HALBERD);
	}

	@Override
	public String getActionJDescription() {
		return swapWeapons(MACE);
	}

	@Override
	public String getActionKDescription() {

		return swapWeapons(SWORD);
	}

	/**
	 * Note: This method is not required. It OVERRIDES a method in the CaveRoomClass
	 */
	@Override
	public String getActionLDescription() {
		return swapWeapons(CINDERELLA_TOOTHBRUSH);
	}
	
	/**
	 * This method is used by ExpertRoomB. If the weapon is the toothbrush, the player is equipted to defeat the ogre.
	 * @return
	 */
	public String getWeapon(){
		return weapon;
	}

}
