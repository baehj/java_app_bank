package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrame_Test {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		
		jf.setBounds(400, 200, 380, 180);
		// jf의 좌표와 크기를 결정 (setSize + setLocation)
		jf.setTitle("로그인");
		// jf의 제목을 설정
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 닫기 버튼을 눌렀을 때 동작 설정 (프로그램을 종료)
		jf.setLayout(null);
		
		JLabel jl = new JLabel("아이디 : ");
		jl.setSize(80, 30);
		jl.setLocation(30, 30);
		jl.setHorizontalAlignment(JLabel.CENTER);
		jf.add(jl);
		
		
		JTextField jt = new JTextField();
		jt.setSize(130, 30);
		jt.setLocation(110, 30);
		jf.add(jt);
		 
		
		jf.setVisible(true);
		// jf프레임이 보이도록 설정
	}

}
