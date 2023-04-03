package thread;

public class DaemonThreadEx implements Runnable{ //Runnable 인터페이스 구현
	static boolean autoSave; //main메서드가 static이므로 static으로 지정
		
	public static void main(String[] args) {
		Thread t = new Thread(new DaemonThreadEx());
		//Runnable 인터페이스 구현 객체를 Thread생성자에 대입하여 
		//새로운 thread객체 생성
		t.setDaemon(true); //setDaemon(true)로 데몬 쓰레드로 설정
		t.start(); //이 메서드는 반드시 setDaemon()보다 나중에 나와야 함
		
		for(int i=1; i<=10; i++) {
			try {
				Thread.sleep(1000); //1초마다 한번씩 실행되도록 sleep()설정
			} catch (Exception e) {}
			
			System.out.println(i);
			if(i==5) {
				autoSave=true; //i가 5라면 autoSave를 true로 변경
			}
		}

	}
	
	@Override
	public void run() { //run()메서드 구현
		while(true) { //무한 반복문으로 항상 실행되도록 만듦
			try {
				Thread.sleep(3*1000); //3초마다 한번씩 실행되도록 sleep()설정
			} catch (Exception e) {}
			if(autoSave) { //autoSave가 true로 변경되었다면 실행하도록 설정
				System.out.println("자동저장 되었습니다");
			}
		}
		}

}
