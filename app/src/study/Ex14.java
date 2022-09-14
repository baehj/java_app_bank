package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex14 {
	
	static List<Integer> lotto = new ArrayList<>();
	
	public static void main(String[] args) {
		for(int i=0; i<7; i++){
			int num = lotto();
			lotto.add(num);
		}
		Collections.sort(lotto);
		System.out.println(lotto);
	}
	
	private static int lotto() {
		int num = (int) (Math.random()*36+1);
		for(int j=0; j<7; j++) {
			if(lotto.contains(num)) {
				num = lotto();
			} 
		}
		return num;
	}
	
}
