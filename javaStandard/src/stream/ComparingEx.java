package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
class Student implements Comparable<Student>{
	String name;
	int ban;
	int totalScore;
	
	public Student(String name, int ban, int totalScore) {
		super();
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	@Override
	public int compareTo(Student s) {
		//sorted()할때 기본 Comparator의 compare()메서드가
		//비교 하는 대상의 CompareTo()메서드를 이용하므로
		//Student클래스가 CompareTo()메서드를 오버라이딩 하여 Comparable인터페이스를 구현 
		return s.totalScore - totalScore;
		//이 경우 -(totalScore - s.totalScore)로 원래 정렬기준의 반대부호를 리턴하도록 설정
	}

	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getTotalScore() {
		return totalScore;
	}

	@Override
	public String toString() {
		return name +", "+ ban + "반, "+ totalScore + "점";
	}
}
public class ComparingEx {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("김자바",1,280));
		list.add(new Student("박자바",2,180));
		list.add(new Student("이자바",3,200));
		list.add(new Student("권자바",1,150));
		list.add(new Student("신자바",3,220));
		list.add(new Student("최자바",2,300));
		
		Stream<Student> studentStream = list.stream();
		studentStream.sorted().forEach(System.out::println);
		//sorted()메서드에 Comparator가 따로 지정되지 않았으므로 기본 정렬기준을 사용
		//기본 정렬기준은 sorted()하는 요소의 CompareTo()메서드를 이용하므로
		//Student클래스에 오버라이딩한 CompareTo()메서드를 기준으로 정렬됨
		System.out.println("==================");
		
		studentStream = list.stream();
		studentStream.sorted(Comparator.comparing((s) -> s.getBan()))
		//comparing()에 들어온 Function의 반환값을 매개변수로 
		//Compare()메서드를 오버라이딩한 Comparator 객체를 반환
				/*
				 * public int compare(Student s1, Student s2) { 
				 * return s1.getBan() - s2.getBan(); 
				 * }
				 */
		.forEach(System.out::println);
		System.out.println("==================");

		studentStream = list.stream();
		studentStream.sorted(
				Comparator.comparing(Student::getBan)
				//Student 클래스의 getBan()메서드의 반환값을 매개변수로
				//Compare()메서드를 오버라이딩한 Comparator 객체를 반환
				.thenComparing(Comparator.naturalOrder()).reversed()
				//먼저 getBan() 메서드의 반환값을 비교하고, 
				//만약 두 객체의 getBan() 값이 같다면 naturalOrder().reversed() 메서드에 의해 
				//해당 객체들을 내림차순->오름차순으로 정렬
				//naturalOrder() : 기본정렬기준
				)
		.forEach(System.out::println);
	}
}
