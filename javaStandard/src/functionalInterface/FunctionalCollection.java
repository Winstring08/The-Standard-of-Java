package functionalInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionalCollection {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		
		list.forEach(i->System.out.print(i+", "));
		//list의 모든 요소를 매개변수로 Consumer 람다식 실행
		System.out.println();
		
		list.removeIf(i -> i%2 != 0 || i%3 == 0);
		//list의 모든 요소를 매개변수로 Predicate 람다식을 수행후 true인 요소 삭제
		System.out.println(list);
		
		list.replaceAll(i -> i*10);
		//list의 모든 요소를 매개변수로 UnaryOperator 람다식을 수행하여 교체
		System.out.println(list);
		
		Map<String,String> map = new HashMap<>();
		map.put("a", "apple");
		map.put("b", "banana");
		map.put("c", "cat");
		map.put("d", "dog");
		
		map.forEach((k,v) -> System.out.printf("키는 %s 값은 %s%n",k,v));
		//map의 모든 요소의 키와 값을 매개변수로 BiConsumer 람다식을 수행
	}
}
