package CollectionsFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class Apple{
	int x;
	public Apple() {}
	public Apple(int x) {
		this.x = x;
	}
	@Override
	public String toString() {
		return "Apple [x=" + x + "]";
	}
}

public class IteratorEx {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		//참조변수 타입을 Collection으로 한 이유는 ArrayList 객체를 다른 타입으로 쉽게 바꿀수 있게 하기 위함
		//ArrayList타입일 경우 ArrayList에만 존재하는 메서드를 사용했을 수도 있기때문
		
		c.add(new Apple(1)); 
		c.add(new Apple(2));
		c.add(new Apple(3));
		c.add(new Apple(4));
		c.add(new Apple(5));
		//x에 1,2,3,4,5을 대입한 새로운 Apple객체를 c에 추가
		
		Iterator it = c.iterator(); //c에서 iterator()메서드를 호출하여 
		//Iterator 인터페이스를 구현한 새로운 객체 생성
		
		while(it.hasNext()) { //it에 다음 요소가 존재한다면
			System.out.println(it.next().toString()); //it의 다음요소를 반환, 그 값에 toString()메서드 사용
		}
	}
}
