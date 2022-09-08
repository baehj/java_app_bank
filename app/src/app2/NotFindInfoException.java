package app2;

public class NotFindInfoException extends Exception {
	public NotFindInfoException() {
		System.out.println("로그인 상태가 아닙니다.");
	}
}
