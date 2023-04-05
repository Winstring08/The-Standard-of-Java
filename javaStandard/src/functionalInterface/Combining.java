package functionalInterface;

import java.util.function.*;

public class Combining {

	public static void main(String[] args) {
		Function<String,Integer> f = s -> Integer.parseInt(s,16); 
		//String을 매개변수로 받아 16진수로 변환하는 apply()메서드 구현
		Function<Integer,String> g = i -> Integer.toBinaryString(i);
		//Integer를 매개변수로 받아 2진수 문자로 변환하는 apply()메서드 구현
		Function<String,String> h = f.andThen(g);
		//String을 매개변수로 받아 String을 리턴하는 h인터페이스를
		//f.apply()이후 g.apply()를 실행하게하는 메서드로 구현
		Function<Integer,Integer> h2 = f.compose(g);
		//g.apply()이후 f.apply()를 실행하게하는 메서드로 구현
		System.out.println(h.apply("10")); //"10" -> 16 -> "10000"
		System.out.println(h2.apply(10)); //10 -> "1010" -> 4112
		
		Function<String,String> identity = i -> i;
		System.out.println(identity.apply("abc")); //"abc" -> "abc"	
		
		Predicate<Integer> p = i -> i<100;
		//Integer를 매개변수로 받아 매개변수가 100보다 작으면 true를 반환
		Predicate<Integer> q = i -> i<200;
		//Integer를 매개변수로 받아 매개변수가 200보다 작으면 true를 반환
		Predicate<Integer> r = i -> i%2==0;
		//Integer를 매개변수로 받아 매개변수가 짝수라면 true를 반환
		
		Predicate<Integer> notP = p.negate(); //i>=100
		//p의 test()메서드의 부정을 반환하여 notP의 test()메서드를 구현
		Predicate<Integer> all = notP.and(q.or(r)); //i>=100 && ( i<200 || i%2==0 )
		//q.or(r) : q의 test()메서드와 r의 test()메서드중 하나가 참이면 true를 반환하는식을 반환
		//notP의 test()메서드와 q.or(r)이 모두 참일때 true를 반환하는 식을 반환
		Predicate<Integer> all2 = notP.and(q).or(r); //i>=100 && i<200 || i%2==0 
		//notP의 test()메서드와 q의 test()메서드가 둘다 참이거나 
		//r의 test()메서드가 참이면 true를 반환하는 식을 반환
		System.out.println(all.test(150)); //true
		System.out.println(all2.test(150)); //true
		
		String x = "abc";
		String y = "abcd";
		Predicate<String> pe = Predicate.isEqual("abc");
		//"abc"와 값이 같다면 true를 반환하는 식으로 pe의 test()메서드를 구현
		System.out.println(pe.test(x)); //true
		System.out.println(pe.test(y)); //false
	}

}
