package functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceEx {
	
	public static<T> void makeRandomList(Supplier<T> s, List<T> list) { 
		//static메서는 제네릭스를 사용할수 없지만 static에 <T>를 사용함으로써
		//모든 T에 그 타입이 대입됨
		//list에 랜덤한 10개의 숫자를 저장하는 메서드
		for(int i=0; i<10; i++) {
			list.add(s.get()); //1<=범위<100의 난수를 list에 10번 추가
		}
	}
	
	public static<T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		//list의 짝수만 출력하는 메서드
		for(T i:list) { //list의 모든 T타입 요소 i에 대하여 반복문 실행
			if(p.test(i)) { //p의 test()메서드에 i를 대입하여 true/false 판별
				c.accept(i); //짝수(true)인경우에만 accept(i)로 i를 출력
			}
		}
		System.out.println(); //줄바꿈
	}
	
	public static<T> List<T> doSomething(Function<T,T> f, List<T> list){
		//list를 받아 모든 요소의 1의 자리를 버린 값을 등록한 List객체를 반환하는 메서드
		List<T> newlist = new ArrayList<>(); //새로 만들어진 list를 저장할 객체 생성
		for(T i:list) { //list의 모든 T타입 요소 i에 대하여 반복문 실행
			newlist.add(f.apply(i)); //f의 apply(i)메서드로 i의 1의자리를 버리고
			//그 값을 새로 만든 list객체에 등록
		}
		return newlist; //그렇게 모든 요소가 등록된 newlist객체를 반환
		
	}

	public static void main(String[] args) {
		Supplier<Integer> s = () -> (int)(Math.random()*100)+1; 
		//Suplier 인터페이스의 get()메서드를 구현
		Consumer<Integer> c = i -> System.out.print(i+", ");
		//Consumer 인터페이스의 accept()메서드를 구현
		Predicate<Integer> p = i -> i%2==0;
		//Predicate 인터페이스의 test()메서드를 구현
		Function<Integer, Integer> f = i -> i/10*10; 
		//Funcion 인터페이스의 apply()메서드를 구현
		//i/10을 하면 산술법칙에 의해 10의자리만 남게되고 
		//그 값에 10을 곱해 결과적으로 1의자리가 버려지게 됨
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s,list); //컴파일러가 추측가능한 경우 static의 T를 명시할 필요 없음
        //FunctionalInterface.<Integer>makeRandomList(s,list);
		System.out.println(list);
		
		printEvenNum(p,c,list);
		
		list = doSomething(f,list); //새로 반환된 newlist를 기존의 list에 덮어씀
		System.out.println(list);
		
		
	}

}
