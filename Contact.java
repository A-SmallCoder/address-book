package contact;

/**
 * @author Andrew-Lloyd Small
 */

import java.time.*;
import java.util.*;

/**
 * service class for contact management
 */
public class Contact {
	private String firstName;
	private String lastName;
	private int dob;
	private Gender gender;
	private String alias;
	private Address address;
	private static int entryno = 0;
	private int personal_entry_no;
	
	
	/**
	 * array of email addresses for each contact
	 */
	ArrayList <String> emailList = new ArrayList<String>();
	
	/**
	 * list of phone numbers for each client
	 */
	Phone[] phoneList = new Phone[5];
	
	
	/**
	 * constructor for Contact class
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param dob
	 */
	public Contact (String firstName, String lastName, Gender gender, int dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		entryno ++;
		this.personal_entry_no = entryno;
	}
	
	/**
	 * 
	 * @return entry number of contact
	 */
	public int getEntryNo () {
		return personal_entry_no;
	}
	
	/**
	 * 
	 * @return age of contact
	 */
	public int getAge () {
		String word = Integer.toString(dob);
		int y = Integer.parseInt(word.substring(0, 4));
		int m = Integer.parseInt(word.substring(4, 6));
		//when it was word.substring(6,9)
		//error said string index out of range
		int d = Integer.parseInt(word.substring(6,8));	
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(y, m, d);
		int age = Period.between(birthday,today).getYears();
		return age;
	}
	
	/**
	 * 
	 * @return name of contact in format: lastname,firstname
	 */
	public String getName() {
		return this.lastName + "," + this.firstName;
	}
	
	/**
	 * changes lastname of the contact to the parameter taken
	 * @param new_name
	 */
	public void updateName(String new_name){
		this.lastName = new_name;
	}
	
	/**
	 * 
	 * @return alias of the contact
	 */
	public String getAlias(){
		return this.alias;
	}
	
	/**
	 * sets alias of contact to parameter taken
	 * @param alias
	 */
	public void setAlias(String alias){
		this.alias = alias;
	}
	
	/**
	 * 
	 * @return address of contact
	 */
	public String[] getAddress(){
		return this.address.getAddress();
	}
	
	/**
	 * sets address of contact to parameter taken
	 * @param add
	 */
	public void setAddress(String add){
		this.address = new Address(add);
	}
	
	/**
	 * adds parameter taken to client's contactList
	 * @param emailAddress
	 */
	public void addEmail( String emailAddress){
		emailList.add(emailAddress);
	}
	
	/**
	 * if parameter matches an item in emailList, it is removed
	 * otherwise, a message is displayed
	 * @param emailAddress
	 */
	public void deleteEmail(String emailAddress){
		if(emailList.contains(emailAddress)){
			emailList.remove(emailAddress);
		}else{
			System.out.println("There is no such email in the system");
		}
	}
	
	/**
	 * 	 
	 * @return contacts emailList
	 */
	public String[] getEmailList(){
		ArrayList<String> elst = new ArrayList<String>();
		for (String i:emailList) {
			elst.add(i);
		}
		String [] array = new String[elst.size()];
		array = elst.toArray(array);
		return array;
	}
	
	/**
	 * adds phone number and type of phone number to contact's list of phone numbers
	 * @param type
	 * @param number
	 */
	public void addPhone(char type,long number){
			 if (phoneList[0] == null){
				 phoneList[0] = new Phone(number,type);
			 }else if (phoneList[1] == null){
				 phoneList[1] = new Phone(number,type);
			 }else if (phoneList[2] == null){
				 phoneList[2] = new Phone(number,type);
			 }else if (phoneList[3] == null){
				 phoneList[3] = new Phone(number,type);
			 }else if (phoneList[4] == null){
				 phoneList[4] = new Phone(number,type);
			 }
	}
	
	/**
	 * if parameter taken exists in list of phone numbers, it is deleted
	 * otherwise, a message is displayed
	 * @param phone
	 */
	// size of the array is reduced by 1. fix it!!!
	public void deletePhone(long phone) {
		ArrayList <Phone> pl = new ArrayList<Phone>();
		for (Phone el:phoneList){
			if(el.getNumber() != phone){
				pl.add(el);
			}
		}
		phoneList = pl.toArray(phoneList);
	}
	
	/**
	 * 
	 * @return list of contact's phone numbers
	 */
	public String[] getPhoneList(){
		ArrayList<String> lst = new ArrayList<String>();
		for (Phone i: phoneList){
			lst.add(i.toString());
		}
		String [] plst = new String[lst.size()];
		plst = lst.toArray(plst);
		return plst;
	}
	
	public String toString(){
		String s = Integer.toString(this.getEntryNo()) + this.getName() + this.getAlias() +
				Integer.toString(this.getAge()) + Arrays.toString(this.getAddress()) +
				Arrays.toString(this.getPhoneList()) + Arrays.toString(this.getEmailList());
		return s;
	}
}

