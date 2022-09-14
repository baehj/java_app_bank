package study;

import java.awt.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;
public class EX10 extends JFrame {
	List list;	// not java.util.List
	Map<Integer, Ex2> map;
	public EX10() {
		super("MapEX");
		map = new HashMap<>();
		memberInfo();
		list = new List();
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			Integer key = keys.next();
			Ex2 member = map.get(key);
			list.add(member.getName());
		}
		/*
		for(EX2 member : map.values()){
			list.add(member.getName());
		}
		*/
		add(list);
		setSize(300,300);
//		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void memberInfo() {
		map.put(1, new Ex2("a1", "1", "홍길동1"));
		map.put(2, new Ex2("a2", "1", "홍길동2"));
		map.put(3, new Ex2("a3", "1", "홍길동3"));
		map.put(4, new Ex2("a4", "1", "홍길동4"));
		map.put(5, new Ex2("a5", "1", "홍길동5"));
	}
	public static void main(String[] args) {
		new EX10();
	}
}
