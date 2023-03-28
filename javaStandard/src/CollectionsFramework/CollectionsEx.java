package CollectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsEx {

	public static void main(String[] args) {
		List list = new ArrayList();
		
		Collections.addAll(list, 1,2,3,4,5); //요소를 가변인자로 모두등록
		System.out.println(list);//[1, 2, 3, 4, 5]
		
		Collections.rotate(list,2); //요소들을 뒤로 n번 이동 (맨 뒤는 맨 처음으로 이동)
		System.out.println(list);//[4, 5, 1, 2, 3]
		
		Collections.swap(list, 0, 3); //n번째요소와 m번째요소를 교환
		System.out.println(list);//[2, 5, 1, 4, 3]
		
		Collections.shuffle(list); //저장된 요소들의 위치를 무작위로 변경
		System.out.println(list);
		
		Collections.sort(list); //정렬
		System.out.println(list);//[1, 2, 3, 4, 5]
		
		System.out.println(Collections.binarySearch(list, 2));//o가 저장된 위치(index)를 반환
		//binarySearch()메서드는 오름차순으로 정렬된 상태에서만 사용 가능
		//1
		
		Collections.sort(list,Collections.reverseOrder()); //역순으로 정렬
		//reverse(list); 와 동일
		System.out.println(list);//[5, 4, 3, 2, 1]
		
		System.out.println(Collections.binarySearch(list, 2));
		//list가 정렬되어있지 않으므로 binarySearch()메서드의 값이 올바르지 않음
		//-1
		
		System.out.println(Collections.max(list)); //5
		System.out.println(Collections.min(list)); //1
		System.out.println(Collections.min(list,Collections.reverseOrder())); //5
		
		Collections.fill(list,9); //list의 모든 요소를 o로채움
		
		System.out.println(list);//[9, 9, 9, 9, 9]
		
		List list2 = Collections.nCopies(list.size(), 2 ); //n의 크기의 객체를 생성한뒤 o로 가득 채움

		System.out.println(list2);	//[2, 2, 2, 2, 2]
		
		System.out.println(Collections.disjoint(list, list2)); //o1과 o2의 공통요소가 없으면 true를 반환
		//true
		
		Collections.copy(list, list2); //o1의 요소를 o2에 복사
		System.out.println(list); //[2, 2, 2, 2, 2]
		System.out.println(list2); //[2, 2, 2, 2, 2]
		
		Collections.replaceAll(list,2,1); //list의 모든 요소 o1을 o2로 교체
		System.out.println(list); //[1, 1, 1, 1, 1]
		
		

	}

}
