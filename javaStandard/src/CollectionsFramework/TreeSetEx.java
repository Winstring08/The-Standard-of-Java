package CollectionsFramework;

import java.util.Set;
import java.util.TreeSet;

class TreeSetNode implements Comparable{ //값을 저장할 객체는 compareTo()메서드가 존재해야 하므로 
	//Comparable인터페이스를 구현해야함
	int x;
	public TreeSetNode() {
		// TODO Auto-generated constructor stub
	}
	public TreeSetNode(int x) {
		super();
		this.x = x;
	}
	
	@Override
	public int compareTo(Object o) { //compare()메서드가 값의 비교를 위해 이 메서드를 호출
		//이 메서드의 내용을 기준으로 값을 비교하여 정렬
		if(o instanceof TreeSetNode) {
			TreeSetNode tsn = (TreeSetNode)o;
			if(x>tsn.x) {
				return -1; //역순으로 정렬하는 규칙을 만들기 위해 반환값을 통상의 반대로 설정
			} else if(x==tsn.x) {
				return 0;
			} else {
				return 1;
			}
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		return "TreeSetNode [x=" + x + "]";
	}
}

public class TreeSetEx {
	public static void main(String[] args) {
		TreeSet set = new TreeSet(); //Comparator를 지정하지 않았으므로 기본 TreeSet Comparator를 사용

		set.add(new TreeSetNode(1)); 
		set.add(new TreeSetNode(2));
		set.add(new TreeSetNode(3));
		set.add(new TreeSetNode(4));
		set.add(new TreeSetNode(5));
		//값을 추가할때마다 TreeSet의 compare()메서드가 실행되어 
		//저장하려는 객체가 가진 compareTo()메서드의 반환값에 따라 set이 자동 정렬됨
		
		System.out.println(set);
		//[TreeSetNode [x=5], TreeSetNode [x=4], TreeSetNode [x=3], TreeSetNode [x=2], TreeSetNode [x=1]]
		//TreeSetNode에서 구현한 compareTo()메서드에 따라 정렬
		
		System.out.println(set.headSet(new TreeSetNode(3)));
		//[TreeSetNode [x=5], TreeSetNode [x=4]]
		//정렬기준이 역순이므로 3보다 앞에 존재하는 5,4가 반환됨
		System.out.println(set.tailSet(new TreeSetNode(3)));
		//[TreeSetNode [x=3], TreeSetNode [x=2], TreeSetNode [x=1]]
		//정렬기준이 역순이므로 3보다 같거나 뒤에 존재하는 3,2,1이 반환됨
		System.out.println(set.subSet(new TreeSetNode(5),new TreeSetNode(2)));
		//[TreeSetNode [x=5], TreeSetNode [x=4], TreeSetNode [x=3]]
		//정렬기준이 역순이므로 시작과 끝이 반대로 되야함

	}
}

