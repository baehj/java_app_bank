package app;

public interface Bank {
		
	public int max = 10000000; // 인터페이스는 상수값만 가질 수 있다.
	
	public static void join() {}
	public static void login() {}
	public static void changeInfo(int amount) {}
	public static void deposit(int amount) {}
	public static void withdraw(int amount) {}
	public static void transfer(int amount) {}
	public static void balance() {}
	
}
