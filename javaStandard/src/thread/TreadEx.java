package thread;


public class TreadEx {

	public static void main(String[] args) {
		Thread t = new MyThread1(); //쓰레드 객체 생성
		
		Runnable r = new MyThread2(); //먼저 인터페이스 객체 생성
		Thread t2 = new Thread(r);	 
		//쓰레드의 생성자에 매개변수로 Runnable인터페이스의 구현 객체를 대입	
		
		t.start(); 
		t2.start();
		//위의 두 작업이 각각 다른 쓰레드에서 
		//OS 스케쥴러가 결정하는 실행순서에 따라 번갈아 가면서 실행됨

	}

}

class MyThread1 extends Thread{ //Thread클래스 상속으로 구현
	@Override
	public void run() { //쓰레드가 수행할 작업
		for(int i=0; i<500; i++) {
			System.out.print(getName()); // 쓰레드 이름을 반환
			//Thread클래스를 상속받았으므로 getName()메서드를 가지고 있음
		}
	}
}
	class MyThread2 implements Runnable{ //Runnable 인터페이스 구현으로 구현

		@Override
		public void run() { //쓰레드가 수행할 작업
			for(int i=0; i<500; i++) {
				System.out.print(Thread.currentThread().getName());
				//Thread를 상속받지 않았으므로 currentThread()메서드를 이용해서
				//Thread객체를 참조하고 Thread클래스에서 접근해야 함
			}
			
		}
		
	}