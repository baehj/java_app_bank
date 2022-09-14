package study;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// GUI - 객체 생성 , 인터페이스 , abstract 개념 등 공부가능.
// 내부 익명 클래스에 대해서 공부 필요함. 컨테이너 컴포넌트 개념.

public class Ex6 extends JFrame {
	
	JLabel id_la, pw_la;
	JTextField id_tf, pw_tf;
	JButton login, join;
	public Ex6() {
		super("GUI");
		id_la = new JLabel("ID");
		pw_la = new JLabel("PW");
		id_tf = new JTextField();
		pw_tf = new JTextField();
		login = new JButton("login");
		join = new JButton("join");
		Panel p = new Panel(); // 패널은 컨테이너 역할
		
		Panel p2 = new Panel(new GridLayout(2,2));
		p.setLayout(new GridLayout(1,2));
		p.add(login);
		p.add(join);
		p2.add(id_la);
		p2.add(pw_la);
		p2.add(id_tf);
		p2.add(pw_tf);
		this.add(p, "South");
		this.add(p2, "Center");
		this.setSize(300, 300);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			
		});
	}
	

}
