package com.zj.test.assertTest;

import java.util.concurrent.TimeUnit;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;


public class AssertAndHashedWheelTimerTest {
	//定时任务
	public static final HashedWheelTimer wheel = new HashedWheelTimer(new NamedThreadFactory("da7-room-timer-"),
            100, TimeUnit.MILLISECONDS, 60);
	
	//-ea  -da
	public static void main(String[] args) {
		//new JViewport()
		/*int a=1,b=1;
		assert a == b;
		System.out.println(1);
		
		assert a != b :"a==b";
		//assert a != b;
			System.out.println(2);*/
		
		System.out.println("begin:\r\n"+System.currentTimeMillis()/1000);
			
			
			
			 TimerTask task = new TimerTask(){

				//@Override
				public void run(Timeout timeout) throws Exception {
					// TODO Auto-generated method stub
					
						System.out.println("end:\r\n"+System.currentTimeMillis()/1000);
				}
			 
			};
			
			Timeout timeout = wheel.newTimeout(task, 5, TimeUnit.SECONDS);	//  任务   5秒后执行  单位S
			
			
			
	}
}
