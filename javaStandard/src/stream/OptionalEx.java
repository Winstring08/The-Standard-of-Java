package stream;

import java.util.Optional;

public class OptionalEx {

	public static void main(String[] args) {
		//int[] arr = null; //바람직하지 않은 초기화
		int[] arr = new int[0];
		System.out.println("arr의 길이 : " + arr.length);
		
		//Optional<String> opt = null; //바람직하지 않은 초기화 방법
		Optional<String> opt = Optional.empty();
		
		String str = "";
		/*
		try {
			str = opt.get(); //opt의 값이 null이므로 예외 발생
		} catch (Exception e) {
			str = ""; //예외가 발생하면 str을 빈문자열로 초기화함
		}
		*/
		
		str = opt.orElse("null이면 이 문장을 출력"); 
		//Optional에 저장된 값이 null이면 매개변수를 반환
		//str = opt.orElseGet(()->new String()); 
		System.out.println(str);
		
		str = opt.orElseGet(String::new); 
		//opt의 값이 null이면 String클래스의 new 연산자의 연산값을 반환
		System.out.println("str은" + str);
	}
}
