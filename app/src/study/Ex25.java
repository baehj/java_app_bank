package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Ex25 extends Thread{
	private Socket s;
	private BufferedReader i;
	private PrintWriter o;
	public Ex24 server;
	private String user; //필드명으로 name은 쓰면 안됨. thread 내에서 사용중 
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public Ex25(Ex24 server, Socket s) throws Exception{
		this.server = server;
		this.s = s;
		InputStream ins = s.getInputStream(); //binaryStream. but Chat! String! 필요.
		OutputStream os = s.getOutputStream();
		InputStreamReader isr = new InputStreamReader(ins);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		o = new PrintWriter(osw,true);
		i = new BufferedReader(isr);
	}
	public void run() {
		String name = ""; // 처음에 이름을 받고 이후 while문으로 msg 송수신
		try {
			name = i.readLine();
			setUser(name);
			server.register(this); // 이름을 서버에 저장
			broadcast(name+"님이 방문하셨습니다."); // 서버 등록 후 broadcast해줘야지 나포함 뿌려짐
			while(true) {
				String msg = i.readLine();
				broadcast(name+"-"+msg);
			}
		}catch(Exception e) {}
		server.unregister(this);
		broadcast(name+"님이 나가셨습니다." );
		try {
			i.close();
			o.close();
			s.close();
		} catch (IOException ex) {}
	}
	
	protected void println(String message) {
		o.println(message);
	}
	
	private void broadcast(String message) {
		server.broadcast(message);
	}
	 
}
