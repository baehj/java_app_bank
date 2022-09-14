package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/* - standard Stream(표준스트림) -> System.out.println();		System.in;
 * -
 * Bite Stream , Binary Stream -> InputStream,OutputStream 
 * Character Stream -> 문자스트림에서 최상위 Reader, Writer 
 * -
 * Filter Stream? 가공.조합.의 개념.  */

public class Ex16 { // 파일에 저장
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:/ioPractice/IO.txt");
		FileWriter fwriter = new FileWriter(file);
		BufferedWriter bw =  new BufferedWriter(fwriter);
		PrintWriter pw = new PrintWriter(bw,true);
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("입력 : ");
		String str = "";
		while(!str.equals("end")) {
			str = br.readLine();
			pw.println(str);
		}
		br.close();
		pw.close();
	}
}
