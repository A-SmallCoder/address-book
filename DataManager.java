package contact;
/**
 * @author Andrew-Lloyd Small
 */
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.util.*;

public class DataManager {
	
	static ArrayList <Contact> contactsLiteral;
	static ArrayList <String> contactArrayList;
	static ArrayList <String> loginInfo;
	
	public DataManager(){
	
		contactsLiteral = new ArrayList <Contact>();
		contactArrayList= new ArrayList <String>();
		loginInfo = new ArrayList <String>();
		
		//adding password and username to loginInfo
		loginInfo.add("username");
		loginInfo.add("password123");
	}
	
	//FileReader
	public static void readFromFile(){
		String fileName = ("contactList.txt");
		
		//reference one line at a time
		String line = null;
			
		try {
		    FileReader reader = new FileReader(fileName);
		
		    //Wrap FileReader in BufferedReader.
		    BufferedReader bReader = new BufferedReader(reader);
		
		    while((line = bReader.readLine()) != null) {
		    	System.out.println(line);	
		    }
		    //close file
		    bReader.close();         
		}
			
		catch(IOException ex) {
			ex.printStackTrace();
		
		}
	}
		//UI.area.setText(DataManager.showContacts());
	
	
	//fileWriter
	public static void writeToFile(String contact){
		
		String filename = "contactList.txt";
		
		try{
			FileWriter writer = new FileWriter(filename,true);
			BufferedWriter bWriter = new BufferedWriter(writer);
			bWriter.write(contact);
			bWriter.newLine();
			bWriter.flush();
			
			writer.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
	}
	
	
	public static String showContacts(){
		for (Contact f: contactsLiteral){
			contactArrayList.add(f.toString());
		}
		String c = "";
		//String [] d = new String[contactArrayList.size()];
		for (String i:contactArrayList){
			c += (i + "\n");
		}
		
		return c;
	}
	
	
    
    public static String getLogin(int index){
		return loginInfo.get(index);
		
	}
	
}
