package com.zj.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaServer {
	
	static int port = 4015;
	
	static IoAcceptor acceptor = null;
 
	public static void main(String[] args) {
		 // 第一步 ： 编写IoService:创建服务器端监听
		acceptor = new NioSocketAcceptor();
		//第二步  ：设置编码过滤器
		acceptor.getFilterChain().addLast(
				"codec", new ProtocolCodecFilter(new TextLineCodecFactory(
											Charset.forName("UTF-8"),
											LineDelimiter.WINDOWS.getValue(),
											LineDelimiter.WINDOWS.getValue()
											)
						)
				);
		//  1)设置缓存大小
		acceptor.getSessionConfig().setReadBufferSize(1024);
		//  2)设置回话空闲时间
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		//第三步 ： 编写 IoHandler
		acceptor.setHandler(new TestHandler());
		try {
			//绑定端口号
			acceptor.bind(new InetSocketAddress(port));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server -> "+port+" started");
	}

}
