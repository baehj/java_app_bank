package app2;

public class NotLoginingException extends Exception {
	public NotLoginingException() {
		System.out.println("로그인 상태가 아닙니다.");
	}
}
