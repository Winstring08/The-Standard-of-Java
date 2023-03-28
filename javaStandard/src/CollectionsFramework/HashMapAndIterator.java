package CollectionsFramework;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapAndIterator {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("갑", 90);
		map.put("을", 80);
		map.put("병", 70);
		map.put("정", 60);
		
		Set set = map.entrySet(); //map의 모든 entry를 set에 저장
		Iterator it = set.iterator(); //그렇게 만든 set으로 iterator 객체 생성
		
		while(it.hasNext()) { //it의 다음 it.next() 값이 존재한다면
			Map.Entry e = (Map.Entry)it.next(); //it의 다음 값을 Entry타입의 e에 저장
			//Entry타입이 가진 메서드 getKey(), getValue()를 사용하기 위함
			System.out.printf("이름 : %s, 점수 : %d%n",e.getKey(),e.getValue());
		}
		
		Set keys = map.keySet(); //map의 모든 key를 set타입의 keys에 저장
		System.out.println("참가자 명단 : " + keys);
		
		Collection values = map.values(); //map의 모든 value를 Collection타입의 values에 저장
		it = values.iterator();
		int total = 0;
		while(it.hasNext()) {
			total += (int)it.next();
		}
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size()); //float로 형변환하지 않으면 산술변환이 일어남
		System.out.println("최고점수 : " + Collections.max(values)); 
		System.out.println("최저점수 : " + Collections.min(values));
		//max와 min의 매개변수는 comparable을 구현한 객체만 올 수 있음
		//max와 min이 max와 min을 비교하는 compare()메서드를 가짐

		

		}
		
		
	}


