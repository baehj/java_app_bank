package bankapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BankMenu {
	
	static Scanner sc = new Scanner(System.in);
	static Account ac = new Account();
	static User user = new User();
	static TransferList tl = new TransferList();
	static boolean run = true;
	static boolean run1 = true;
	static boolean run2 = true;
	static Connection conn = DBCon.getInstance().getConnection();
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	static int result=0;

	public static void main(String[] args) {
		
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.회원가입 | 2.로그인 | 3.가입정보찾기 | 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택 >>> ");
			int selectNo = sc.nextInt();
			
			switch (selectNo) {
			case 1: 
				System.out.println("회원가입 서비스입니다.>");
				System.out.print("이름을 입력해주세요. >>> ");
				String name = sc.next();
				System.out.print("전화번호를 입력해주세요.(010제외 8자리) >>> ");
				int phone =  sc.nextInt();
				
				try {
					pstmt = conn.prepareStatement(user.selectUserByPhone(phone));
					rs = pstmt.executeQuery();
	//				User joinUserNum = new User().setId(rs.getString(1));
	//				int userNum = joinUserNum.getUser_num();
					if(rs.next()){ // 조회되는 값이 있다면 
						do { // 없을때까지 입력하게. 
							System.out.println("해당 전화번호로 가입된 내역이 있습니다.");
							System.out.print("전화번호를 다시 입력해주세요.(010제외 8자리) >>> ");
							phone =  sc.nextInt();
							pstmt = conn.prepareStatement(user.selectUserByPhone(phone));
							rs = pstmt.executeQuery();
						} while(rs.next());
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				System.out.print("아이디를 입력해주세요. >>> ");
				String id = sc.next();
				try {
					pstmt = conn.prepareStatement(user.selectUserById(id));
					rs = pstmt.executeQuery();
					if(rs.next()){// 실패라면?
						do { // 성공할때까지 입력하게. 
							System.out.println("중복된 ID가 있습니다.");
							System.out.print("ID를 다시 입력해주세요. >>> ");
							id =  sc.next();
							pstmt = conn.prepareStatement(user.selectUserById(id));
							rs = pstmt.executeQuery();
						} while(rs.next());
					} 
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				System.out.print("비밀번호를 입력해주세요. >>> ");
				String password =  sc.next();
				System.out.print("생년월일을 입력해주세요.(8자리) >>> ");
				int birth =  sc.nextInt();
				
				try {
					pstmt = conn.prepareStatement(user.joinUser(name, id, password, birth, phone));
					result = pstmt.executeUpdate();
					if(result > -1) { //join입력이 제대로 되었다면? 
						// join된 userNum을 가져와서
						pstmt = conn.prepareStatement(user.selectUserByUserNum(id));
						rs = pstmt.executeQuery();
						if(rs.next()) { //가입한 id로 가입정보를 조회해서 
							User joinUserNum = new User().setUser_num(rs.getInt(1));
							int userNum = joinUserNum.getUser_num();
							// 계좌생성 성공할 때까지 insert시도. 
							do {
								pstmt = conn.prepareStatement(ac.createAccount(userNum));
								result = pstmt.executeUpdate();
								System.out.println("join성공");
							} while(result < 0);
						}
					} 
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				continue;
			
			case 2: 
				System.out.println("로그인 서비스입니다.>");
				System.out.print("아이디를 입력해주세요. >>> ");
				id = sc.next();
				System.out.print("비밀번호를 입력해주세요. >>> ");
				password =  sc.next();
				
				try {
					pstmt = conn.prepareStatement(user.login(id, password));
					result = pstmt.executeUpdate();
					if(result > -1) { //login이 제대로 되었다면? 
						pstmt = conn.prepareStatement(user.selectUserById(id));
						rs = pstmt.executeQuery();
						if(rs.next()){
							// rs에 있는걸 
							User loginUser = new User().setUser_num(rs.getInt(1)).setName(rs.getString(2)).setId(rs.getString(3))
									.setPassword(rs.getString(4)).setBirth(rs.getInt(5)).setPhone(rs.getInt(6))
									.setJoin_date(rs.getDate(7)).setLogin_check(rs.getString(8));
							menu1();
						} 
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (run1 == false) {
					run = false;
					break;
				}
				else continue;
				
			case 3:
				
				System.out.println("가입정보찾기 서비스입니다.>");
				System.out.print("이름을 입력해주세요. >>> ");
				name = sc.next();
				System.out.print("전화번호를 입력해주세요. >>> ");
				phone =  sc.nextInt();
		
				try {
					pstmt = conn.prepareStatement(user.selectUserByNamePhone(name, phone));
					rs = pstmt.executeQuery();
					if(rs.next()) { //selectByNamePhone이 제대로 되었다면? 
						// user 정보 찾아
						User findUser = new User().setAccount_num(rs.getInt(1)).setName(rs.getString(2)).setId(rs.getString(3))
								.setPassword(rs.getString(4)).setBirth(rs.getInt(5)).setPhone(rs.getInt(6))
								.setJoin_date(rs.getDate(7)).setLogin_check(rs.getString(8));
						// account 정보 찾아
						pstmt = conn.prepareStatement(ac.selectAcByUser_num(findUser.getUser_num()));
						rs = pstmt.executeQuery();
						if(rs.next()) {
							
							
				////////////////////////////////// 여기 하던중!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
							Account findAc = new Account().setUser_num(rs.getInt(1)).setName(rs.getString(2)).setId(rs.getString(3))
									.setPassword(rs.getString(4)).setBirth(rs.getInt(5)).setPhone(rs.getInt(6))
									.setJoin_date(rs.getDate(7)).setLogin_check(rs.getString(8));
						}
						
						
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						System.out.println("이름 : " + findUser.getName());
						System.out.println("ID : " + findUser.getId());
						System.out.println("생년월일 : " + findUser.getBirth());
						System.out.println("전화번호 : " + findUser.getPhone());
						System.out.println("계좌번호 : " + findUser.);
						System.out.println("잔액 : " +  + "원");
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				continue;
				
			case 4: // 종료
				run = false;
				break;
			}
		}
		
		System.out.println("프로그램 종료");
	}
	
	public static void menu1() {
		while (run1) {
			
			System.out.println("로그인 되었습니다. 원하시는 메뉴의 번호를 눌러주세요. >>> ");
			System.out.println("-------------------------------------");
			System.out.println("1.입금 | 2.출금 | 3.이체 | 4.잔액확인 | 5.개인정보변경 | 6.로그아웃 | 7.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택 >>> ");
			int selectNo1 = sc.nextInt();
			switch (selectNo1) {
			case 1:
				System.out.println("입금 서비스입니다. 얼마를 입금하시겠습니까?>");
				int amount = sc.nextInt();
		//		ac.deposit(sc.nextInt());
				try {
					pstmt = conn.prepareStatement(ac.deposit(amount));
					int result = pstmt.executeUpdate();
					String msg = result > -1 ? "성공" : "실패";
					System.out.println(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				continue;
				
			case 2:
				System.out.println("출금 서비스입니다. 얼마를 출금하시겠습니까?>");
		//		ac.withdraw(sc.nextInt());
				continue;
				
			case 3: // 계좌이체 
				System.out.println("이체를 원하는 금액을 입력해주세요.>");
				amount = sc.nextInt();
				System.out.println("이체를 원하는 계좌번호를 입력해주세요.>");
				int accountNum = sc.nextInt();
		//		ac.transfer(amount, accountNum);
				continue;
				
			case 4:
		//		ac.balance();
				continue;
				
			case 5: // 개인정보변경
				System.out.println("개인정보변경 서비스입니다. 변경을 원하는 정보 번호를 입력해주세요.>");
				System.out.println("1.비밀번호 | 2.전화번호");
				int selectNo2 = sc.nextInt();
				if (selectNo2 == 1) {
					System.out.println("변경하실 비밀번호를 눌러주세요>");
					int afterInfo = sc.nextInt();
		//			user.changeInfo(1, afterInfo);
				} else if(selectNo2 == 2) {
					System.out.println("변경하실 전화번호를 눌러주세요>");
					int afterInfo = sc.nextInt();
		//			user.changeInfo(2, afterInfo);
				} else {
					System.out.println("1번 또는 2번을 눌러주세요.>");
					selectNo2 = sc.nextInt();
				}
				continue;
				
			case 6:	// 로그아웃
				System.out.println("로그아웃 하시겠습니까? 1.YES / 2.NO >");
				int answer = sc.nextInt();
				if(answer == 1) { 
					try {
		//				user.logout();
					} catch (Exception e) {
						e.getMessage();
					}
				}
				else System.out.println("전체메뉴로 돌아갑니다."); 
				continue;
				
			case 7: // 종료
				run1 = false;
				break;
		}
	}
		
//	public static void menu2() {}
	
}
	
}
