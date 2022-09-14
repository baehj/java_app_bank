package study;

import java.awt.List;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex26 extends JFrame implements Runnable, ActionListener { //client
	private BufferedReader i;
	private PrintWriter o;
	private JTextArea output;
	private JTextField input;
	private JLabel label;
	private Thread listener;
	private String host;
	
	private JScrollPane jp;
	private JScrollBar jb;
	private JTextArea jt;
	private List user;
	
	public Ex26(String server) {
		super("채팅 프로그램");
		host = server;
		listener = new Thread(this);
		listener.start();
		output = new JTextArea();
		jp = new JScrollPane(output);
		jb = jp.getVerticalScrollBar();
		add(jp,"Center"); //output을 direct로 붙이지 않은 이유는? scrollbar객체를 생성해서 핸들링 할 수 있기때문에
		output.setEditable(false);
		
		Panel bottom = new Panel(new BorderLayout());
		label = new JLabel("사용자 이름");
		bottom.add(label,"West");
		input = new JTextField();
		bottom.add(input, "Center");
		input.addActionListener(this);
		add(bottom, "South");
		user = new List();
		add(user,"East");
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 스윙에서는 없어도 창이 닫기긴 함
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// 실행단위가 2개 이상이 되어어 함 why? gui가 도는 동안 챗이 멈춰있거나 반대로 될 수 있음.
		// JFrame f = new JFrame();

		if (args.length > 0) {
			new Ex26(args[0]);
		} else {
			 new Ex26("localhost");
			// new Ex22("172.30.1.93");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object c = e.getSource();
		if(c == input) {
			label.setText("메세지");
			o.println(input.getText());
			input.setText(""); // 전송 후 채팅창 초기화
		}
	}

	// textArea, textField, button에는 추가로 붙일 수 없다. 기능이 1개뿐!
	
	@Override
	public void run() {
		try {
			Socket s = new Socket(host, 1004);
			InputStream ins = s.getInputStream(); //binaryStream. but Chat! String! 필요.
			OutputStream os = s.getOutputStream();
			i = new BufferedReader(new InputStreamReader(ins));
			o = new PrintWriter(new OutputStreamWriter(os),true);
			while(true) {
				String line = i.readLine();
				StringTokenizer st = new StringTokenizer(line,"#");
				output.append(st.nextToken() + "\n");
				user.removeAll();
				while(st.hasMoreElements()) {
					user.add(st.nextToken());
				}
//				output.append(line + "\n");
				jb.setValue(jb.getMaximum());
			}
		}catch(Exception e) {
			e.getMessage();
		}
		
	}
	
}

