package thread;

import javax.swing.JOptionPane;

public class InterruptedMethod {
	
	public static void main(String[] args) {
		Thread t = new ThreadEx1();
		t.start();
		
		String input = JOptionPane.showInputDialog("아무거나 입력하세요");
		System.out.println(input);
		t.interrupt(); //t의 interrupted값을 true로 만들며 sleep()메서드를 즉시 중단
		System.out.println(t.isInterrupted()); //t의 interrupted값을 반환
		//t.interrupted(); //현재 쓰레드(main)의 interrupted값을 반환하고 false로 초기화
		//main쓰레드를 사용하는 중에는 참조변수가 t여도 main의 값을 반환
		}
		}
	
class ThreadEx1 extends Thread{
	
	@Override
	public void run() {
		int i=10;
		while(i !=0 && !isInterrupted() ) {
			//i가 0이 아니고 ThreadEx1의 interrupted가 true가 아닌동안
			System.out.println(i--); //i를 출력후 i--한다
			for(long x=0; x<1500000000000000000L; x++);
			//sleep()메서드를 사용하지 않고 출력 속도를 지연시키기 위함
			//sleep()메서드 사용시 interrupted변수값이 false로 초기화됨
		}
		System.out.println("종료");
			System.out.println(isInterrupted()); //현재 ThreadEx1의 interrupted 변수값 출력
			System.out.println(Thread.interrupted());
			//현재 쓰레드(ThreadEx1)의 interrupted값을 반환하고 false로 초기화
			System.out.println(isInterrupted()); //현재 ThreadEx1의 interrupted 변수값 출력
	}
}
	

