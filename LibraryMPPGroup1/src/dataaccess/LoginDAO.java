package dataaccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.Administrator;
import model.Librarian;
import model.Login;
import util.StringUtil;
public class LoginDAO {

	public static final String OUTPUT_DIR = System.getProperty("user.dir")
			+ "\\src\\database\\LoginAccount.txt";

	public static void createLoginAccountData (List<Login> userList) {

		try {

			// Store Serialized User Object in File
			FileOutputStream fileOutputStream = new FileOutputStream(
					OUTPUT_DIR);

			ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);

			for (Login login : userList) {
				output.writeObject(login);
			}
			output.writeObject(null);
			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static Login checkAccount(Login login) {

		try {

			//Read from the stored file
			FileInputStream fileInputStream = new FileInputStream(new File(
					OUTPUT_DIR));
			ObjectInputStream input = new ObjectInputStream(fileInputStream);
			Object object = input.readObject();

				while (object != null) {
					Login user = (Login) object;
					System.out.println(user.getUserName() + "  " + user.getPassword() + "  " + user.getRoles());
					if ((user.getUserName()!= null && user.getUserName().equals(login.getUserName())) &&
							(user.getPassword()!= null && user.getPassword().equals(login.getPassword()) )){
						System.out.println(user.getUserName() + "  " + user.getPassword());
						input.close();
						return user;
					}
					object = input.readObject();
				}

			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

}
