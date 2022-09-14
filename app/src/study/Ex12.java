package study;

import java.awt.Toolkit;

public class Ex12 {
	public static void main(String[] args) {
		
		Thread thread = new Ex13();
		thread.start();
		
		/*Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("S");*/
		
		for(int i=0; i<5; i++) {
			System.out.println("병");
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
