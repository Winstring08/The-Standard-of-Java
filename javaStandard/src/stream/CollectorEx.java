package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StudentMember { //name, id, pwd를 iv로 가지고 있는 클래스 생성
	String name;
	int score;
	
	public StudentMember(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	String getName() { //name값을 얻어올 메서드 생성
		return name;
	}
	int getScore() { //score값을 얻어올 메서드 생성
		return score;
	}
	
}

public class CollectorEx {

	public static void main(String[] args) {
		
		StudentMember[] stuArr = { //요소가 5개인 StudentMember배열 생성
				new StudentMember("짱구",40),
				new StudentMember("유리",70),
				new StudentMember("훈이",50),
				new StudentMember("철수",100),
				new StudentMember("맹구",60)
		};
		
		Stream<StudentMember> stuStream = Stream.of(stuArr);
		//배열을 Stream으로 변환
		List<String> stuList = stuStream.map(StudentMember::getName)
				//각요소에 getName메서드 작업 실행한 리턴값들을 요소로 하는 Stream<String>반환
				.collect(Collectors.toList());
		//그 Stream<String>을 List로 변환, Set과 Map또한 toSet, toMap이 존재
		
		stuStream = Stream.of(stuArr);	
		ArrayList<String> stuArrayList = stuStream.map(StudentMember::getName)
		.collect(Collectors.toCollection(ArrayList::new));
		//Collection의 경우 toCollection()메서드의 매개변수로 new연산자를 대입
		
		stuStream = Stream.of(stuArr);	
		stuArr = stuStream.toArray(StudentMember[]::new);
		//Stream을 배열로 변환 할 때는 toArray()메서드의 매개변수로 해당배열의 new연산자를 대입
		
		stuStream = Stream.of(stuArr);	
		Object[] stuArr2 = stuStream.toArray();
		//매개변수를 지정하지 않으면 Object[]타입으로 리턴
		
		stuStream = Stream.of(stuArr);	
		long totalScore = stuStream.mapToInt(StudentMember::getScore).sum();
		//Stream의 요소에 getScore를 실행하여 리턴된 값을 요소로 하는 
		//IntStream의 모든 요소의 합
		
		stuStream = Stream.of(stuArr);	
		totalScore = stuStream.collect(Collectors.summingInt(StudentMember::getScore));
		//Stream의 요소에 getScore를 실행하여 리턴된 값을 처리하여 int로 변환
		
		stuStream = Stream.of(stuArr);	
		OptionalInt topScore = stuStream.mapToInt(StudentMember::getScore).max();
		////Stream의 요소에 getScore를 실행하여 리턴된 값을 요소로 하는 
		//IntStream의 모든 요소중 가장 큰 값
		//값이 null일수 있기때문에 int대신 OptionalInt사용
		
		stuStream = Stream.of(stuArr);	
		Optional<StudentMember> topStudent = stuStream
				.max(Comparator.comparingInt(StudentMember::getScore));
		//Stream의 요소에 getScore한 값으로 max를 비교 실제로 리턴하는것은 해당 요소
		
		stuStream = Stream.of(stuArr);	
		topStudent = stuStream
				.collect(Collectors.maxBy(Comparator.comparingInt(StudentMember::getScore)));
		//Stream의 요소에 getScore한 값으로 비교하여 가장 큰 값이 나온 요소를 리턴
		
		IntStream intStream = new Random().ints(1,46).distinct().limit(6);
		//1~45범위의 랜덤숫자를 요소로 가지는 무한스트림의 중복을 제거하고 6개 잘라냄
		Optional<Integer> max = intStream.boxed().collect(Collectors.reducing(Integer::max));
		//intStream을 박싱해서 Stream<Integer>로 만든뒤 [ collect( Collector ) 사용을 위해 ]
		//가장 큰 요소를 반환하는 BinaryOperator를 매개변수로 가장 큰 Integer를 반환
		
		stuStream = Stream.of(stuArr);	
		String studentNames = stuStream.map(StudentMember::getName)
				.collect(Collectors.joining());
		//모든 요소를 이어붙인 String 반환
		System.out.println(studentNames);
		
	}

}
