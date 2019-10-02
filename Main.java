package contact;
/**
 * @author Andrew-Lloyd Small
 */
import java.util.*;

public class Main {
	
	static String input;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {	 
			public void run() {
				UI.createAndShowGUI();	
			}
		});
		
		DataManager dm = new DataManager();
		
		 System.out.println("enter a to start");
		 Scanner scan = new Scanner(System.in);
		 input = scan.next();
		 Boolean running = true;
		 while (running == true){
			 if (dm.contactsLiteral.size() > 0){
				 for (Contact i: dm.contactsLiteral){
					 System.out.println(i.toString());
				 }
			 }
		 }
/*		 if (input.equals("a")){
			 System.out.println("'w' to write");
			 System.out.println("'r' to read and display");
			 input = scan.next();
			 if (input.equals("w")){
				 dm.writeToFile("the function is working");
				 dm.writeToFile("finally");
				 System.out.println("check the file to see if it works");
			 }else{
				 if(input.equals('r')){
					dm.readFromFile();
				 }
			 }
			 
		 }else{
			 System.out.println("fail");
		 }
		 scan.close();
*/		 
		
		
		//dm.contactsLiteral.add(new Contact("Larry", "Parry",Gender.MALE, 19981205));
		//dm.contactsLiteral.add(new Contact("Michael", "Pichael",Gender.MALE, 19991205));
		//dm.contactsLiteral.add(new Contact("John", "Brown",Gender.MALE, 20001205));
		//dm.contactsLiteral.add(new Contact("Mary", "Ainsworth",Gender.FEMALE, 20011205));
		//dm.contactsLiteral.add(new Contact("Kim", "Possible",Gender.FEMALE, 20021205));
		//dm.contactsLiteral.add(new Contact("Jane", "Smith",Gender.FEMALE, 20031205));
		
		
	}	

}
