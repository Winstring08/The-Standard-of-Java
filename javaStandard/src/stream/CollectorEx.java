package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StudentMember { //name, id, pwd를 iv로 가지고 있는 클래스 생성
	String name;
	String id;
	String pwd;
	
	public StudentMember(String name, String id, String pwd) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
	}
	
	String getName() { //name값을 얻어올 메서드 생성
		return name;
	}
	
}

public class CollectorEx {

	public static void main(String[] args) {
		
		StudentMember[] stuArr = { //요소가 5개인 StudentMember배열 생성
				new StudentMember("짱구","aaa","111"),
				new StudentMember("유리","bbb","222"),
				new StudentMember("훈이","ccc","333"),
				new StudentMember("철수","ddd","444"),
				new StudentMember("맹구","eee","555")
		};
		
		Stream<StudentMember> stuStream = Stream.of(stuArr);
		//배열을 Stream으로 변환
		
		List<String> stuList = stuStream.map(StudentMember::getName)
				//각요소에 getName메서드 작업 실행한 리턴값들을 요소로 하는 Stream<String>반환
				.collect(Collectors.toList());
		//그 Stream<String>을 List로 변환
		
		
	}

}
