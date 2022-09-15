package bankapp;

public interface Bank {
		
	public int max = 10000000; // 인터페이스는 상수값만 가질 수 있다.
	
	public static void join() {}
	public static void login() {}
	public static void changeInfo() {}
	public static void deposit() {}
	public static void withdraw() {}
	public static void transfer() {}
	public static void findInfo() {}
	public static void logout() {}
	
}
