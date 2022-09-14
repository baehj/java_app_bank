package study;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random; //시간되면 로또 만들어보기 중복 방지. 

public class Ex14_1 extends Frame implements Runnable {
	int x = 0;
	int y = 20;
	boolean xOrient, yOrient; // field의 값은 자동초기화 돼어 초기화되지 않아도 사용이 가능하다 default false 
	public Ex14_1() {
		setSize(900,400);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public void paint(Graphics gr) {
		Random ran = new Random();
		Dimension d = this.getSize();
		if(xOrient) {
			x--;
			if(x < 0) {
				x = 0;
				xOrient = false;
			}
		}else {
			x++;
			if(x >= d.width -20) {
				x = d.width - 20;
				xOrient = true;
			}
		}
		if(yOrient) {
			y--;
			if(y < 0) {
				y = 0;
				yOrient = false;
			}
		}else {
			y++;
			if(y >= d.height -20) {
				y = d.height - 20;
				yOrient = true;
			}
		}
		int r = ran.nextInt(255);
		int g = ran.nextInt(255);
		int b = ran.nextInt(255);
		gr.setColor(new Color(r, g, b));
		gr.drawRect(x, y, 20, 20);
	}

	/*
	 * public void update(Graphics g) { paint(g); }
	 */
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(10);
				
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Ex14_1());
		thread.start();
		
		
	}

}
