package GUI;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;

public class Ex18 {
	public Ex18() {
		ta = new TextArea();
		ta.setEditable(false);
		fd_load = new FileDialog(this, "파일열기", FileDialog.LOAD);
		fd_save = new FileDialog(this, "파일저장", FileDialog.SAVE);
		mb = new MenuBar();
		m = new Menu("File");
		mi = new MenuItem[5];
		mi[0] = new MenuItem("New File");
		mi[1] = new MenuItem("Open File");
		mi[2] = new MenuItem("Save File");
		mi[3] = new MenuItem("Save As");
		mi[4] = new MenuItem("Exit");
		for(int i=0; i<mi.length; i++) {
			m.add(mi[i]);
		}
		
		
		
	48 mi[1].setEnabled(false);
		mb.add(m);
		setMenuBar(mb);
		add(ta, "Center");
		setSize(500, 500);
		setVisible(ture);
	}
	public void actionPerformer(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(mi[4])) {
			System.exit(0);
		}else if(obj == mi[0]) {
			mi[1].setEnabled(true);
			ta.setEditable(true);
		}else if(obj == mi[1]) {
			//Open File
			fd_load.setVisible(true);
			//fd_load.getDirectory(true);
			//fd_load.getFile(true);
			FileReader fr = null;
				BufferedReader br = null;
				ta.setEditable(true);
				ta.setText("");
				try {
					File file = new File(fd_load.getDirectory())
							+ fd_load.getFile());
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					while(br.ready()) {
						ta.append(br.readLine() + "\n")''
						
					}
				}
			
		}
	}
}
