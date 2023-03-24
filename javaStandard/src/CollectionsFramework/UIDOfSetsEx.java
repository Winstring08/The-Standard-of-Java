package CollectionsFramework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class UIDOfSetsEx {
	int x;
	int y;
	public UIDOfSetsEx() {
		// TODO Auto-generated constructor stub
	}
	public UIDOfSetsEx(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y); //해시코드 오버라이드 메서드
	}

	@Override
	public boolean equals(Object obj) {
		UIDOfSetsEx other = (UIDOfSetsEx) obj;
		return x == other.x && y == other.y; //this.x와 obj의 x가 일치하고 this.y와 obj의 y가 일치하면 true를 반환
	}
	//객체의 경우 기본적으로 주소값의 동일여부에 따라 두 객체의 같음을 판별
	//보통 iv값의 같고 다름으로 두 객체의 같음을 판별해야 하므로
	//equals()와 HashCode()를 오버라이딩 해야 올바른 리턴을 얻을 수 있음

	@Override
	public String toString() {
		return "Exp [x=" + x + ", y=" + y + "]";
	}

	public static void main(String[] args) {
		Set set1 = new HashSet();
		Set set2 = new HashSet();
		Set setIntersection = new HashSet(); //교집합
		Set setDifference = new HashSet(); //차집합
		Set setUnion = new HashSet(); //합집합
		
		set1.add(new UIDOfSetsEx(1,2));set1.add(new UIDOfSetsEx(2,3));set1.add(new UIDOfSetsEx(3,4));set1.add(new UIDOfSetsEx(4,5));
		set2.add(new UIDOfSetsEx(3,4));set2.add(new UIDOfSetsEx(4,5));set2.add(new UIDOfSetsEx(5,6));set2.add(new UIDOfSetsEx(7,8));
		
		Iterator it = set1.iterator(); //set1의 요소를 담은 iterator객체 생성
		while(it.hasNext()) { //it에 다음요소가 있다면
			Object tmp = it.next(); //it의 다음 요소를 tmp에 저장
			//it.next()를 변수에 저장하지 않고 그대로 사용할 경우
			//첫번째 it.next()는 1, 두번째 it.next()는 2를 반환하게되므로 반드시 값을 저장후 사용해야 함
			if(set2.contains(tmp)) { //set2가 tmp를 포함하고있다면
				//equals()를 오버라이딩 하지 않았다면 객체의 iv값이 아닌
				//주소값이 일치하는 객체를 포함하는지 여부로 contains()를 실행함 
				setIntersection.add(tmp); //겹친다는 의미이므로 교집합에 추가
			}
		}
		System.out.println(setIntersection);
		//set1.retainAll(set2); 
		//set1에서 set2가 가지고있지 않은 모든 요소를 제거하는 메서드

		it = set1.iterator(); //이것을 다시 선언하지 않으면 hasNext()와 next()의 진행상황이 초기화되지 않음
		//iterator()는 일회성임에 주의
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!set2.contains(tmp)) { //set2가 tmp를 포함하지 않는다면
				setDifference.add(tmp); //set2와 겹치지 않는 set1의 부분이므로 차집합에 추가
			}
		}
		System.out.println(setDifference);
		//set1.removeAll(set2);
		//set1에서 set2의 모든 요소를 제거하는 메서드
		
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
			//equals()를 오버라이딩 하지 않았다면 객체의 iv값이 아닌
			//주소값이 일치하는 객체가 존재하는지 여부로 중복여부를 판단함
		}
		System.out.println(setUnion);
		//set1.addAll(set2);
		//set1에 set2가 가진 모든 요소를 등록하는 메서드
	}

}
