package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		System.out.println();
		
		System.out.println("단순그룹화 - 성적별로 그룹화");
		Map<Student3.Level, List<Student3>> stuByLevel = Stream.of(stuArr).collect(
				Collectors.groupingBy(s -> {
					if(s.getScore() >= 200) {return Student3.Level.HIGH;}
					else if(s.getScore() >= 100) {return Student3.Level.MID;}
					else {return Student3.Level.LOW;}
					//키는 Function의 리턴값
					//범위에 따라 HIGH,MID,LOW 3가지 키가 존재
				})
				// 값은 각 범위별 요소를 요소로 하는 List<Student3>
				);
		TreeSet<Student3.Level> keySet = new TreeSet<>(stuByLevel.keySet());
		//Map의 key를 요소로 가지는 keySet의 모든 요소를 가지는 TreeSet 생성
		
		for(Student3.Level key : keySet) {
			//TreeSet의 요소중 하나인 Student3.Level타입 key에 대하여 순차반복
			System.out.printf("[%s]%n",key);
			//[key] 출력후 줄바꿈
			for(Student3 s : stuByLevel.get(key)) {
				//Map의 key에 해당하는 값인 List<Student3>의 요소 Student3로 반복
				System.out.println(s);
				//그 요소를 출력
			}
			System.out.println();
		}
		
		System.out.println("단순그룹화 - 통계(성적별 학생수)");
		Map<Student3.Level, Long> stuCntByLevel
		=Stream.of(stuArr).collect(Collectors.groupingBy(s -> {
					if(s.getScore() >= 200) {return Student3.Level.HIGH;}
					else if(s.getScore() >= 100) {return Student3.Level.MID;}
					else {return Student3.Level.LOW;}
					//키는 Function의 리턴값
					//범위에 따라 HIGH,MID,LOW 3가지 키가 존재
				}, Collectors.counting()));
		//값은 각 범위별 요소들을 counting()한 값
				
		for (Student3.Level key : stuCntByLevel.keySet()) {
			System.out.printf("[%s] - %d명 ", key, stuCntByLevel.get(key));
		}
		System.out.println();
		System.out.println();
		
		System.out.println("다중그룹화 (학년별, 반별)");
		Map<Integer, Map<Integer, List<Student3>> > stuByHakAndBan = 
				Stream.of(stuArr).collect(Collectors.groupingBy(
				Student3::getHak, Collectors.groupingBy(Student3::getBan)
				//키는 Student3의 getHak의 리턴값
				//값은 '키를 Student3의 getHak의 리턴값으로, 
				//값을 각 범위별 요소를 요소로 하는 List<Student3>로 하는 Map'으로 하는 Map
				));
		
		for(Map<Integer, List<Student3>> hak : stuByHakAndBan.values()) {
			//stuByHakAndBan 값들의 요소들중 하나인 
			//Map<Integer, List<Student3>>타입 hak에 대해 순차반복
			for(List<Student3> ban:hak.values()) {
				//hak의 값들의 요소중의 하나인 List<Student3>에 대해 순차 반복
				System.out.println();
				for(Student3 s :ban) {
					//ban의 요소들중 하나인 Student3에 대해 순차반복
					System.out.println(s);
					//그 요소를 출력
				}
			}
		}
		System.out.println();
				 
		System.out.println("다중그룹화 + 통계 (학년별, 반별 1등)");
		Map<Integer, Map<Integer, Student3>> topStuByHakAndBan = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student3::getHak,
						// 먼저 학년별로 Map을 만들고
						Collectors.groupingBy(Student3::getBan,
								// 나눠진 값으로 다시 반별로 Map을 생성
								Collectors.collectingAndThen(Collectors.maxBy(
										// maxBy사용으로 스코어가 가장 높은 Optional<Student3>가 값이 되지만
										// collectionAndThen으로 Optional::get 한 Student3가 값이됨
										// 반별로 나뉜 요소의 List-> 스코어가 가장 높은 요소-> 요소에 Optional::get을 적용한값
										Comparator.comparingInt(Student3::getScore)), Optional::get))));
		
		for(Map<Integer, Student3> hak : topStuByHakAndBan.values()) {
			//Map의 값들의 요소중 하나인 Map<Integer, Student3>에대해 순차반복
			for(Student3 s : hak.values()) {
				//hak의 값들의 요소중 하나인 Student3에 대해 순차 반복
				System.out.println(s);
				//그 Student3 출력
			}
		}
		System.out.println();
		
		System.out.println("다중그룹화 + 통계(학년별, 반별 성적그룹)");
		Map<String, Set<Student3.Level>> stuByScoreGroup =
		Stream.of(stuArr).collect(Collectors.groupingBy(
				s -> s.getHak() + "-" + s.getBan()
				//키는 요소의 Hak과 Ban을 '-'로 이어놓은 String
				, Collectors.mapping(s->{
					//값은 요소들에 mapping한 값
				if(s.getScore() >= 200) return Student3.Level.HIGH;	
				else if(s.getScore() >= 100) return Student3.Level.MID;	
				else return Student3.Level.LOW;	
				//요소의 getScore의 범위에 따라 HIGH,MID,LOW로 변환
				}, Collectors.toSet())
				//그것들을 Set으로 변환 (Set이기 때문에 중복은 삭제)
				));
		
		Set<String> keySet2 = stuByScoreGroup.keySet();
		//Map의 key를 Set으로 뽑아서
		
		for(String key : keySet2) {
			//Set의 요소중 하나인 key에 대해 순차반복
			System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
			//[key]와 키에 해당하는 값을 출력
		}
	}
}