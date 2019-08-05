package com.zj.test.fileTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;


public class FileTest {

	public static void main(String[] args) throws IOException {
				new Thread(new FileTest().new A()).start();;
				File file = new File("aa.txt");
				file.createNewFile();
				FileWriter write = new FileWriter(file);
				for(int i=0;i<10000000;i++)
				write.write("hahahahhaha  ");
				//write.flush();
				write.write("\r\n");
				write.close();
				
	}
	class A implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					Thread.sleep(5*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(""+(Runtime.getRuntime().totalMemory())/(1024*1024)+"M");
			}
		}

		
		
	}
}
