package study;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Ex24 { // server
	private Vector handlers; //컬렉션 중 동기화처리가 되어있는 vector를 사용
	
	public Ex24(int port) {
		try {
			 ServerSocket server = new ServerSocket(port);
			 handlers = new Vector();
			 System.out.println("ChatServer is ready");
			 while(true) {
					Ex25 handler = new Ex25(this, server.accept()); // 객체화해서 socket을 다루기 위해
					handler.start();
			}
		} catch (Exception e) {	}
	}
	
	public Object getHandler(int index) { // 특정사람과 소통하기 위한 요청
		return handlers.elementAt(index); // 컬렉션에서는 element가 어울림. get보단 but 기능은 동일함
	}
	
	public void register(Ex25 c) {
		handlers.addElement(c);
	}
	
	public void unregister(Object o) {
		handlers.removeElement(o);
	}
	
	public void broadcast(String message) { //메세지를 모두에게 뿌려줌. 인원만큼 컬렉션에서 꺼낸다음에 각각의 socket으로 접근
		synchronized(handlers) { // 동기화 처리방법 2가지. 블락처리 또는 메소드 내에서 처리 - public synchronized void broadcast(String message)
			// 동기화 필요함. why? 3명에게 메세지 뿌리려했는데 그 순간 1명 더 들어온다면? 등 의 예외상황 처리를위해. 예외의 가능성이 조금이라도 있다면 동기화 해결 후 사용해야하함.
			int n = handlers.size();
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<n; i++) {
				Ex25 h = (Ex25)handlers.elementAt(i);
				sb.append("#" + h.getUser());
			}
			for(int i=0; i<n; i++) {
				Ex25 h = (Ex25)handlers.elementAt(i);
				try {
					h.println(message + sb.toString());
				}catch (Exception e) {}
			}
		}
	} 	
	
	public static void main(String[] args) {
		new Ex24(1004);
	}
	
}
