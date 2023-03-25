package CollectionsFramework;

import java.util.TreeSet;

public class HeadAndTailSet {

	public static void main(String[] args) {
		TreeSet set = new TreeSet(); //타입Set으로 new TreeSet()객체를 담을경우 
		//TreeSet고유의 메서드를 사용할 수 없음
		int[] score = {40,30,60,50,70,20,10,90,80};//무작위 순서로 10~90의 숫자가 있는 int[] 생성
		
		for(int i:score) { //score에 있는 요소 하나를 i라 하고 모든요소에 반복
			set.add(i); //i를 set에 추가
		}		
		System.out.println(set); //[10, 20, 30, 40, 50, 60, 70, 80, 90] 
		//2진 탐색 트리이기때문에 자동으로 정렬됨
		
		System.out.println(set.headSet(50)); //[10, 20, 30, 40]
		//요소보다 앞에있는(작은) 요소들을 반환
		System.out.println(set.tailSet(50)); //[50, 60, 70, 80, 90]
		//요소보다 같거나 뒤에있는(크거나 같은) 요소들을 반환
		System.out.println(set.subSet(30,70)); //[30, 40, 50, 60]
		//범위 사이에 있는 요소를 반환 (단, n <= x < m)

	}

}
