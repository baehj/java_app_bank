package study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex19 {
	List<Ex2> members;
	
	public Ex19() {
		members = new ArrayList<>();
		Ex2 member = new Ex2("a", "1", "1");
		//members.add(member);
		fileInput(member);
		fileOutput();
		System.out.println(members.size());
		for(Ex2 m : members) {
			System.out.println(m.getName());
		}
	}
	public void fileInput(Ex2 member) {
		try {
		PrintWriter pw 
			= new PrintWriter(new FileWriter(new File("C:/ioPractice/members.txt"), true)); // 파일경로 고려해서 생성!
				// 위 처럼 FileWriter를 생성하면 지정된 파일이 이미 있을 경우 그 파일을 덮어쓴다.
				// 따라서 기존의 파일 내용은 없어진다. 기존 파일 내용 끝에 데이터를 추가할 경우 두번 째 매개값에 true를 주면됨!!!
		//pw.println(member.getName() + "#" + member.getId() + "#" + member.getPw());
		//pw.close(); // PrintWriter는 close를 꼭 해줘야 함
		StringBuilder sb = new StringBuilder();
		sb.append(member.getName());
		sb.append("#");
		sb.append(member.getId());
		sb.append("#");
		sb.append(member.getPw());
		pw.println(sb.toString()); // 생성된 파일에 print
		pw.close();
		System.out.println("입력완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileOutput() { 
		try {
			BufferedReader br =
					new BufferedReader(
					new FileReader(new File("C:/ioPractice/members.txt")));
											// bf 말고 filereader로 읽어올 시 한글자씩 int로(아스키코드)되어 있기때문에 문자열 단위로 읽어오는 bf로 읽어오는게 편리함!
			while(br.ready()) {
				StringTokenizer st =
						new StringTokenizer(br.readLine(), "#"); // st로 나눠진 애들을 token, element로 표현함
				Ex2 member = new Ex2(st.nextToken(), st.nextToken(), st.nextToken());
				members.add(member);
											/*while(st.hasMoreTokens()) // hasMoreElements(-Object로 반환됨)랑 hasMoreTokens(-String으로 반환됨) 랑 같은 기능!
											 * 근데 element를 더 많이 사용함(?) maybe~~
												String obj = st.nextToken();
											}  이거 왜 comment 처리한 거? .. */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Ex19();
	}

}
