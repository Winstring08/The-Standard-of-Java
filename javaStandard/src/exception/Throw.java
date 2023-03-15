package exception;

public class Throw {

	public static void main(String[] args) {
		try {
			Exception e = new Exception("출력할 예외 메시지");//예외 객체 생성
			throw e; //인공적으로 예외를 발생시킴, catch로 throw
		} catch (Exception e) { //던져진 객체와 타입이 일치하는 지 확인
			e.printStackTrace();//예외 발생당시 호출스택에 있던 메서드와 생성된 인스턴스에 저장된 예외 메시지를 출력
		}
	}
}
