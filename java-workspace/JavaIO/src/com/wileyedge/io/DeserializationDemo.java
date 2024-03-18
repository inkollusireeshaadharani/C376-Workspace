package com.wileyedge.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DeserializationDemo {

	public static void main(String[] args) {
		InputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("D:\\C376\\student.ser");
			bis = new BufferedInputStream(fis);
			
			ois = new ObjectInputStream(bis);
			
			
			Object obj = ois.readObject();
			if(obj instanceof Student) {
				Student s = (Student) obj;
				System.out.println(s);

			}
		}
		catch(IOException e){
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}

}
