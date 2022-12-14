package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JFrame_Test extends JFrame{
	
	public JFrame_Test() {
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,1));
		
		// 1/5 ㅇㅇ뱅크
		JLabel title = new JLabel("ㅇㅇ뱅크");
		title.setHorizontalAlignment(JLabel.CENTER);
		p.add(title);
		
		// 2/5 아이디
		JPanel p_id = new JPanel();
		p_id.setLayout(new GridLayout(1,2));
		p_id.setBorder(BorderFactory.createEmptyBorder(40 , 50 , 40 , 200));
		
		JLabel id= new JLabel("아이디");
		id.setSize(80, 30);
		id.setLocation(30, 30);
		id.setHorizontalAlignment(JLabel.CENTER);
		p_id.add(id);
		
		JTextField idIn = new JTextField(10); // 입력값 int 사이즈 10로 지정
		idIn.setSize(130, 30);
		idIn.setLocation(110, 30);
		idIn.setHorizontalAlignment(JLabel.CENTER);
		p_id.add(idIn);
		
		p.add(p_id);
		
		// 3/5 비밀번호 
		JPanel p_pw = new JPanel();
		p_pw.setLayout(new GridLayout(1,2));
		p_pw.setBorder(BorderFactory.createEmptyBorder(40 , 50 , 40 , 200));
		
		JLabel pw = new JLabel("비밀번호");
		pw.setSize(80, 30);
		pw.setLocation(30, 90);
		pw.setHorizontalAlignment(JLabel.CENTER);
		
		p_pw.add(pw);
		
		JPasswordField pwIn = new JPasswordField(5); // 입력값 int 사이즈 5로 지정
		pwIn.setEchoChar('*');
		pwIn.setSize(130, 30);
		pwIn.setLocation(110, 90);
		pwIn.setHorizontalAlignment(JLabel.CENTER);
		p_pw.add(pwIn);
		
		p.add(p_pw);
		
		// 4/5 로그인버튼
		JPanel p4 = new JPanel();
		JButton p4Btn = new JButton("L O G I N");
		p4.add(p4Btn);
		//p4.setLayout(new BorderLayout());
		p.add(p4, BorderLayout.CENTER);
		
		// 5/5 가입,찾기 버튼들
		JPanel p5 = new JPanel();
		p5.add(new JButton("회원가입"));
		p5.add(new JButton("ID찾기"));
		p5.add(new JButton("PW찾기"));
		p.add(p5);
		
		add(p);
		setTitle("로그인");
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public static void main(String[] args) {
		JFrame jf = new JFrame_Test();
		
	}

}
