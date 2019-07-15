package com.zj.mina.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class MinaHandler extends IoHandlerAdapter{
	
	private final String values;  
	public MinaHandler(String values) {  
	this.values = values;  
	}  
	@Override  
	public void sessionOpened(IoSession session) {  
	session.write(values);  
	} 
}
