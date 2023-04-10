package stream;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalEx2 {

	public static void main(String[] args) {
		Optional<String> optStr = Optional.of("abcde");
		//"abcde"를 값으로 가지는 Optional 생성
		System.out.println(optStr);
		Optional<Integer> optInt = optStr.map(String::length);
		//optStr의 요소에 String클래스의 length메서드를 적용한 값을 요소로 하는 Optional 반환
		System.out.println(optInt);
		
		int result1 = Optional.of("123") //"123"을 값으로 가지는 Optional을 생성하고
				.filter(s-> s.length()>0) //"123"의 길이가 0보다 크지 않으면 제거 
				.map(Integer::valueOf) //"123"에 Integer클래스의 valueOf메서드를 적용
				.get(); //Optional의 값을 반환 
		System.out.println(result1);
		
		int result2 = Optional.of("") //빈 문자열을 값으로 가지는 Optional을 생성하고
				.filter(s-> s.length()>0) //빈문자열의 길이가 0보다 크지 않기때문에 "" 제거 
				.map(Integer::valueOf) //Integer클래스의 valueOf메서드를 null에 적용불가능
				//map은 실행되지 않음
				.orElse(-1); //Optional의 값이 null이기때문에 -1을 반환
		System.out.println(result2);
		
		OptionalInt optInt1 = OptionalInt.of(0); //0을 저장하여 생성
		OptionalInt optInt2 = OptionalInt.empty(); //빈 객체를 생성
		
		System.out.println(optInt1.isPresent()); //값이 null이 아니므로 true
		System.out.println(optInt2.isPresent()); //값이 null이므로 false
		System.out.println(optInt1.equals(optInt2)); //iv인 isPresent 값이 다르므로 false
	}

}
