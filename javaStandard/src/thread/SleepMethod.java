package thread;

public class SleepMethod {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread2());
		
		t1.start();
		t2.start();

		try {
			Thread.sleep(1000*3);
			//t1.sleep(1000*3);
			//이렇게 실행해도 현재 실행중인 쓰레드인 main쓰레드가 일시정지됨
		} catch (InterruptedException e) {}
		System.out.println("메인 쓰레드 종료");
	}
	
	static void delay(int sec) {
		try {
			Thread.sleep(1000*sec); //sec초 동안 일시정지시키는 메서드 
		} catch (InterruptedException e) {}
	}
	
}

class Thread1 implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print("*");
		}
		System.out.println("th1 종료");
	}
	}

class Thread2 implements Runnable{

	@Override
	public void run() {
		SleepMethod.delay(2); 
		//delay()메서드에서 try-catch가 처리되었으므로 간편하게 사용 가능
		for(int i=0; i<300; i++) {
			System.out.print("#");
		}
		System.out.println("th2 종료");
	}
}

