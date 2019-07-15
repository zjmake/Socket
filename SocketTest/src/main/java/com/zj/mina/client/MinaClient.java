package com.zj.mina.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.zj.mina.handler.MinaHandler;
/**
 * 客户端
 * @author dell
 *
 */
public class MinaClient {
	public static void main(String[] args) {
		IoConnector connector=new NioSocketConnector();  
			connector.setConnectTimeoutMillis(30000);  
			connector.getFilterChain().addLast("codec",  
				new ProtocolCodecFilter(  
					new TextLineCodecFactory(  
							Charset.forName("UTF-8"),  
							LineDelimiter.WINDOWS.getValue(),  
							LineDelimiter.WINDOWS.getValue()  
						)  
					)  
				);  
			connector.setHandler(new MinaHandler("Hello /r/n  世界"));
		connector.connect(new InetSocketAddress("localhost", 4015));  
	}

}
