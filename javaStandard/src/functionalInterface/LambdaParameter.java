package functionalInterface;
@FunctionalInterface 
interface Lambda{
	void run();
}
public class LambdaParameter {
	
	static void execute(Lambda l) { //Lambda 구현체를 매개변수로 받아서
		l.run(); //Lambda 구현체의 run()메서드를 실행
	}
	
	static Lambda getLambda() { //Lambda 구현체를 반환하는 함수
		return () -> System.out.println("Lambda 구현체를 리턴받아 실행"); 
		//람다 구현체를 반환
	}

	public static void main(String[] args) {
		Lambda l = ()->System.out.println("Lambda타입 참조변수로 실행");
		l.run();
		
		execute( ()->System.out.println("Lambda 구현체를 매개변수로 받아서 실행") );
		
		getLambda().run(); //반환받은 람다 구현체의 run()메서드 실행

	}

}
