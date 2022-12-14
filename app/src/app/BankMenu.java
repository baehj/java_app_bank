package app;

import java.util.Scanner;

public class BankMenu {

	private static Scanner sc = new Scanner(System.in);
	static int balance, amount = 0;

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.회원가입 | 2.로그인 | 3. 개인정보찾기 | 4.입금 | 5.출금 | 6.계좌이체 | 7.잔고확인 | 8.개인정보변경 | 9.로그아웃 | 10.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택 >>> ");
			int selectNo = sc.nextInt();
			Account ac = new Account();
			switch (selectNo) {
			case 1: 
				System.out.println("회원가입 서비스입니다.>");
				System.out.print("이름을 입력해주세요. >>> ");
				String name = sc.next();
				System.out.print("아이디를 입력해주세요. >>> ");
				String id = sc.next();
				System.out.print("비밀번호를 입력해주세요.(4자리) >>> ");
				int pw =  sc.nextInt();
				System.out.print("생년월일을 입력해주세요.(6자리) >>> ");
				int birth =  sc.nextInt();
				ac.join(name, id, pw, birth);
			case 2: 
				System.out.println("로그인 서비스입니다.>");
				System.out.print("아이디를 입력해주세요. >>> ");
				id = sc.next();
				System.out.print("비밀번호를 입력해주세요. >>> ");
				pw =  sc.nextInt();
				ac.login(id, pw);
			case 3: // 개인정보찾기
				// ac.findInfo();
				break;
			case 4:
				System.out.println("입금 서비스입니다. 얼마를 입금하시겠습니까?>");
				ac.deposit(sc.nextInt());
			case 5:
				System.out.println("출금 서비스입니다. 얼마를 출금하시겠습니까?>");
				ac.withdraw(sc.nextInt());
			case 6:
				// 계좌이체 (금액, 계좌번호, 비밀번호 확인)
				//ac.transfer();
				break;
			case 7:
				ac.balance();
			case 8:// 개인정보변경
				// ac.changeInfo();
				break;
			case 9:
				// ac.logout();
				break;
			case 10:	// 종료
				run = false; break;
			}
		}
		System.out.println("프로그램 종료");
	}

	

}
