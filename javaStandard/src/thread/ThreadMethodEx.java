package thread;

public class ThreadMethodEx {

	public static void main(String[] args) {
		MyThreadEx mt1 = new MyThreadEx("*");
		MyThreadEx mt2 = new MyThreadEx("**");
		MyThreadEx mt3 = new MyThreadEx("***");
		
		mt1.start();
		mt2.start();
		mt3.start();
		
		try {
			Thread.sleep(2000); //main쓰레드 2초간 일시정지
			mt1.suspend(); //main쓰레드가 mt1을 일시정지시킴
			Thread.sleep(2000); //그 후 main쓰레드 2초간 일시정지
			mt2.suspend(); //main쓰레드가 mt2를 일시정지시킴
			Thread.sleep(2000); //그 후 main쓰레드 2초간 일시정지
			mt1.resume(); //main쓰레드가 mt1을 다시 재개시킴
			Thread.sleep(2000); //그 후 main쓰레드 2초간 일시정지
			mt1.stop(); //main쓰레드가 mt1을 종료시킴
			mt2.stop(); //main쓰레드가 mt2를 종료시킴
			Thread.sleep(2000); //그 후 main쓰레드 2초간 일시정지
			mt3.stop(); //main쓰레드가 mt3를 종료시킴
		} catch (InterruptedException e) {}

	}

}

class MyThreadEx implements Runnable{
	
	volatile boolean suspended = false;
	//volatile : 변수의 값을 캐시에 저장하지 않고 메모리에서 직접 꺼내오도록 만듦
	volatile boolean stopped = false;
	Thread t;

	public MyThreadEx(String s) {
		t = new Thread(this,s); //s는 쓰레드의 이름
		//MyThreadEx객체 생성시 iv인 t에 
		//new Thread(자기자신의 객체,입력받은 문자)를 대입
	}

	void start() { //MyThreadEx에서 새로 정의한 start()메서드
		t.start(); //t는 Thread타입이므로 start()메서드 사용 가능
	}

	void suspend() {
		suspended = true;
		t.interrupt(); 
		//Thread.sleep(1000) 동안 suspended값이 바뀌어도 적용이 되지 않으므로
		//즉시 적용될 수 있도록 sleep을 깨움
		//안했을때 :suspend()메서드와 관계없이 하던 1초슬립 이후 빈 while문 무한반복
		//했을때 : suspend()메서드 실행 즉시 빈 while문 무한 반복
	}
	void resume() {
		suspended = false;
		
	}
	void stop() {
		stopped = true;
		t.interrupt();
	}
	@Override
	public void run() {
		while(!stopped) { //stopped 변수값이 true가 아닌동안
			if(!suspended) { //suspended 변수값이 true가 아니면
				System.out.println(Thread.currentThread().getName());
				//현재 쓰레드의 객체의 이름을 출력
				try {
					Thread.sleep(1000); //이름 출력후 1초간 일시정지
				} catch (InterruptedException e) {}
			} else {
				Thread.yield();
				//if문이 false인경우 while문이 무의미하게 돌아가는 busy-waiting상태가 되므로
				//쓰레드의 할당된 시간을 다른 쓰레드에게 양보
			}
		}
		
	}
	
}