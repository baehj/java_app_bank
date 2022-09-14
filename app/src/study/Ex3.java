package study;

public class Ex3 {
	
	Ex3(){
		// 생성자는 클래스 이름과 같아야함.
		// return 없음
		// 만들지 않아도 자동으로 생김
		// 생성자의 사용 목적 : 만든 field를 초기화해주는 역할
	}
	
	Ex3(int a , String b){
		
	}
	
	Ex3(String b, int a){
		// 같은 타입이라도 순서가 다르면 둘다 생성자로 사용 가능
	}
	
	public static void main (String arg[]) {
		new Ex3("", 10);
	}
	
}
