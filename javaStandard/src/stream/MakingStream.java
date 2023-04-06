package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MakingStream {

	public static void main(String[] args) {
		//Collection인터페이스의 stream()메서드로 컬렉션을 스트림으로 변환
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		//1,2,3,4,5를 요소로 가지는 List 객체를 생성
		Stream<Integer> intS = list.stream();
		//list를 stream으로 변환한 새로운 객체 반환
		intS.forEach(System.out::print); //forEach()최종연산
		//스트림의 모든 요소에 System.out의 print()메서드를 실행
		System.out.println();
		
		intS = list.stream();//다시 최종연산을 하기위해 stream을 새로 생성
		intS.forEach(System.out::print);
		System.out.println();
		
		//객체 배열로부터 스트림 생성
		
		Stream<String> strStream = Stream.of( "a","b","c" );
		//"a","b","c"를 요소로 가지는 Stream<String>객체 생성
		strStream.forEach(System.out::println);
		
		Stream<String> strStream2 = Stream.of( new String[] {"a","b","c"} );
		//new String[] {"a","b","c"}의 요소를 요소로 가지는 Stream<String>객체 생성
		strStream2.forEach(System.out::println);
		
		Stream<String> strStream3 = Arrays.stream( new String[] {"a","b","c"} );
		//new String[] {"a","b","c"}의 요소를 요소로 가지는 Stream<String>객체 생성
		strStream3.forEach(System.out::println);
		
		String[] arrS = new String[] {"a","b","c"};
		Stream<String> strStream4 = Arrays.stream( arrS );
		//arrS의 모든 요소를 요소로 가지는 Stream<String>객체 생성
		strStream4.forEach(System.out::println);
		
		int[] intArr = new int[] {1,2,3,4,5};
		//Stream<Integer> s = Arrays.stream(intArr); //에러
		//Arrays.stream() 메서드는 기본형 배열을 기본형 스트림(IntStream)으로 반환하기 때문에
		//Stream<Integer>타입인 s에 대입할 수 없음
		//integer[] intArr = new integer[] {1,2,3,4,5}; 로 생성했다면 Stream<Integer>를 반환
		
		//IntStream s = Stream.of(intArr); //에러
		//Stream.of()메서드는 기본형 배열을 참조형 스트림을 반환 Stream<Integer>
		
		IntStream s = Arrays.stream(intArr);
		//intArr의 모든 요소를 요소로 가지는 IntStream 반환
		System.out.println(s.count()); //s의 요소 개수 반환 //최종연산
		
		//IntStream만 가진 수를 다루는 유용한 메서드
		
		s = Arrays.stream(intArr); //최종연산을 했으므로 다시 stream객체 생성
		System.out.println(s.average()); //s의 모든 요소의 평균 반환 //최종연산
		
		s = Arrays.stream(intArr);
		System.out.println(s.sum()); //s의 모든 요소를 더한 값을 반환
		
		IntStream iStream = new Random().ints(); //무한스트림
		//랜덤한 값을 int값을 가지는 IntStream을 반환
		iStream.limit(5) //5개만 자르기
		//중간연산이므로 ;를 사용하지 않고 이어서 작성
		.forEach(System.out::println); //최종연산
		
		iStream = new Random().ints(10,5,10); // 10개만 자르기, 5이상, 10미만범위
		iStream.forEach(System.out::println);
		
		Stream<Integer> intSt = Stream.iterate(0, n-> n+2); //초기값, UnaryOperator
		//0을 초기값(seed)으로 다음 요소를 n+2로 가지는 스트림 반환
		intSt.limit(10).forEach(System.out::println);
		
		intSt = Stream.generate( ()-> 1 ); // Supplier
		//모든 요소를 1로 가지는 스트림 반환
		intSt.limit(5).forEach(System.out::println);
		
		intSt = Stream.generate(()-> 1);
	}

}
