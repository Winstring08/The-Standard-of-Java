package nextCh12;

import java.util.Arrays;
import java.util.List;

class Box<T> {
	T[] itemArr; //T타입 배열 선언
	T x; //T타입변수 x선언
	//static T y; //스태틱 변수의 타입으로 타입변수 사용 불가능
	
	T[] toArray() { //T타입 배열을 반환하는 메서드 선언
		T[] tmpArr = (T[]) new String[itemArr.length]; //T타입 배열인 tmpArr 선언
		//new T[itemArr.length]; 는 객체생성이므로 T타입으로 생성 불가능
		//(T[]) 형식으로 형변환 해야함
		return tmpArr;
	}
	
	
	/*
	 * static T[] Array(T t1) { //스태틱 메서드의 반환타입으로도 매개변수의 타입으로도 사용 불가능
	 * T[] tmpArr = (T[]) new String[5] ; return tmpArr; //스태틱 메서드 내부에서도 선언 불가능
	 * }
	 */
	 
	  public static <T> void printList(List<T> list) { //이곳의 타입변수 T는 클래스의 타입변수와 다름
		    for (T elem : list) { //List의 T타입 요소 elem을 순서대로 꺼내서 반복
		        System.out.print(elem + " ");
		    }
		}
}

public class GenericsEx {

	public static void main(String[] args) {
		Box<String> b = new Box<>(); //생성부의 parameterized type 생략 가능
		b.itemArr = new String[] { "1", "2", "3" };
		String[] arr2 = b.toArray();
		System.out.println(arr2.length);

		List<Integer> integerList = Arrays.asList(1, 2, 3); //1,2,3을 요소로 하는 List생성
		Box.printList(integerList); 
		//List<Integer> integerList이므로 T가 Integer라는것을 컴파일러가 추론 가능하여 생략 가능
		
		Box<? extends Object> box = new Box<String>();
		Box<String> strbox = (Box<String>) box;
	
	}

}
