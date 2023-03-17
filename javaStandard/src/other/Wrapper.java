package other;

public class Wrapper {

	public static void main(String[] args) {
		Integer ig = 100; //오토박싱 : 컴파일러가 기본형을 래퍼클래스 타입의 객체로 자동 형변환
		//컴파일러가 자동으로 100을 Integer.valueOf(100); 하여 래퍼클래스 타입의 객체로 자동 형변환함
		
		int i = ig; //언박싱 : 컴파일러가 래퍼클래스 객체를 기본형으로 자동 형변환
		//컴파일러가 ig를 ig.intValue(); 하여 기본형으로 자동 형변환함
		//intValue() 는 모든 래퍼클래스의 조상인 Number클래스가 가지고 있던것
		
		int n = Integer.valueOf("100"); //또한 valueOf() 는 문자열을 매개변수로 받기때문에 
		//문자열을 해당 래퍼클래스 타입으로 형변환할 수 있음
		//이경우 Integer타입으로 반환된 값이 언박싱으로 int타입으로 변환된것
		
		String s = ig.toString(); //래퍼클래스도 기본형의 메서드들을 가지고 있기 때문에 사용이 가능
	}
}
