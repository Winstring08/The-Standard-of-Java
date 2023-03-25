package CollectionsFramework;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {

	public static void main(String[] args) {
		String[] arr = { "apple", "banana", "cat", "Dog" };

		Arrays.sort(arr); // 기본적으로 String의 Comparable에 의한 정렬
		System.out.println(Arrays.toString(arr)); // [Dog, apple, banana, cat]
		// 기본 정렬시 알파벳 대문자가 앞에 있게됨

		Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER); // 대소문자를 구분하지 않는 정렬 기준
		System.out.println(Arrays.toString(arr)); // [apple, banana, cat, Dog]

		Arrays.sort(arr, new MyComparator());
		// sort()메서드가 arr을 Object배열로 형변환하여 받고
		// Object[0],Object[1]의 값을 매개변수로 받은 Mycomparator객체의 compare메서드로 보냄
		System.out.println(Arrays.toString(arr)); // [cat, banana, apple, Dog]
	}
}

class MyComparator implements Comparator {
	public int compare(Object o1, Object o2) { // 받은 Object[0],Object[1]를 각각 o1,o2에 대입

		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			// Object타입에서 Comparable타입으로 형변환
			// String->(Object)String->(Comparable)String

			return c1.compareTo(c2) * -1;
			// Comparable타입이 되었으므로 String클래스가 구현한 compareTo()메서드 사용 가능
			// c1자기자신과 c2를 비교하여 c1이 더 크면 양수를 반환하지만 -1을 곱했으므로 반대로 반환
			// 이 반환방식을 sort()가 가진 compare()메서드가 사용
		}
		return -1; // Comparable타입으로 형변환 실패시 -1을 반환하도록 설정
	}
}


