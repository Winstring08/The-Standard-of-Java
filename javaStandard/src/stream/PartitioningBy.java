package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student2 {
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;
	
	public Student2(String name, boolean isMale, int hak, int ban, int score) {
		super();
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public boolean isMale() {
		return isMale;
	}

	public int getHak() {
		return hak;
	}

	public int getBan() {
		return ban;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return String.format(
				"[%s, %s, %d학년 %d반, %3d점]", name, isMale?"남":"여",hak,ban,score);
	}
}
public class PartitioningBy {

	public static void main(String[] args) {
		Student2[] stuArr = { 
				new Student2("나자바", true, 1, 1, 300),
				new Student2("김자바", false, 1, 1, 250),
				new Student2("이자바", true, 1, 1, 200),
				new Student2("박자바", false, 1, 2, 150),
				new Student2("홍자바", true, 1, 2, 100),
				new Student2("권자바", false, 1, 2, 50),
				new Student2("신자바", false, 1, 3, 100),
				new Student2("황자바", false, 1, 3, 150),
				new Student2("고자바", true, 1, 3, 200),
				new Student2("백자바", true, 2, 1, 300),
				new Student2("윤자바", false, 2, 1, 250),
				new Student2("조자바", true, 2, 1, 200),
				new Student2("강자바", false, 2, 2, 150),
				new Student2("안자바", true, 2, 2, 100),
				new Student2("한자바", false, 2, 2, 50),
				new Student2("최자바", false, 2, 3, 100),
				new Student2("남자바", false, 2, 3, 150),
				new Student2("정자바", true, 2, 3, 200),
		};
		
		System.out.println("단순분할 - 성별로 분할");
		Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr)
		.collect(Collectors.partitioningBy(Student2::isMale) );
		//키를 true/false, 값을 isMale()메서드(Predicate)의 boolean 리턴값에 따라
		//양분되는 요소들을 요소로 가지는 List로하는 Map을 반환
		
		List<Student2> maleStudent = stuBySex.get(true);
		//키가 true인 List값을 maleStudent에 저장
		List<Student2> femaleStudent = stuBySex.get(false);
		//키가 false인 List값을 femaleStudent에 저장
		
		for(Student2 s : maleStudent) { System.out.println(s); }
		for(Student2 s : femaleStudent) { System.out.println(s); }
		
		System.out.println("단순분할 - 성별 학생수");
		Map<Boolean,Long> stuNumBySex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Student2::isMale,
						Collectors.counting())
						);
		//기본적으로 양분되는 값을 모아놓은 List를 값으로 하지만
		//따로 Collector를 지정한 경우 그것을 값으로 가지는 Map을 반환
		//이번에는 요소의 개수로 지정했으므로 키는 true/false, 값은 그 키의 요소의 개수
		
		System.out.println("남학생 : " + stuNumBySex.get(true));
		System.out.println("여학생 : " + stuNumBySex.get(false));
		
		System.out.println("단순분할 - 통계(성별 1등)");
		Map<Boolean, Optional<Student2>> topScoreBySex = 
				Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale,
				Collectors.maxBy(Comparator.comparingInt(Student2::getScore))
				//이번에는 매개변수로 maxBy()메서드를 넣었으므로 이 반환값을 값으로 가짐
				//Student2의 Score값을 비교하여 가장 큰 Student2를 반환하므로
				//Map<Boolean, Optional<Student2> 인 맵을 반환
				));
		
		System.out.println(topScoreBySex.get(true).get());
		System.out.println(topScoreBySex.get(false).get());
		//Map의 값이 Optional이므로 값을 빼오는 get()메서드를 사용
		
		Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex = 
				Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale,
				Collectors.partitioningBy(s->s.getScore()<=100)));
		//이번에는 매개변수로 partitioningBy()메서드가 들어값으므로 이것의 반환값인
		//Map<Boolean, List<Student2>를 값으로 가짐
		//요소의 score값이 100보다 작거나 같은지 보고 
		//true키로 true인 값들을 요소로 하는 List를 값으로 하는
		//false키로 false인 값들을 요소로 하는 List를 값으로 하는 Map을 반환하므로
		//Map<Boolean, Map<Boolean, List<Student2>> > 인 맵을 반환
		
		List<Student2> failedMaleStu = failedStuBySex.get(true).get(true);
		//failedStuBySex Map의 true를 키로하는 값인 Map의 true를 키로 하는 List
		List<Student2> failedFemaleStu = failedStuBySex.get(false).get(true);
		
		for(Student2 s : failedMaleStu) {System.out.println(s);};
		for(Student2 s : failedFemaleStu) {System.out.println(s);};
	}
}
