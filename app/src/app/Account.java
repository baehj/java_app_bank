package app;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account implements Bank{
	
	private String name; //이름
	private String id; // 아이디
	private int birth; // 생년월일
	private int accountNum; // 계좌번호
	private int pw; // 비밀번호
	private int balance = 0; //잔액
	private int login = 0; // -1은 로그인X, 1은 로그인O
	private String loginTime; // 로그인 시간
	
	private static int max=0; // 가입자수 (실행동안 유지될 수 있게 static 변수로!)
	private static Account[] member = new Account[10];
	// 배열, 컬렉션 모두. Account를 담을 것이기 때문에 menu로 빼줘서 사용해야함. 
	
	public Account account; //field
	public Account() {}
	
	public Account (String name, String id, int pw, int birth) {
		
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.birth = birth;
		this.accountNum = makeAccountNum();
		this.balance = 0;
		this.login = 0;
	}
	
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
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
	

	public void deposit(int amount) {
		int idResult = 0;
		for(int i=0; i<member.length; i++) {
			if(member[i] == null) continue; 
			if(member[i].getLogin() == 1) {
				idResult = 1;
				member[i].setBalance(member[i].getBalance()+amount);		
			}
			System.out.println(amount + "원이 입금되었습니다.");
			System.out.println("잔액은 " + member[i].getBalance() + "원입니다.");
		}
		if(idResult==0) {
			System.out.println("로그인 후 사용 가능합니다.");
		}
		System.out.println();
	}
	
 	public void withdraw(int amount) {
		int idResult = 0;
		for(int i=0; i<member.length; i++) {
			if(member[i] == null) continue; 
			if(member[i].getLogin() == 1) {
				idResult = 1;
				if(amount <= member[i].getBalance() && amount<=max) {
					member[i].setBalance(member[i].getBalance()-amount);
					System.out.println(member[i].getName() + "님의 계좌에서 " + amount +"원이 출금되었습니다.");
					System.out.println("잔액은 " + member[i].getBalance() + "원입니다.");
				} else if (amount > member[i].getBalance()) {
					System.out.println("출금액이 잔액을 초과하여 출금할 수 없습니다.");
					System.out.println("출금액 : " + amount);
					System.out.println("잔액 : " + member[i].getBalance());
				} else if (amount > max) {
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
		for(int i=0; i<member.length; i++) {
			if(member[i] == null) continue; 
			if(member[i].getLogin() == 1) {
				idResult = 1;
				System.out.println("잔고금액은 " + member[i].getBalance() + "원입니다.");
			}
		}
		if(idResult==0) {
			System.out.println("로그인 후 사용 가능합니다.");
		}
	}
	
	public void join(String name, String id, int pw, int birth) {
		// 1. 가입된 정보가 있는지 확인
		int idResult = 0;
		for(int i=0; i<member.length; i++) {
			if(member[i] == null) continue;
			if(member[i].getId() != null) {
				if(id.equals(member[i].getId()) && name.equals(member[i].getName())) {
					idResult = -1;
				System.out.println("해당 이름과 아이디로 가입된 회원이 있습니다.");
				break;
				}
			}
		}
		// 2. 계좌번호 생성, 잔고는 0으로 설정 & Member 배열에 담기
		if (idResult == 0) {
			//Account ac = new Account(name, id, pw, birth);
			account = new Account(name, id, pw, birth);
			member[getMax()] = account;
		// 3. 가입완료
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println(member[getMax()].getName() + "님의 가입이 완료되었습니다.");
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println("이름 :  " + member[getMax()].getName());
		System.out.println("아이디 :  " + member[getMax()].getId());
		System.out.println("계좌번호 :  " + member[getMax()].getAccountNum());
		System.out.println("생년월일 :  " + member[getMax()].getBirth());
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		// 4. 가입회원수 +1
		setMax(getMax()+1);
		}
	}
	
	public int makeAccountNum() { // 계좌번호생성
		int result = 0;
		int accountNum = 000000;
		int tempAccountNum = (int) (Math.random()*899999+100000);
		for(int i=0; i<member.length; i++) {
			if(member[i] == null) continue;
			if(member[i].getId() != "") {
				if(tempAccountNum == member[i].getAccountNum()) {
					result = -1;
				} 
			}
		}
		if (result == -1) { makeAccountNum(); }
		else accountNum = tempAccountNum;
		return accountNum;
	}
	
	public void login(String id, int pw) {
		int iNum=-1;
		for(int i=0; i<member.length; i++) {
			if(member[i] == null) continue; 
			if(id.equals(member[i].getId()) && pw==member[i].getPw()) {
				member[i].setLogin(1);
				Date date = new Date();
				SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMddHHmmss"); // 년월일시분초
				this.loginTime = dtFormat.format(date);
				iNum = i;
				System.out.println(member[i].getName() + "로그인 되었습니다.");
			} 
		}
		if(iNum==-1) {
			System.out.println("아이디와 비밀번호를 확인해주세요.");
		}
	}
	
	

}
