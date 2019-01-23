package dataaccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<E> {

	public static final String OUTPUT_DIR = System.getProperty("user.dir") + "\\src\\database\\";

	public boolean create(E object) {
		try {
			Field field = object.getClass().getField("id"); //Note, this can throw an exception if the field doesn't exist.
		    String objectId = field.get(object).toString();
			E dbObject = findById(objectId);
			
			if(dbObject!=null)
				return false;
			
			List existingObjects = findAll();
			existingObjects.add(object);
			
			FileOutputStream fileOutputStream = new FileOutputStream(
					OUTPUT_DIR + object.getClass().getSimpleName() + ".txt");
			
			ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
			for(Object obj:existingObjects) {
				output.writeObject(obj);
			}
			
			output.writeObject(null);
			output.close();

			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List findAll() {

		List<Object> objects = new ArrayList<>();
		try {
			FileInputStream fileInputStream = new FileInputStream(
					OUTPUT_DIR + getClazz().getSimpleName() + ".txt");
			ObjectInputStream input = new ObjectInputStream(fileInputStream);
			Object object = input.readObject();
			while (object != null) {
				objects.add(object);
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

		return objects;
	}
	
	public E findById(String id) {

		try {
			FileInputStream fileInputStream = new FileInputStream(
					OUTPUT_DIR + getClazz().getSimpleName() + ".txt");
			ObjectInputStream input = new ObjectInputStream(fileInputStream);
			Object object = input.readObject();
			while (object != null) {
			    Field field = object.getClass().getField("id");//Generics
			    String objectId = field.get(object).toString();
			    if(objectId.equals(id))
			    		return (E) object; 
				object = input.readObject();
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}	
	
	public abstract Class getClazz();
}
