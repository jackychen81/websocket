package com.jacky.websocket.socket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoSocket {

	
	@OnOpen
	public void open(Session session){
		System.out.println("seesionId="+session.getId());
	}
	
	@OnClose
	public void close(Session session){
		System.out.println("seesionId="+session.getId()+"关闭了");
	}
	
	@OnMessage
	public void message(Session session,String msg){
		System.out.println("客户端："+msg);
		try {
			session.getBasicRemote().sendText("服务器：hello!"+msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
