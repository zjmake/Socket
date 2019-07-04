package com.zj.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		
		//Socket socket = new Socket(InetAddress.getLocalHost(),4015); //单线程
		Socket socket = new Socket(InetAddress.getLocalHost(),4016);//多线程
		System.err.println("client");
		
		//socket.getOutputStream().write(2);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		BufferedReader readStringIn = new BufferedReader(new InputStreamReader(System.in));//读取控制台数据
		while(true) {
			
			out.println(readStringIn.readLine());
			out.flush();
			System.err.println(in.readLine());
		
		}
		
	}
}
