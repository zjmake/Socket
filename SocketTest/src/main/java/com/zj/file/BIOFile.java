package com.zj.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class BIOFile {

	
	public void BIO() {
		

		

		
	}
	public void read_WriteObjToFile() {
		
		
		//Initializes The Object
				User1 user = new User1();
				user.setName("hollis");
				user.setAge(23);
				System.out.println(user);

				//Write Obj to File
				ObjectOutputStream oos = null;
				try {
				    oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
				    oos.writeObject(user);
				} catch (IOException e) {
				    e.printStackTrace();
				} finally {
				    IOUtils.closeQuietly(oos);
				}
				//Read Obj from File
				File file = new File("tempFile");
				ObjectInputStream ois = null;
				try {
				    ois = new ObjectInputStream(new FileInputStream(file));
				    User1 newUser = (User1) ois.readObject();
				    System.out.println(newUser);
				} catch (IOException e) {
				    e.printStackTrace();
				} catch (ClassNotFoundException e) {
				    e.printStackTrace();
				} finally {
				    IOUtils.closeQuietly(ois);
				    try {
				        FileUtils.forceDelete(file);
				    } catch (IOException e) {
				        e.printStackTrace();
				    }
				}
		
	}
	//把对象写到文件 以及从文件读取出来
	public void read_WriteObj() {
		User1 user = new User1();
		user.setName("hollis");
		user.setAge(23);
		System.out.println(user);

		//Write Obj to File
		ObjectOutputStream oos = null;
		try {
		    oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
		    oos.writeObject(user);
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    IOUtils.closeQuietly(oos);
		}

		//Read Obj from File
		File file = new File("tempFile");
		ObjectInputStream ois = null;
		try {
		    ois = new ObjectInputStream(new FileInputStream(file));
		    User1 newUser = (User1) ois.readObject();
		    System.out.println(newUser);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} finally {
		    IOUtils.closeQuietly(ois);
		    try {
		        FileUtils.forceDelete(file);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}
}
