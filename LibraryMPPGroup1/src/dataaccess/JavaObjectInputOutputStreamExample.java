package dataaccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class JavaObjectInputOutputStreamExample {

	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\project2\\dataaccess\\storage\\user.txt";
	public static void main(String[] args) {
		

		try {

			// Store Serialized User Object in File
			FileOutputStream fileOutputStream = new FileOutputStream(
					OUTPUT_DIR);
			User user = new User("Renuka", "Mohanraj", "rmohanraj@mum.edu");
			ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
			output.writeObject(user);
			
			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		try {

			//Read from the stored file
			FileInputStream fileInputStream = new FileInputStream(new File(
					OUTPUT_DIR));
			ObjectInputStream input = new ObjectInputStream(fileInputStream);
			User user2 = (User) input.readObject();
			System.out.println(user2.getFirstName() + "  " + user2.getLastName() + "  " + user2.getEmail());
			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
