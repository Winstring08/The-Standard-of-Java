package CollectionsFramework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UIDOfSets {

	public static void main(String[] args) {
		Set set1 = new HashSet();
		Set set2 = new HashSet();
		Set setIntersection = new HashSet(); //교집합
		Set setDifference = new HashSet(); //차집합
		Set setUnion = new HashSet(); //합집합
		
		set1.add(1);set1.add(2);set1.add(3);set1.add(4);set1.add(5); //[1, 2, 3, 4, 5]
		set2.add(4);set2.add(5);set2.add(6);set2.add(7);set2.add(8); //[4, 5, 6, 7, 8]
		
		Iterator it = set1.iterator(); //set1의 요소를 담은 iterator객체 생성
		while(it.hasNext()) { //it에 다음요소가 있다면
			Object tmp = it.next(); //it의 다음 요소를 tmp에 저장
			//it.next()를 변수에 저장하지 않고 그대로 사용할 경우
			//첫번째 it.next()는 1, 두번째 it.next()는 2를 반환하게되므로 반드시 값을 저장후 사용해야 함
			if(set2.contains(tmp)) { //set2가 tmp를 포함하고있다면
				setIntersection.add(tmp); //겹친다는 의미이므로 교집합에 추가
			}
		}
		System.out.println(setIntersection);
		
		it = set1.iterator(); //이것을 다시 선언하지 않으면 hasNext()와 next()의 진행상황이 초기화되지 않음
		//iterator()는 일회성임에 주의
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!set2.contains(tmp)) { //set2가 tmp를 포함하지 않는다면
				setDifference.add(tmp); //set2와 겹치지 않는 set1의 부분이므로 차집합에 추가
			}
		}
		System.out.println(setDifference);
		
		it = set1.iterator();
		while(it.hasNext()) {
			setUnion.add(it.next()); //it.next()가 한번만 사용됐으므로 변수에 저장하지 않아도 됨
			//set1의 모든 요소를 합집합에 저장
		}
		it = set2.iterator();
		while(it.hasNext()) {
			setUnion.add(it.next());
			//set2의 모든 요소를 합집합에 저장
			//set은 중복된값이 저장되지 않으므로 둘의 합집합이 생성됨
			//단 객체의 경우 iv값의 같고 다름으로 두 객체의 같음을 판별해야 하므로
			//equals()와 HashCode()를 오버라이딩 해야 올바른 값을 얻을 수 있음
		}
		System.out.println(setUnion);
		
		
	}

}
