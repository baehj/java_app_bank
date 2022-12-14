package app2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankMenu {
	
	static int balance, amount = 0;
	static List<Account> member = new ArrayList();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		Account ac = new Account();
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.회원가입 | 2.로그인 | 3.개인정보찾기 | 4.입금 | 5.출금 |"
					+ "\n6.계좌이체 | 7.잔고확인 | 8.개인정보변경 | 9.로그아웃 | 10.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택 >>> ");
			int selectNo = sc.nextInt();
//			int selectNo = new Scanner (System.in).nextInt();
//			int selectNo = 1;			
			switch (selectNo) {
			
			case 1: 
				System.out.println("회원가입 서비스입니다.>");
				System.out.print("이름을 입력해주세요. >>> ");
				String name = sc.next();
				System.out.print("아이디를 입력해주세요. >>> ");
				String id = sc.next();
				System.out.print("비밀번호를 입력해주세요.(4자리) >>> ");
				int pw =  sc.nextInt();
				System.out.print("생년월일을 입력해주세요.(8자리) >>> ");
				int birth =  sc.nextInt();
				System.out.print("전화번호를 입력해주세요.(010제외 8자리) >>> ");
				int phone =  sc.nextInt();
				join(name, id, pw, birth, phone);
				continue;
				
			case 2: 
				System.out.println("로그인 서비스입니다.>");
				System.out.print("아이디를 입력해주세요. >>> ");
				id = sc.next();
				System.out.print("비밀번호를 입력해주세요. >>> ");
				pw =  sc.nextInt();
				
				try {
					ac.login(id, pw);
				} catch (Exception e) {
					e.getMessage();
				}
				continue;
			
			case 3:
				try {
					ac.findInfo();
				} catch (Exception e) {
					e.getMessage();
				}
				continue;
				
			case 4:
				System.out.println("입금 서비스입니다. 얼마를 입금하시겠습니까?>");
				ac.deposit(sc.nextInt());
				continue;
				
			case 5:
				System.out.println("출금 서비스입니다. 얼마를 출금하시겠습니까?>");
				ac.withdraw(sc.nextInt());
				continue;
				
			case 6: // 계좌이체 
				System.out.println("이체를 원하는 금액을 입력해주세요.>");
				int amount = sc.nextInt();
				System.out.println("이체를 원하는 계좌번호를 입력해주세요.>");
				int accountNum = sc.nextInt();
				ac.transfer(amount, accountNum);
				continue;
				
			case 7:
				ac.balance();
				continue;
				
			case 8: // 개인정보변경
				System.out.println("개인정보변경 서비스입니다. 변경을 원하는 정보 번호를 입력해주세요.>");
				System.out.println("1.비밀번호 | 2.전화번호");
				int selectNo2 = sc.nextInt();
				if (selectNo == 1) {
					System.out.println("변경하실 비밀번호를 눌러주세요>");
					int afterInfo = sc.nextInt();
					ac.changeInfo(1, afterInfo);
				} else if(selectNo == 2) {
					System.out.println("변경하실 전화번호를 눌러주세요>");
					int afterInfo = sc.nextInt();
					ac.changeInfo(2, afterInfo);
				} else {
					System.out.println("1번 또는 2번을 눌러주세요.>");
					selectNo2 = sc.nextInt();
				}
				continue;
				
			case 9:	// 로그아웃
				System.out.println("로그아웃 하시겠습니까? 1.YES / 2.NO >");
				int answer = sc.nextInt();
				if(answer == 1) { 
					try {
						ac.logout();
					} catch (Exception e) {
						e.getMessage();
					}
				}
				else System.out.println("전체메뉴로 돌아갑니다."); 
				continue;
				
			case 10: // 종료
				run = false;
				break;
			}
		}
		try {
			ac.close();
		}catch(IOException e) {e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}

	private static void join(String name, String id, int pw, int birth, int phone) {
		join(name, id, pw, birth, phone);
	}

	
	
}
