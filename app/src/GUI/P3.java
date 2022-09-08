package GUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class P3 extends JFrame{
	
	public P3() {
//		JFrame jf = new JFrame();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,2));
		
		JPanel p1 = new JPanel(); // 좌 
		p1.setLayout(new GridLayout(5,1)); // 그리드 설정후에 
		p1.add(new JLabel("1")); // p1에 필요한 내용을 달고 
		p1.add(new JButton("2"));
		p1.add(new JLabel("3"));
		p1.add(new JButton("4"));
		p1.add(new JLabel("5"));
		p.add(p1); // 그다음에 p에 붙여줘야함.

		JPanel p2 = new JPanel(); // 우 
		p2.setLayout(new GridLayout(1,1));
		
		p2.add(new JLabel("5"));
		p.add(p2);
		
		add(p);
		setTitle("JavaTest");
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		 JFrame f = new P3();
	}
}
