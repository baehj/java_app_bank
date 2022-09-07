package GUI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mission extends JFrame {
	
	public Mission() {
		setTitle("ColorSelect");
	    setSize(300, 200);
	}
	
	public static void main(String[] args) {
		JFrame fr = new JFrame();
	    JPanel pn = new JPanel();
	    
	    fr.setBounds(400, 200, 400, 500);
	    fr.setTitle("java");
	    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fr.setLayout(null);
	    fr.setVisible(true);
			
		GridLayout gl = new GridLayout(1, 2);	
	    pn.setLayout(gl);
		
	    fr.getContentPane().setBackground(Color.GREEN);
	    fr.setContentPane(pn);
	
	    //fr.setSize(400, 300);
	    fr.setVisible(true);
    
    
	}
	
}
