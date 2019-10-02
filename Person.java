package contact;
/**
 * @author Andrew-Lloyd Small
 */

/**
 * service class for person management
 *
 */
public class Person {

	private String firstName;
	private String lastName;
	private Gender gender;
	private long dob;
	
	/**
	 * constructor for person class
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param dob
	 */
	public Person (String firstName, String lastName, Gender gender, int dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
	}
	
	/**
	 * 
	 * @return name in format: firstname,lastname
	 */
	public String getName () {
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * 
	 * @return gender of person
	 */
	public Gender getGender () {
		return this.gender;
	}
	
	/**
	 * 
	 * @return dob of person
	 */
	public long getDOB () {
		return this.dob;
	}
	
	/**
	 * changes last name of the person
	 */
	public void changeLastName(String newname) {
		this.lastName = newname;
	}
}
