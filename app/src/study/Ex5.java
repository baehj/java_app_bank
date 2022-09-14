package study;

import java.awt.Frame;

// GUI - 객체 생성 , 인터페이스 , abstract 개념 등 공부가능.
// 내부 익명 클래스에 대해서 공부 필요함.

public class Ex5 extends Frame {
	public Ex5() {
		super("QUI");
		setSize(300, 300);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Ex5();
	}

}
