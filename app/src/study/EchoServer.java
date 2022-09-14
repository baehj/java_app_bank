package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private ServerSocket server;
	public EchoServer(int port) throws IOException{
		server = new ServerSocket(port);
	}
	public void service() throws IOException{
		Socket client = server.accept(); //accept메소드 중요! accept를 통해 반환된 소켓을 통해서 접속 가능.
		InputStream is = client.getInputStream(); //binaryStream. but Chat! String! 필요.
		OutputStream os = client.getOutputStream();
		InputStreamReader isr = new InputStreamReader(is);
		// bufferdReader - io에서 filter 스트림 이용 - String 형태의 값을 얻기위해
		BufferedReader in = new BufferedReader(isr);
		PrintWriter out = new PrintWriter(os, true);
		while(true) {
			String msg = in.readLine();
			System.out.println(msg); //데이터 확인용 출력
			if(msg.equals("bye")) {
				break;
			}
			out.println(">>" + msg);
		}
	} 
	
	public void close() throws IOException{
		server.close();
	}
	
	public static void main(String[] args) {
		try {
			EchoServer es = new EchoServer(1313); //port 넘버 설정
			es.service();
			es.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
