package app2;

public class NotLoginException extends Exception{
	public NotLoginException() {
		System.out.println("아이디와 비밀번호를 확인해주세요.");
	}
}
