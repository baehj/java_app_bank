package study;

public class Ex4Main {

	public static void main(String[] args) {
		Ex4 ex = new Ex4();
		boolean result = ex.login("abc", "123");
		if(result) {
			System.out.println("로그인 되었습니다.");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	
	}

}
