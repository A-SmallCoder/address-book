package contact;
/**
 * @author Andrew-Lloyd Small
 */

/**
 * service class for Name management
 *
 */
public class Name {
	private String firstName;
	private String lastName;
	
	/**
	 * constructor for Name class
	 * @param firstName
	 * @param lastName
	 */
	public Name (String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * 
	 * @return firstname
	 */
	public String getFirstName () {
		return this.firstName;
	}
	
	/**
	 * 
	 * @return lastname
	 */
	public String getLastName () {
		return this.lastName;
	}
	
	/**
	 * sets lastname to parameter taken
	 * @param newName
	 */
	public void changeLastName (String newName) {
		this.lastName = newName;
	}
}
