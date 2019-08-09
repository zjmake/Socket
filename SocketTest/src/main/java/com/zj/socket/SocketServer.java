package com.zj.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(4015);
		System.err.println("server");
		System.err.println(1);
		Socket client = server.accept();//浜х敓socket杩炴帴
		while(true) {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream());
			out.write("Hello");
			out.flush();
			System.err.println(2);
			System.out.println(in.readLine());//杩欓噷璇诲彇鏁版嵁璇讳笉鍒伴樆濉�
			out.println("end");
			out.flush();
		}
	}
}
