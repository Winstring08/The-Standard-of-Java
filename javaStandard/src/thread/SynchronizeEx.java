package thread;

public class SynchronizeEx {

	public static void main(String[] args) {
		Runnable r = new mThread();
		new Thread(r).start();
		new Thread(r).start();
		//ThreadGroup에 의해 참조되므로 gc의 대상이 아님

	}

}

class Account {
	private int balance = 1000;
	//private로 해야 동기화의 의미가 있음
	public synchronized int getBalance() {
		//동기화된 메서드에서 읽어오는 변수이기 때문에 synchronized 
		//한 쓰레드가 값을 읽어오자마자 다른 쓰레드가 값을 변경 할 수 있음 
		return balance;
	}
	
	public synchronized void withdraw(int money) {
		//이 메서드를 동기화, 한 쓰레드가 이 메서드를 사용하는 동안
		//다른 쓰레드는 모든 임계영역을 사용할 수 없음
		if(balance >= money) { //잔고가 금액보다 크거나 같으면
			try {Thread.sleep(1000);} catch (Exception e) {} //오류 확인용 지연
			balance -= money; //금액을 뺀 값을 balance에 대입
		}
	}
	
}

class mThread implements Runnable{
	Account a = new Account();
	//공유 메모리(shared memory)
	//한 쓰레드에서 변경한 데이터는 다른 쓰레드에서도 바로 적용
	//모든 쓰레드가 동일한 Account 인스턴스를 공유하게 됨
	
	@Override
	public void run() {
		//Account a = new Account();
		//새로운 쓰레드가 실행될 때마다 Account 인스턴스를 새로 생성
		//각 쓰레드는 자신만의 Account 인스턴스를 가짐
		while (a.getBalance() > 0) {
			int money = (int)((Math.random()*3)+1)*100;
			//100~300의 임의의 수를 대입
			a.withdraw(money);
			System.out.println("잔고 : "+a.getBalance());
		}
		
	}
	
}
