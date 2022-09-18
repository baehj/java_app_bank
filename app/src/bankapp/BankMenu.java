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
					if(rs.next()){ // 조회되는 값이 있다면(중복)
						do { // 없을때까지(중복x) 입력하게. 
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
						pstmt = conn.prepareStatement(user.selectUserNumById(id));
						rs = pstmt.executeQuery();
						if(rs.next()) { //가입한 id로 가입정보를 조회해서 
							User joinUserNum = new User().setUser_num(rs.getInt(1));
							int userNum = joinUserNum.getUser_num();
							// 계좌생성 성공할 때까지 insert시도. 
							do {
								pstmt = conn.prepareStatement(ac.createAccount(userNum));
								result = pstmt.executeUpdate();
								System.out.println(joinUserNum.getName() + "님 로그인 되었습니다.");
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
					rs = pstmt.executeQuery();
					
					pstmt = conn.prepareStatement(user.selectUserById(id));
					ResultSet rs1 = pstmt.executeQuery();
					
					if(rs1.next()) { // 일치하는 ID가 있다면? ID와 비밀번호가 일치할때까지 비밀번호를 입력시키고 로그인
						while(!rs.next()) {
							System.out.println("비밀번호를 다시 입력해주세요.>");
							password =  sc.next();
							pstmt = conn.prepareStatement(user.login(id, password));
							rs = pstmt.executeQuery();
						} 
						User loginUser = new User().setUser_num(rs.getInt(1)).setName(rs.getString(2)).setId(rs.getString(3))
								.setPassword(rs.getString(4)).setBirth(rs.getInt(5)).setPhone(rs.getInt(6))
								.setJoin_date(rs.getDate(7)).setAdmin(rs.getString(8));
						
						menu1(loginUser);
						if (run1 == false) { //로그아웃 했을 시 
							run1 = true;
							continue;}
					} else {
						System.out.println("가입되지 않은 아이디입니다. 가입 후 이용해주세요.>");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				continue;
				
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
						User findUser = new User().setUser_num(rs.getInt(1)).setName(rs.getString(2)).setId(rs.getString(3))
								.setPassword(rs.getString(4)).setBirth(rs.getInt(5)).setPhone(rs.getInt(6))
								.setJoin_date(rs.getDate(7)).setAdmin(rs.getString(8));
						// account 정보 찾아
						pstmt = conn.prepareStatement(ac.selectAcByUser_num(findUser.getUser_num()));
						rs = pstmt.executeQuery();
						if(rs.next()) {
						Account findAc = new Account().setAccount_num(rs.getInt(1)).setUser_num(rs.getInt(2)).setBalance(rs.getInt(3))
									.setRanking(rs.getInt(4));
						
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						System.out.println("이름 : " + findUser.getName());
						System.out.println("ID : " + findUser.getId());
						System.out.println("PW : " + findUser.getPassword());
						System.out.println("생년월일 : " + findUser.getBirth());
						System.out.println("전화번호 : " + findUser.getPhone());
						System.out.println("계좌번호 : " + findAc.getAccount_num());
						System.out.println("잔액 : " + findAc.getBalance() + "원");
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						}
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
	
	public static void menu1(User loginUser) {
		System.out.println("로그인 되었습니다.> ");
		while (run1) {
			System.out.println("-------------------------------------");
			System.out.println("1.입금 | 2.출금 | 3.이체 | 4.잔액확인 | 5.개인정보변경 | 6.로그아웃");
			System.out.println("-------------------------------------");
			System.out.print("선택 >>> ");
			int selectNo1 = sc.nextInt();
			switch (selectNo1) {
			case 1:
				System.out.print("입금 서비스입니다. 얼마를 입금하시겠습니까? >>> ");
				int amount = sc.nextInt();
				try {
					pstmt = conn.prepareStatement(ac.deposit(loginUser, amount)); // 계좌 잔액 변경
					int result = pstmt.executeUpdate();
					if(result > -1) {
						pstmt = conn.prepareStatement(ac.selectAcByUser_num(loginUser.getUser_num()));
						rs = pstmt.executeQuery();
						if(rs.next()) {
							Account loginAccount = new Account().setAccount_num(rs.getInt(1)).setUser_num(rs.getInt(2))
									.setBalance(rs.getInt(3)).setRanking(rs.getInt(4));
							
							pstmt = conn.prepareStatement(tl.insert(loginAccount, amount)); //거래내역에 기록
							result = pstmt.executeUpdate();
							if(result > -1) {
								System.out.println(amount + "원 입금 되었습니다. 입금 후 잔액은 " + loginAccount.getBalance() + "원 입니다.");
								System.out.println("다음 메뉴를 선택해주세요. >");
							}
						}	
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
				continue;
				
			case 2:
				System.out.println("출금 서비스입니다. 얼마를 출금하시겠습니까? >>> ");
				amount = sc.nextInt();
				try {
					pstmt = conn.prepareStatement(ac.withdraw(loginUser, amount)); // 계좌 잔액 변경
					int result = pstmt.executeUpdate();
					if(result > -1) {
						pstmt = conn.prepareStatement(ac.selectAcByUser_num(loginUser.getUser_num()));
						rs = pstmt.executeQuery();
						if(rs.next()) {
							Account loginAccount = new Account().setAccount_num(rs.getInt(1)).setUser_num(rs.getInt(2))
									.setBalance(rs.getInt(3)).setRanking(rs.getInt(4));
							
							pstmt = conn.prepareStatement(tl.insert(loginAccount, - amount)); //거래내역에 기록
							result = pstmt.executeUpdate();
							if(result > -1) {
								System.out.println(amount + "원 출금 되었습니다. 출금 후 잔액은 " + loginAccount.getBalance() + "원 입니다.");
								System.out.println("다음 메뉴를 선택해주세요. >");
							}
						}	
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
				continue;
				 
			case 3: // 계좌이체 
				System.out.println("이체를 원하는 금액을 입력해주세요. >>> ");
				amount = sc.nextInt();
				System.out.println("이체를 원하는 계좌번호를 입력해주세요. >>> ");
				int reciever_account_num = sc.nextInt();
				try {
					pstmt = conn.prepareStatement(ac.withdraw(loginUser, amount)); // 내 계좌 잔액 변경
					int result = pstmt.executeUpdate();
					if(result > -1) {
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
				continue;
				
			case 4:
				System.out.println("잔액확인 서비스입니다.");
				try {
					pstmt = conn.prepareStatement(ac.selectAcByUser_num(loginUser.getUser_num()));
					rs = pstmt.executeQuery();
					if(rs.next()) {
						Account loginAccount = new Account().setAccount_num(rs.getInt(1)).setUser_num(rs.getInt(2))
								.setBalance(rs.getInt(3)).setRanking(rs.getInt(4));
						System.out.println(loginUser.getName()+"님의 잔액은" + loginAccount.getBalance() + "원 입니다.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				continue;
				
			case 5: // 개인정보변경
				System.out.println("개인정보변경 서비스입니다. 변경을 원하는 정보를 골라주세요. >>> ");
				System.out.println("1.전화번호 | 2.비밀번호");
				int selectNo2 = sc.nextInt();
				if (selectNo2 == 1) {
					System.out.println("변경할 전화번호를 눌러주세요. >>> ");
					int afterPhone = sc.nextInt();
					try {
						pstmt = conn.prepareStatement(user.changePhone(loginUser.getUser_num(), afterPhone));
						result = pstmt.executeUpdate();
						if(result>-1) {
							System.out.println("전화번호가 010"+afterPhone+"번으로 변경되었습니다.");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else if(selectNo2 == 2) {
					System.out.println("변경할 비밀번호 눌러주세요>");
					int afterPw = sc.nextInt();
					try {
						pstmt = conn.prepareStatement(user.changePw(loginUser.getUser_num(), afterPw));
						result = pstmt.executeUpdate();
						if(result>-1) {
							System.out.println("비밀번호가 "+afterPw+"로 변경되었습니다.");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("1번 또는 2번을 눌러주세요.>");
					selectNo2 = sc.nextInt();
				}
				continue;
				
			case 6:	// 로그아웃
				int answer = 0;
				do {
					System.out.println("로그아웃 하시겠습니까? ");
					System.out.print("1.YES / 2.NO >>> ");
					answer = sc.nextInt();
					if(answer == 1) {
						System.out.println("로그아웃 되었습니다.");
						run1 = false;
						continue;
					} 
					else if (answer == 2) {
						System.out.println("로그아웃이 취소되었습니다. 메뉴로 돌아갑니다.");
						continue;
					}
					else {
						System.out.println("다시 입력해주세요.");
					}
				} while(answer != 1 && answer != 2);
				continue;
			
		}
	}
		
//	public static void menu2() {}
	
}
	
}
