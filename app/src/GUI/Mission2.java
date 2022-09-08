package GUI;

import java.awt.Adjustable;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class Mission2 extends JFrame {
	
	private JScrollBar scr1;
	
	public Mission2() {
		setTitle("java");
	    setSize(500, 700);
	    setVisible(true);
	    
	    
	    Container contentPane = getContentPane();
	    JPanel p = new JPanel();
	    p.setLayout(new GridLayout(2, 2));
	    p.add(scr1 = new JScrollBar(Adjustable.HORIZONTAL, 0, 0, 0, 10));
	    scr1.setBlockIncrement(10);
	   
	    contentPane.add(p, "South");
	    
	}
	
	
	public static void main(String[] args) {
		 JFrame f = new Mission2();
		
   }

	
	
}
