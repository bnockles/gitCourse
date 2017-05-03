/**
 * 
 */
package caveExplorer;

/**
 * @author bnockles
 *
 */
public class DefaultRoom extends CaveRoom {

	private String description;
	/**
	 * @param description
	 */
	public DefaultRoom(String description) {
		super();
		this.description = description;
	}
	
	
	public String getActionJOutput() {
		return defaultActionOutput;
	}
	
	public String getActionKOutput() {
		return defaultActionOutput;
	}
	

	
	public String getActionJDescription() {
		return defaultActionText;
	}
	
	public String getActionKDescription() {
		return defaultActionText;
	}


	@Override
	public String getDescription() {
		return description;
	}
	
	

}
