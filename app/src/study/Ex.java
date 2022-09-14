package study;

import java.util.Scanner;

public class Ex {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null; // 점수가 아닌 사용자의 정보를 담으려면? Member 같은 객체를 만들어줘야함. 
		Scanner scanner = new Scanner(System.in);
		while(run) {
			System.out.println("-------------------------------------");
		    System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		    System.out.println("-------------------------------------");
	        System.out.print("선택>  ");
	        int selectNo = scanner.nextInt();
	        if (selectNo == 1) {
	        	System.out.println("학생수> ");
	        	studentNum = scanner.nextInt();
	        	scores = new int[studentNum];
	        } else if(selectNo == 2) {
	        	for(int i=0; i<scores.length; i++) {
	        		System.out.print("scores["+ i + "]> ");
	        		scores[i] = scanner.nextInt();
	        	}
	        } else if(selectNo == 3) {
	        	for(int i=0; i<scores.length; i++) {
	        		System.out.print("scores["+ i + "]: " + scores[i]);
	        	}
	        } else if(selectNo == 4) {
	        	int max = 0;
	        	int sum = 0;
	        	double avg = 0;
	        	for(int i=0; i<scores.length; i++) {
	        		max = (max<scores[i])? scores[i] : max; // max값을 = max랑 score[i]를 비교해서 max가 낮으면 score값으로, 높다면 max로 하겠다. 삼항연산자
	        		sum += scores[i];
	        	}
	        	avg = (double) sum / studentNum;
	        	System.out.println("최고 점수: " + max);
	        	System.out.println("평균 점수: " + avg);
	        } else if(selectNo == 5) {
	        	run = false;
	        }
		}
		
	}
}
