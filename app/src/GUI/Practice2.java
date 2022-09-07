package GUI;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Practice2 extends JFrame {
    //생성자
    public Practice2() {
        setSize(900, 600); //크기 설정
        setTitle("중앙은행 ATM 서비스입니다."); // title
        
        Container container = getContentPane();
     
        container.setLayout(new BorderLayout());
        container.add(new JButton("div"), BorderLayout.WEST);
        
     
        setVisible(true);  // 화면에 프레임 출력
    }
    public static void main(String[] args) {
        new Practice2();
    }
 
}
