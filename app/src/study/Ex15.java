package study;

public class Ex15 {
	String str = "";
	public void foo(int i) {
		try {
				if (i == 1) {
					throw new Exception();
				}
				str += " 1 ";
			} catch (Exception e) { 
				str += " 2 ";
				return;
			} finally { // 예외여부에 상관없이 반드시 실행함 따라서 위에 catch로 잡아 return하더라도 실행을 하고 return 하게 됨.
				str += " 3 ";
			}
			str += " 4 ";
	}
	public static void main(String[] args) {
		
		Ex15 ee = new Ex15();
		ee.foo(0); // 1(try) 3(finally) 4
		ee.foo(1); // 2(Exception) 3(finally)
		System.out.println(ee.str); // 1 3 4 2 3
	}
}
