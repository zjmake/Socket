package com.zj.socket.threadSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadSocket extends Thread{
	
	Socket client;
	
	public ThreadSocket(Socket client) {this.client=client;};
	public void run(){
		System.out.println(Thread.currentThread().getName());
		try {
		    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		    PrintWriter out = new PrintWriter(client.getOutputStream());
			while(true) {
					out.write("Hello");
					out.flush();
					System.out.println(in.readLine());//这里读取数据读不到阻塞
					out.println("end");
					out.flush();
			}
		}catch(Exception e) {
			System.out.println("err");
		}
	}
	
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(4016);
		while(true) {
			//接收客户端套接字
			Socket clientAccept = server.accept();
			new ThreadSocket(clientAccept).start();
			System.out.println("aaa");
		}
		
	}

}
