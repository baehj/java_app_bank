package GUI;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class ScrollBarPieces extends JFrame{
			
	private JLabel rLabel;
	private JLabel gLabel;
	private JLabel bLabel;
	
	private JScrollBar r;
	private JScrollBar g;
	private JScrollBar b;

	
	public ScrollBarPieces() {
		//r = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
		//g = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
		//b = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
	    
	    //String title = (args.length == 0 ? "java" : args[0]);
	    JFrame frame = new JFrame("java");
	    JPanel p = new JPanel();
	    GridLayout grid = new GridLayout(5, 2, 5 ,60); // 행, 열, 수평갭, 수직갭
	    grid.setVgap(60);
	    
	    p.setLayout(grid);
	    p.add(r = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255));
	    p.add(g = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255));
	    p.add(b = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255));
	    
	    JLabel jl = new JLabel("현재색상");
		jl.setSize(80, 30);
		jl.setLocation(30, 30);
		//jl.setHorizontalAlignment(JLabel);
		p.add(jl);
		
		
		JTextArea jt = new JTextArea();
		jt.setText("R : " + 111 + "   G : " + 111 + "   B : " + 111);
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
  
	public static void main(String[] args) {
	    JFrame f = new ScrollBarPieces();
	    
	}
}
