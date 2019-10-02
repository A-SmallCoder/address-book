package contact;
/**
 * @author Andrew-Lloyd Small
 */

/**
 * service class for phone management
 *
 */
public class Phone {

	private long number;
	private char type;
	
	/**
	 * constructor for phone class
	 * @param number
	 * @param type
	 */
	public Phone (long number, char type) {
		this.number = number;
		this.type = type;
	}
	
	/**
	 * 
	 * @return first 3 digits of phone number
	 */
	public int getAreaCode () {
		String o = Long.toString(number);
		int areaCode = Integer.parseInt(o.substring(0,3));
		return areaCode;
	}
	
	/**
	 * 
	 * @return char associated with phone number indicating type
	 */
	public char getType() {
		return this.type;
	}
	
	/**
	 * 
	 * @return literal phone number
	 */
	public long getNumber() {
		return number;
	}
	
	/**
	 * returns phone number in format: (000) 000-000
	 */
	public String toString(){
		String o = Long.toString(number);
		int num1 = Integer.parseInt(o.substring(3,6));
		int num2 = Integer.parseInt(o.substring(6,9+1));
		return "(" + getAreaCode() + ") " + num1 + "-" + num2;
	}
}
