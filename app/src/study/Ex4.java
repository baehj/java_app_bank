package study;

public class Ex4 {
	public Ex2 member;
	Ex2[] ex2 = new Ex2[2];
	public Ex4() {
		member = new Ex2("홍길동", "abc", "123");
		ex2[0] = member;
	}
	public boolean login(String id, String pw) {
		boolean result = false;
		if(id.equals(member.getId()) && pw.equals(member.getPw())) {
			System.out.println(member.getName() + "님");
			result = true;
		}
		return result;
	}
	public void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
}
