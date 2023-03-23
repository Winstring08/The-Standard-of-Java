package CollectionsFramework;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetEx {

	public static void main(String[] args) {
		Object[] arr = {"1", "2", "2", 2, "3", "4"};
		Set set = new HashSet();
		
		for(Object i : arr) { // for(int i=0; i<arr.size(); i++){ arr[i] + "=" + set.add(arr[i]) }
			System.out.println(i + "=" + set.add(i));
			  //1=true
			  //2=true
			  //2=true //중복이므로 false
			  //2=false //문자열이 아닌 숫자이므로 true
			  //3=true
			  //4=true
		}
		Iterator it = set.iterator(); //Hashset도 iterator() 사용 가능
		while(it.hasNext()) { //다음 요소가 존재한다면
			System.out.print(it.next()+" "); //다음 요소를 반환
		}
		
		Set set2 = new HashSet();
		for(int i=0; set2.size()<6; i++) { //set의 요소 개수가 5개가 될때까지 
			//i<6이라면 num에 중복값이 저장되었을때 HashSet에 저장되지 않으므로 
			//요소의 개수가 5개가 되지 않음
			int num = (int)(Math.random()*10)+1; //1~10까지의 랜덤한 수를 num에 저장
			set2.add(num); //그 값을 set2에 저장
		}
		System.out.println(set2);
		
		List list = new LinkedList(set2); //Collection객체의 요소 전부를 LinkedList에 저장하고 객체 생성
		Collections.sort(list); //List타입이므로 Collections클래스의 sort()메서드 실행
		System.out.println(list); //정렬된 객체 출력
		}
	}

