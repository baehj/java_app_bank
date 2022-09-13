package GUI;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileWriteGUI extends JFrame implements ActionListener {

	JMenuItem m1, m2, m3, m4, m5;
	JTextArea jf;
	private JFileChooser jfc = new JFileChooser();

	public FileWriteGUI() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());

		JPanel p1 = new JPanel();
		p1.setLayout(null);

		JMenuBar mb = new JMenuBar();
		JMenu m = new JMenu("File");
		m.add(m1 = new JMenuItem("New File"));
		m.addSeparator();
		m.add(m2 = new JMenuItem("Open File"));
		m.addSeparator();
		m.add(m3 = new JMenuItem("Save File"));
		m.add(m4 = new JMenuItem("Save As"));
		m.addSeparator();
		m.add(m5 = new JMenuItem("Exit"));

		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);
		m5.addActionListener(this);

		mb.add(m);

		p.add(mb, BorderLayout.NORTH);

		JPanel p2 = new JPanel();
		jf = new JTextArea(); // JTextField 한줄 JTextArea 여러줄
		p.add(jf);

		add(p);
		setTitle("JavaTest");
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JFrame fr = new FileWriteGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		jfc.setFileFilter(new FileNameExtensionFilter("txt", "txt")); // txt 파일만
		jfc.setMultiSelectionEnabled(false);// 다중 선택 불가

		if (e.getSource() == m1) { // 작성한 내용 초기화
			jf.setText(" ");
		}
		if (e.getSource() == m2) { // 불러오기
			if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				// showopendialog 열기 창을 열고 확인 버튼을 눌렀는지 확인
				File file = new File(jfc.getSelectedFile().toString());
				FileReader fr = null;
				try {
					fr = new FileReader(file);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				BufferedReader brfr = new BufferedReader(fr);
				try {
					String text = "";
					while (brfr.ready()) {
						text += brfr.readLine() + "\n";
					}
					jf.setText(text);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					brfr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (e.getSource() == m3) { // 파일 저장하기

			if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				File file = new File(jfc.getSelectedFile().toString() + ".txt");
				FileWriter fwriter = null;
				try {
					fwriter = new FileWriter(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedWriter bw = new BufferedWriter(fwriter);
				PrintWriter pw = new PrintWriter(bw, true);
				InputStream is = System.in;
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				pw.println(jf.getText());
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pw.close();
			}

		}
		if (e.getSource() == m4) { // 파일 이름 변경하기
			if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				File file = new File(jfc.getSelectedFile().toString() + ".txt");
				File newFile = new File("ㅎㅎ" + ".txt");
				boolean result = file.renameTo(newFile);
				System.out.println(result);
				// File file = new File(jfc.getSelectedFile().toString()+".txt");
				// File newFile = new File("D:\\example\\new_image.jpg");
			}
		}if (e.getSource() == m5) { // 파일 종료하기
				System.exit(0);
		}
	}
}
