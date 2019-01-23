package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteReadFileUtil {


	public static boolean writeDataObject (String pathFile, Object data) {
			try {

				// Store Serialized User Object in File
				FileOutputStream fileOutputStream = new FileOutputStream(
						pathFile);

				ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
				output.writeObject(data);
				output.close();
				return true;

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return false;

		}

	public Object readDataObject (String pathFile) {

		Object data = null;

		try {

			// Store Serialized User Object in File
			FileInputStream fileInputStream = new FileInputStream(
					pathFile);

			ObjectInputStream input = new ObjectInputStream(fileInputStream);
			data = input.readObject();
			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

}
