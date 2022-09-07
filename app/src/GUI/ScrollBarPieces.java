package GUI;

import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class ScrollBarPieces {
  public static void main(String args[]) {
	  
    JScrollBar scb1 = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
    JScrollBar scb2 = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
    JScrollBar scb3 = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
    
    //String title = (args.length == 0 ? "java" : args[0]);
    JFrame frame = new JFrame("java");
    JPanel p = new JPanel();
    GridLayout grid = new GridLayout(5, 2, 5 ,20); // 행, 열, 수평갭, 수직갭
    grid.setVgap(60);
    
    p.setLayout(grid);
    p.add(scb1);
    p.add(scb2);
    p.add(scb3);
    
    JLabel jl = new JLabel("현재색상");
	jl.setSize(80, 30);
	jl.setLocation(30, 30);
	//jl.setHorizontalAlignment(JLabel);
	p.add(jl);
	
	
	JTextField jt = new JTextField();
	jt.setSize(130, 30);
	jt.setLocation(110, 30);
	p.add(jt);
    
    Container contentPane = frame.getContentPane();
    //contentPane.add(p, BorderLayout.WEST);
    contentPane.add(p);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    frame.setVisible(true);
  }
}
