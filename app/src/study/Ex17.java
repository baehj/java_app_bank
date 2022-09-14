package study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex17 {
	// 파일에 기록
	
	public static void main(String[] args)throws IOException {
		File file = new File("C:/ioPractice/IO.txt"); 
		FileReader fr = new FileReader(file);
		BufferedReader brfr = new BufferedReader(fr);
		while(brfr.ready()) {
			System.out.println(brfr.readLine());
		}
		brfr.close();
		// 연습문제) 파일에 기록된 문자데이터를 화면에 출력하시오
		// 연습문제_ 뱅크에 사용자(회원 데이터를 파일로 기록하는 프로그램을 작성하시오.
	}
}
