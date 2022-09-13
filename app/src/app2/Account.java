package app2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;

public class Account implements Bank{
	
	//private Scanner sc = new Scanner(System.in);
	
	private String name; // 이름
	private String id; // 아이디
	private int birth; // 생년월일
	private int accountNum; // 계좌번호
	private int pw; //비밀번호
	private int phone; // 전화번호
	
	private String joinDate; // 가입일
	private int balance = 0; //잔액
	private int login = 0; // 0은 로그인X, 1은 로그인O
	private static int total=0; // 가입자수 (실행동안 유지될 수 있게 static 변수로!)
	PrintWriter printw;
	BufferedReader br;
	public Account account; //field
	public Account() {}
	public Account (String name, String id, int pw, int birth, int phone) {
		this.name = name;
		this.id = id; 
		this.pw = pw; 
		this.birth = birth;
		this.phone = phone;  
		this.accountNum = makeAccountNum();
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = (cal.get(Calendar.MONTH)+1); // +1 꼭 해줘야 됨. 0부터 시작함
		int date = cal.get(Calendar.DATE);
		String joinDate = year + "년 " + month + "월 " + date + "일";
		this.joinDate = joinDate;
		this.balance = 0;
		this.login = 0;
	}
	 
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getLogin() {
		return login;
	}
	public void setLogin(int login) {
		this.login = login;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	public void deposit(int amount) {
		int idResult = 0;
		for(Account member : BankMenu.member) {
			if(member.getLogin() == 1) {
				idResult = 1;
				member.setBalance(member.getBalance()+amount);		
			}
			System.out.println(amount + "원이 입금되었습니다.");
			System.out.println("잔액은 " + member.getBalance() + "원입니다.");
		}
		if(idResult==0) {
			System.out.println("로그인 후 사용 가능합니다.");
		}
		System.out.println();
	}
	
 	public void withdraw(int amount) {
 		int idResult = 0;
 		for(Account member : BankMenu.member) {
			if(member.getLogin() == 1) {
				idResult = 1;
				if(amount <= member.getBalance() && amount<=max) {
					member.setBalance(member.getBalance()-amount);
					System.out.println(amount +"원이 출금되었습니다.");
					System.out.println("잔액은 " + member.getBalance() + "원입니다.");
				} else if (amount > member.getBalance()) {
					System.out.println("출금액이 잔액을 초과하여 출금할 수 없습니다.");
					System.out.println("출금액 : " + amount);
					System.out.println("잔액 : " + member.getBalance());
				} else if (amount <= member.getBalance() && amount > max) {
					System.out.println("최대 출금 가능액은 1000만원 입니다.");
				}
			}
		}
		if(idResult==0) {
			System.out.println("로그인 후 사용 가능합니다.");
		}
		System.out.println();
	}
	
	public void balance() {
		System.out.println("잔액확인 서비스입니다.>");
		int idResult = 0;
		for(Account member : BankMenu.member) {
			if(member.getLogin() == 1) {
				idResult = 1;
				System.out.println("잔액은 " + member.getBalance() + "원입니다.");
			}
		}
		if(idResult==0) {
			System.out.println("로그인 후 사용 가능합니다.");
		}
	}
	
	public void join(String name, String id, int pw, int birth, int phone) {
		// 1. 가입된 정보가 있는지 확인
		int idResult = 0;
		for(Account member : BankMenu.member) {
			if(member.getId() != null) {
				if(id.equals(member.getId()) && name.equals(member.getName())) {
					idResult = -1;
				System.out.println("해당 이름과 아이디로 가입된 회원이 있습니다.");
				break;
				}
			}
		}
		// 2. 계좌번호 생성, 잔고는 0으로 설정 & Member 배열에 담기
		if (idResult == 0) {
			//Account ac = new Account(name, id, pw, birth);
			account = new Account(name, id, pw, birth, phone);
			BankMenu.member.add(account);
			
			// 3. 가입완료
			System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println(name + "님의 가입이 완료되었습니다.");
			System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println("이름 :  " + name);
			System.out.println("아이디 :  " + id);
			System.out.println("계좌번호 :  " + account.accountNum);
			System.out.println("생년월일 :  " + birth);
			System.out.println("전화번호 :  " + phone);
			System.out.println("가입일 :  " + account.joinDate);
			System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			
			// 4. 가입회원수 +1
			setTotal(getTotal()+1);
			
			// 5. txt 파일로 저장
			File file = new File("C:/ioPractice/bankMember.txt");
			FileWriter fwriter = null;
			try {
				fwriter = new FileWriter(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			BufferedWriter bw = new BufferedWriter(fwriter);
			PrintWriter printw = new PrintWriter(bw, false);
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			printw.print("^"+account.name); 		//이름
			printw.print("^"+account.id);			// 아이디
			printw.print("^"+account.pw);			// 비밀번호
			printw.print("^"+account.accountNum);	// 계좌번호
			printw.print("^"+account.phone);		// 전화번호
			printw.print("^"+account.birth);		// 생년월일
			printw.print("^"+account.joinDate);	// 가입일
			printw.print("^"+account.balance);	// 잔액
			printw.println("^"+account.login);	// 로그인여부

			/*
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			printw.close();
			*/
			
		}
	}
	public void close() throws IOException {
		br.close();
		printw.close();
	}
	
	public void login(String id, int pw) throws NotLoginException{
		int loginCheck=-1;
		for(Account member : BankMenu.member) {
			if(id.equals(member.getId()) && pw==member.getPw()) {
				member.setLogin(1);
				loginCheck = 1;
				System.out.println(member.getName() + "님 로그인 되었습니다.");
			}
		}
		if(loginCheck==-1) {
			throw new NotLoginException();
		}
	}
	
	public int makeAccountNum() { // 계좌번호생성
		int result = 0;
		int accountNum = 000000;
		int tempAccountNum = (int) (Math.random()*899999+100000);
		
		for(Account member : BankMenu.member) {
			if(tempAccountNum == member.getAccountNum()) {
				result = -1;
			}
		}
		if (result == -1) { makeAccountNum(); }
		else accountNum = tempAccountNum;
		return accountNum;
	}
	
	public void changeInfo(int selectNo2, int afterInfo) {
		int idResult = 0;
		for(Account member : BankMenu.member) {
			if(member.getLogin() == 1) {
				idResult = 1;
				if (selectNo2 == 2) { // 전화번호 변경
					member.setPhone(afterInfo);
					System.out.println("전화번호가 변경되었습니다.");
				} else if (selectNo2 == 1) { // 비밀번호 변경
					member.setPw(afterInfo);
					System.out.println("비밀번호가 변경되었습니다.");
				}
			}
		}
		if(idResult==0) {
			System.out.println("로그인 후 사용 가능합니다.");
		}
	}
	
	public void transfer(int amount, int accountNum) {
		/*
		 * System.out.println("이체를 원하는 금액을 입력해주세요.>");
		 * int amount = sc.nextInt();
		 * System.out.println("이체를 원하는 계좌번호를 입력해주세요.>");
		 * int accountNum = sc.nextInt();
		 */
		int idResult = 0;
		for(Account member : BankMenu.member) {
			if(member.getLogin() == 1) {
				idResult = 1;
				if (amount > member.getBalance()) {
					System.out.println("이체액이 잔액을 초과하여 이체할 수 없습니다.");
				} else if(amount <= member.getBalance()) {
					for(Account member2 : BankMenu.member) {
						if(member2.accountNum == accountNum) {
							member2.setBalance(member2.getBalance()+amount);
						}
					}
					member.setBalance(member.getBalance()-amount);
					System.out.println(amount +"원이 이체되었습니다.");
					System.out.println("잔액은 " + member.getBalance() +"원입니다.");
				}
			}
		}
		if(idResult==0) {
			System.out.println("로그인 상태가 아닙니다.");
		}
	}
		
	public void logout() throws NotLoginingException{
		int idResult = 0;
		for(Account member : BankMenu.member) {
			if(member.getLogin() == 1) {
				idResult = 1;
				member.setLogin(0);
				System.out.println("로그아웃 되었습니다.");
			}
		}
		
		if(idResult==0) {
			throw new NotLoginingException();
		}
		// if(idResult==0) { System.out.println("로그인 상태가 아닙니다."); 
	}
	
	public void findInfo() throws NotLoginingException{
		int idResult = 0;
		for(Account member : BankMenu.member) {
			if(member.getLogin() == 1) {
				idResult = 1;
				System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
				System.out.println("이름 : " + member.name);
				System.out.println("ID : " + member.id);
				System.out.println("생년월일 : " + member.birth);
				System.out.println("전화번호 : " + member.phone);
				System.out.println("계좌번호 : " + member.accountNum);
				System.out.println("잔액 : " + member.balance + "원");
				System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			}
		}
		
		if(idResult==0) {
			throw new NotLoginingException();
		}
		// if(idResult==0) { System.out.println("로그인 상태가 아닙니다.");
	}

}
