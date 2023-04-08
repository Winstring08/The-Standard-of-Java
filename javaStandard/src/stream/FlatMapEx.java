package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapEx {

	public static void main(String[] args) {
		Stream<String[]> strArrStream = Stream.of(//Stream.of(배열) or (배열 요소 전체)
				new String[] {"abc","def","jkl"},
				new String[] {"ABC","GHI","JKL"}
		);
		
		strArrStream.flatMap(Arrays::stream) //=strArrStream.flatMap(arr -> Arrays.stream(arr));
		//그냥 map을 사용할경우 
		//Stream의 첫번째 요소인 {"abc","def","jkl"}가 Stream으로 변환되어 첫번째 요소가 되고
		//Stream의 두번째 요소인 {"ABC","GHI","JKL"}가 Stream으로 변환되어 두번째 요소가 되어
		//String을 요소로 가지는 Stream을 요소로 가지는 Stream (Stream< Stream<String> >) 이 됨
		//Stream<String>으로 내부 스트림을 하나로 합치기 위해서는 flatMap메서드를 사용해야 함
		.distinct() //중복제거
		.sorted() //정렬
		.forEach(System.out::println);
		
		Stream<String> lineStream = Arrays.stream(new String[] {
				"Beleve or not It is true",
				"Do or do not There is no try"
				});
		
		lineStream.flatMap( s -> Stream.of( s.split(" +") ) )
		//lineStream의 각각의 요소에 Function을 시행한 반환값인 각각의 Stream을 하나로 합침
		.map(String::toLowerCase) //소문자화
		.distinct() 
		.sorted()
		.forEach(System.out::println);
	}
}
