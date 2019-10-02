package contact;
/**
 * @author Petra Hamilton
 * ID: 620109569
 */

import java.util.ArrayList;

/**
 * 
 *service class for Address management
 */
public class Address {
	String a,b,c,d,e;
	String [] things;

	/**
	 * constructor for Address class
	 * splits string taken into separate lines and stores into an array
	 * @param address
	 */
	public Address(String address){
		things = address.split(";");
		this.a = things[0];
		this.b = things[1];
		this.c = things[2];
		this.d = things[3];
		this.e = things[4];
	}
	
	/**
	 * 
	 * @return last line of address (country)
	 */
	public String getCountry(){
		return this.e;
	}
	
	/**
	 * 
	 * @return array of lines in address
	 */
	public String[] getAddress(){
		ArrayList<String> holder = new ArrayList<String>();
		for (String i:things) {
			if (i != null) {
				holder.add(i);
			}else {
				continue;
			}
		}
		String [] ish = new String[holder.size()];
		ish = holder.toArray(ish);
		return ish;
	}
	
	/**
	 * formats address in separate lines, no spaces included
	 */
	public String toString(){
		String g = "";
		for (String h:things){
			if(h != null) {
				g = h+"\n";
			}
		}
		return g;
	}
}

