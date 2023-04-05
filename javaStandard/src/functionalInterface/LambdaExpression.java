package functionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
interface Lamb {
	int max(int a, int b);
}

public class LambdaExpression {

	public static void main(String[] args) {
		Lamb l = (a,b)->a>b?a:b; 
		//Lamb l = new Lamb(){ public int max(int a,int b){return a>b?a:b;}  };
		//익명 클래스를 사용하는것과 같다
		int value= l.max(3, 6);
		System.out.println(value);
		
		List<String> list = new ArrayList<String>();
		list.add("banana");
		list.add("orange");
		list.add("apple");
		Collections.sort(list, (s1,s2)->s2.compareTo(s1) ); //반대로 정렬
		//Comparator는 함수형 인터페이스이기 때문에 
		//Comparator 인터페이스의 구현객체를 람다식으로 대체한것
		System.out.println(list);
				
	}

}
