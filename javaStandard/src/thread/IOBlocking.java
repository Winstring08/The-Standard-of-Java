package thread;

import javax.swing.JOptionPane;

public class IOBlocking {

	public static void main(String[] args) {
		Thread t = new Thread(new MyThread()); 
		//쓰레드의 생성자에 Runnable 인터페이스의 구현 객체를 대입하여 쓰레드 객체 생성
		t.start(); //새로운 호출스택을 만들어 run()메서드 실행
		
		String input = JOptionPane.showInputDialog("값을 입력해주세요").trim();
		//input이 존재하여 I/O Blocking이 발생하기 때문에 main()메서드 정지
		System.out.println(input);

	}

}

class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i=10; i>0; i--) {
			System.out.println(i); 
			//다른 쓰레드에서 실행되고 있기 때문에
			//I/O Blocking동안 카운트다운이 계속 실행됨
			try {
				Thread.sleep(1000); //이 시간동안 쓰레드가 휴식
			} catch (Exception e) {}
			
		}
		
	}
	
}
