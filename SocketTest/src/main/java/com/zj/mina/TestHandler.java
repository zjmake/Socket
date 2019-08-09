package com.zj.mina;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class TestHandler extends IoHandlerAdapter{
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		System.out.println("exceptionCaught");
	}
 
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		System.out.println("messageReceived");
		Date date = new Date();
		String msg = (String)message;
		if(msg.equals("exit")) {
			session.close(true);
		}
		System.out.println("服务端接收数据："+msg);
		session.write(date);
	}
 
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		System.out.println("messageSentA");
		Thread.sleep(1000*5);
		session.wait(System.currentTimeMillis());
	}
 
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("sessionClosed");
	}
 
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("sessionCreated");
	}
 
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("sessionIdle");
	}
 
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("sessionOpened");
	}

}
