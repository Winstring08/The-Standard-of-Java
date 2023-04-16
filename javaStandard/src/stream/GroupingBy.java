package stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import stream.Student3.Level;

class Student3 {
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;
	
	public Student3(String name, boolean isMale, int hak, int ban, int score) {
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
	
	enum Level {
		HIGH, MID, LOW
	}
}
public class GroupingBy {

	public static void main(String[] args) {
		Student3[] stuArr = { 
				new Student3("나자바", true, 1, 1, 300),
				new Student3("김자바", false, 1, 1, 250),
				new Student3("이자바", true, 1, 1, 200),
				new Student3("박자바", false, 1, 2, 150),
				new Student3("홍자바", true, 1, 2, 100),
				new Student3("권자바", false, 1, 2, 50),
				new Student3("신자바", false, 1, 3, 100),
				new Student3("황자바", false, 1, 3, 150),
				new Student3("고자바", true, 1, 3, 200),
				new Student3("백자바", true, 2, 1, 300),
				new Student3("윤자바", false, 2, 1, 250),
				new Student3("조자바", true, 2, 1, 200),
				new Student3("강자바", false, 2, 2, 150),
				new Student3("안자바", true, 2, 2, 100),
				new Student3("한자바", false, 2, 2, 50),
				new Student3("최자바", false, 2, 3, 100),
				new Student3("남자바", false, 2, 3, 150),
				new Student3("정자바", true, 2, 3, 200),
		};
		
		System.out.println("단순 그룹화 - 반별로 그룹화");
		Map< Integer, List<Student3> > stuByBan = 
				Stream.of(stuArr).collect(Collectors.groupingBy(Student3::getBan));
		//키는 getBan의 리턴값, 값은 리턴값에 따라 나뉘는 요소들을 요소로 하는 List
		
		for(List<Student3> l : stuByBan.values()) {
			//stuByBan의 밸류들을 모아놓은 컬렉션의 요소 l에 대하여 반복
			for(Student3 s: l) {System.out.println(s);}
			//l의 요소 s에 대하여 반복, s를 출력
		}
		
		System.out.println("단순그룹화 - 성적별로 그룹화");
		Stream.of(stuArr).collect(
				Collectors.groupingBy(s -> {
					if(s.getScore() >= 200) {return Student3.Level.HIGH;}
					else if(s.getScore() >= 100) {return Student3.Level.MID;}
					else {return Student3.Level.LOW;}
				})
				);
		
	}

}
