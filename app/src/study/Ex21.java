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

public class Ex21 extends Thread{
	private Socket s;
	private BufferedReader i;
	private PrintWriter o;
	public Ex20 server;
	public static List<String> names = new ArrayList<>();
	public Ex22 ex22;
	
	public Ex21(Ex20 server, Socket s) throws Exception{
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
		String nameSet = "";
		
		try {
			name = i.readLine();
			server.register(this); // 이름을 서버에 저장
			
			names.add(name);
			
			for(int i=0; i<names.size(); i++) {
				nameSet += "#" + names.get(i);
			}
			
			broadcast(name+"님이 방문하셨습니다." + nameSet); // 서버 등록 후 broadcast해줘야지 나포함 뿌려짐
			while(true) {
				String msg = i.readLine();
				broadcast(name+"-"+msg);
			}
		}catch(Exception e) {}
		server.unregister(this);
		
		names.remove(name);
		nameSet = "";
		for(int i=0; i<names.size(); i++) {
			nameSet += "#" + names.get(i);
		}
	
		broadcast(name+"님이 나가셨습니다." + nameSet);
		
		try {
			i.close();
			o.close();
			s.close();
		} catch (IOException ex) {}
	}
	
	protected void println(String message) {
		int idx = message.indexOf("#");
		String msg = message.substring(0,idx);
		o.println(msg);
	}
	
	private void broadcast(String message) {
		server.broadcast(message);
	}
	 
}
