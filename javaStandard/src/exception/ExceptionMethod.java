package exception;

public class ExceptionMethod {

	public static void main(String[] args) {
		System.out.println("1");
		System.out.println("2");
		try { //예외의 발생을 확인
			System.out.println("3");
			System.out.println(1/0); //예외 감지 //해당하는 예외의 인스턴스 생성
		    System.out.println("4");
		} catch (ArrayIndexOutOfBoundsException e) { //생성된 인스턴스와 타입이 일치하는 지 확인
			// TODO: handle exception
		} catch (ArithmeticException e) {//일치할경우 catch문을 수행
			e.printStackTrace(); 
			//예외 발생당시 호출스택에 있던 메서드와 생성된 인스턴스에 저장된 예외 메시지를 출력
		System.out.println(e.getMessage());//생성된 인스턴스에 저장된 예외 메시지를 반환
		}
		System.out.println("5"); 
		//catch에 성공하면 즉시 try-catch문을 빠져나가고 다음 문장을 이어서 실행
		System.out.println("6");
	}

}
