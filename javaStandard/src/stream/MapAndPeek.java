package stream;

import java.io.File;
import java.util.stream.Stream;

public class MapAndPeek {

	public static void main(String[] args) {
		File[] fileArr = {new File("Ex1.java"),
				new File("Ex1.bak"),
				new File("Ex2.java"),
				new File("Ex1"),
				new File("Ex1.txt")};
		
		Stream<File> fileStream = Stream.of(fileArr);
		//File타입 fileStream에 fileArr을 Stream으로 변환후 넣고
		Stream<String> nameStream = fileStream.map(f-> f.getName());
		//String타입 nameStream에 fileStream의 모든 요소에 람다식을 시행하여 변환한 Stream을 넣음
		nameStream.forEach(System.out::println);
		System.out.println("===========");
		
		fileStream = Stream.of(fileArr); //최종연산을 했으므로 다시 생성
		fileStream.map(File::getName)
		//fileStream의 모든 요소를 File클래스의 getName메서드에 대입한 반환값을 요소로 하는 Stream을 생성
		.filter(s -> s.indexOf('.') != -1 ) // 람다식에서 false가 나온 요소를 제거
		// '.' 이 있는 번째수가 -1이 아닌( '.' 이 없지않은) 요소만 필터로 거름
		.peek(s -> System.out.println("확장자가 존재 "+s))
		//Stream의 모든 요소에 Consumer 람다식 실행
		.map(s -> s.substring(s.indexOf('.') +1 ))
		//Stream의 모든 요소에 람다식을 시행하여 그 리턴값을 요소로 하는 스트림 반환
		//Stream의 모든 요소의 '.'이 들어간 번째수+1 개의 문자를 제거('.'을 포함한 이전의 문자들을 제거)
		.peek(s -> System.out.println("확장자 : "+s))
		.map(String::toUpperCase)
		//Stream의 모든 요소에 String클래스의 toUpperCase(문자를 대문자로 변경)메서드 실행
		.distinct() //Stream에서 중복된 요소를 제거
		.forEach(System.out::println);
	}
}
