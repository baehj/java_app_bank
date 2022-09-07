package GUI;

import java.awt.Scrollbar;

import javax.swing.JFrame;

public class Panel extends JFrame {

	Scrollbar scr1, scr2, scr3;
	
	public Panel() {

		JFrame fr = new JFrame();
	    fr.setBounds(400, 200, 400, 500);
	    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fr.setVisible(true);
		
	    scr1 = new Scrollbar(Scrollbar.HORIZONTAL);
	    //scr1 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 0, 0, 1);
	    scr1.setSize(100, 15);
	    scr1.setLocation(60, 60);

		// scb.setBounds(0, 0, 20, 30);
		fr.add(scr1);
		
		
	}
	
	public static void main(String[] args) {
		new Panel();
	}

}
