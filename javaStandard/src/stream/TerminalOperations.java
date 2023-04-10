package stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperations {

	public static void main(String[] args) {
		String[] strArr = {"apple","banana","bike","cat","dog","elelphant","fly","fire"};
		
		Stream.of(strArr) //String배열을 Stream<String>으로 만들고
		.parallel() //연산을 병렬처리
		.forEach(System.out::println); //스트림의 요소가 무작위로 출력됨
		
		System.out.println("============");
		
		Stream.of(strArr)
		.parallel()
		.forEachOrdered(System.out::println); //병렬처리된 스트림의 순서가 유지됨
		
		System.out.println("============");
		
		System.out.println( Stream.of(strArr)
				.noneMatch(s->s.length()==0) //모든 요소 s가 조건에 만족하지 않으면 true
				); 
		
		System.out.println("============");
		
		Optional<String> optStr = Stream.of(strArr) //String[]을 Stream<String>으로 변환
				.parallel() //연산을 병렬 처리
				.filter(s->s.charAt(0)=='b') //스트림의 요소중 'b'로 시작하는 요소만 남김
				.findAny(); //그 요소중 하나를 반환
		System.out.println(optStr.get()); //banana 또는 bike
		
		System.out.println("============");
		
		IntStream intStream = Stream.of(strArr).mapToInt(String::length);
		//map으로 변환할경우 Stream<Integer>가 반환되기 때문에 mapToInt로 기본형스트림 반환
		//strArr의 모든 요소를 저장한 스트림의 요소를 String의 길이로 변경
		int count = intStream.reduce(0, (a,b) -> a+1);
		//초기 a값은 0, Stream의 다음 요소를 b라할때 연산값을 새로운 a로 설정
		//다음 요소 b가 존재하지 않을때까지 반복하고 a반환
		//요소가 8개 존재하므로 초기값 0으로 a = a+1이 8번 반복되고 a를 반환
		System.out.println("count는 " + count);
		
		intStream = Stream.of(strArr).mapToInt(String::length);
		//최종연산을 했기때문에 다시 생성
		int sum = intStream.reduce(0, (a,b) -> a+b);
		//초기값은 0, (연산결과를a,다음요소를b라고 할때) -> 연산결과에 다음요소를 더한 값을 a로 설정
		//0+요소1 +요소2 +요소3 +...+요소8
		System.out.println("sum은 " + sum);
		
		intStream = Stream.of(strArr).mapToInt(String::length);
		OptionalInt max = intStream.reduce(Integer::max);
		//reduce가 max의 매개변수 2개와 리턴값으로 위의 연산을 진행하여
		//그 결과를 Optional<T> 형식으로 반환
		intStream = Stream.of(strArr).mapToInt(String::length);
		OptionalInt min = intStream.reduce(Integer::min);
		System.out.println("max는 " + max.getAsInt() + " min은 " + min.getAsInt());
		
		intStream = Stream.of(strArr).mapToInt(String::length);
		OptionalInt n = IntStream.empty().reduce(Integer::max);
		//빈 IntStream에 reduce연산 , n은 null이됨
		System.out.println(n.orElse(0)); //n이 null이면 대신 0을 반환
	}
}
