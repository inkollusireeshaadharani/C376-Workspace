package com.wileyedge.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;


public class FileDemo {

	public static void main(String[] args) {
		System.out.println("Inside main");
		System.out.println("File copying starts");
		long start = System.currentTimeMillis();
//		Reader rd=null;
//		Writer wr=null;
		InputStream fis = null;
		OutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
//			rd = new FileReader("D:\\C376\\abc.txt");
//			wr = new FileWriter("D:\\C376\\hello.txt");
			File file = new File("D:\\C376\\Vruksh-Raksha-Bandhan.jpg");
			System.out.println("is Directory? "+file.isDirectory());
			System.out.println("is file? "+file.isFile());
			System.out.println("is readable? "+file.canRead());
			System.out.println("is writable? "+file.canWrite());
			
			File file2 = new File("D:\\C376\\myfolder");
			System.out.println("is Directory? "+file2.isDirectory());
			System.out.println("is file? "+file2.isFile());
			file2.mkdir();
			file2.delete();
			
			fis = new FileInputStream(file);
			fos = new FileOutputStream("D:\\C376\\createdImg.jpg");
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int ch=0;
			while(ch!=-1){
				ch = bis.read();
				bos.write(ch);
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bis.close();
				bos.close();
			} 
			catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		long dur = (end-start);
		System.out.println("File copying done "+dur);
		System.out.println("Exiting main");
	}

}
