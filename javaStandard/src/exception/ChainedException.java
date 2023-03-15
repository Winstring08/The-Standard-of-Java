package exception;

import java.io.IOException;

class MyException extends RuntimeException{ //사용자 정의 예외 클래스 
	//uncheked exception이므로 MyException 사용시 throws 생략 가능
	public MyException(String message) {
		super(message); //RuntimeException의 생성자를 그대로 쓴다는 의미
	}
}

public class ChainedException {

	public static void main(String[] args) throws IOException{
		try {
			method(); //IOException과 RuntimeException중 어느 예외가 발생해도 MyException 객체가 던져짐
		} catch (MyException e) { 
			e.printStackTrace(); //연결된 모든 메서드와 문구 출력
		}

	}

	static void method() throws IOException{ //checked exception인 IOException은 throws 해야함
		//랜덤 예외 던지기 장치
		int random = (int)(Math.random()*2);
		try {
			if(random==0)
			throw new IOException(); //checked exception이므로 반드시 예외처리를 해야함
			if(random==1)
			throw new RuntimeException(new ClassNotFoundException()); 
			//RuntimeException 생성자 속에 checked exception을 밀반입하여 RuntimeException으로 간주됨
			//checked exception의 연결방식
		} catch (IOException e) { //IOException이 감지되면
			MyException e2 = new MyException("통합 예외 메시지"); //MyException 객체를 생성하고
			e2.initCause(e); //MyException의 원인 예외를 IOException로 등록 
			//unchecked exception의 연결 방식
			throw e2; //인스턴스를 throw
			
		} catch (RuntimeException e) { //RuntimeException이 감지되도
			MyException e2 = new MyException("통합 예외 메시지"); //MyException 객체를 생성하고
			e2.initCause(e); //MyException의 원인 예외를 RuntimeException으로 등록
			//unchecked exception의 연결 방식
			throw e2; //인스턴스를 throw
		}
	}
}
