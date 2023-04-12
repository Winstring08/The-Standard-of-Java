package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorEx {

	public static void main(String[] args) {
		
		String[] stuArr = {"김자바","이자바","박자바","권자바","신자바"};
		
		Stream<String> stuStream = Stream.of(stuArr);
		
		List<String> names = stuStream.collect(Collectors.toList());
		
		ArrayList<String> list = names.stream().collect(
				Collectors.toCollection(ArrayList::new)
				);
		
		Map<String,String>map = stuStream.collect(
				Collectors.toMap(p->p + "의 키", p->p + "의 값")
				);
		
		Student[] stuName = stuStream.toArray(Student[]::new);
		//Student[] stuName = stuStream.toArray(); 불가능
		Object[] stuNames = stuStream.toArray();
		
		long count = stuStream.count();
		count = stuStream.collect(Collectors.counting());
	}

}
