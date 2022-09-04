package app;

public class Account implements Bank{
	
	private String name; //이름
	private String id; // 아이디
	private int birth; // 생년월일
	private int accountNum; // 계좌번호
	private int pw; //비밀번호
	private int balance=0; //잔액
	// private int creditRating; // 신용등급
	
	private static int max=0; // 가입자수 (실행동안 유지될 수 있게 static 변수로!)
	private static Account[] member = new Account[10];
	
	public Account account; //field
    
	public Account() {}
	
	public Account (String name, String id, int pw, int birth) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.birth = birth;
		this.accountNum = makeAccountNum();
		this.balance = 0;
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
	
	/*
	 * public int getCreditRating() { return creditRating; } public void
	 * setCreditRating(int creditRating) { this.creditRating = creditRating; }
	 */
	
	
	public void deposit(int amount) {
		System.out.println("예금 서비스입니다. 얼마를 입금하시겠습니까?>");
		Account ac = new Account();
		ac.setBalance(ac.getBalance()+amount);
		System.out.println(amount + "원이 입금되었습니다.");
		System.out.println("잔고금액은 " + ac.getBalance() + "원입니다.");
		System.out.println();
	}
	
 	
	public void withdraw(int amount) {
		System.out.println("출금 서비스입니다. 얼마를 출금하시겠습니까?>");
		Account ac = new Account();
		if (amount <= ac.getBalance() && amount<=max) {
			ac.setBalance(ac.getBalance()-amount);
			System.out.println(amount +"원이 출금되었습니다.");
			System.out.println("잔고금액은 " + ac.getBalance() + "원입니다.");
		} else if (amount > ac.getBalance() && amount<=max) {
			System.out.println("출금금액이 잔고금액을 초과하였습니다");
		}
		System.out.println();
	}
	
	public void balance() {
		System.out.println("잔액확인 서비스입니다.>");
		Account ac = new Account();
		System.out.println("잔고금액은 " + ac.getBalance() + "원입니다.");
		System.out.println();
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
			System.out.println(getMax());
		
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
		// setMax(getMax()+1);
		// System.out.println(getMax());
		}
	}
	
	public int makeAccountNum() {
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
		Account ac = new Account();
		if(id.equals(ac.getId()) && pw==getPw()) {
			System.out.println(ac.getName() + "님 로그인되었습니다.");
		} else {
			System.out.println("올바른 회원 정보가 아닙니다.");
		}		
	}
	
	/*
	 * public static check(String id, int pw) { if(id.equals(ac.getId()) &&
	 * pw==getPw()) { System.out.println(ac.getName() + "님 로그인되었습니다."); } else {
	 * System.out.println("올바른 회원 정보가 아닙니다."); } return; }
	 */

}
