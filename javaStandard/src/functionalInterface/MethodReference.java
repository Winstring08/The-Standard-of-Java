package functionalInterface;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
class Apple{
	int x;
	public Apple() {
		// TODO Auto-generated constructor stub
	}
	public Apple(int x) {
		super();
		this.x = x;
	}
	@Override
	public int hashCode() {
		return Objects.hash(x);
	}
	@Override
	public boolean equals(Object obj) {
		Apple other = (Apple) obj;
		return x == other.x;
	}
	
	
}
public class MethodReference {

	public static void main(String[] args) {
		Function<String,Integer> f = s-> Integer.parseInt(s);
		//String을 받고 Integer를 반환하는 f는 
		//s를 받고 Integer.parseInt(s)를 반환하는 Function
		Function<String,Integer> fR = Integer::parseInt;
		//클래스이름::메서드이름
		//String을 받고 Integer를 반환하는 fR은
		//Integer클래스의 parseInt메서드의 반환값을 반환하는 Function
		System.out.println(f.apply("100"));
		System.out.println(fR.apply("100"));
		
		Supplier<Apple> s = () -> new Apple();
		//Apple을 반환하는 s는 아무것도 받지않고 new Apple()반환
		Supplier<Apple> sR = Apple::new;
		//Apple을 반환하는 s는 Apple클래스의 new연산자의 연산값을 반환하는 Supplier
		Function<Integer,Apple> nf = i -> new Apple(i);
		//Integer를 받고 Apple을 반환하는 s는 i를 받고 new Apple(i)를 반환하는 Function 
		Function<Integer,Apple> nfR = Apple::new;
		//클래스이름::new연산자
		//Integer를 받고 Apple을 반환하는 sR는 
		//Apple클래스의 new연산자의 연산값을 반환하는 Function 
		System.out.println( s.get().equals( sR.get() ) ); 
		System.out.println( nf.apply(100).equals( nfR.apply(100) ) ); 
		//equals()메서드를 오버라이딩 했기때문에 값이 같으면 true반환
		
		Function<Integer,int[]> arrf = x -> new int[x];
		//Integer를 받고 int[]을 반환하는 arrf는 
		//x를 받고 new int[x]를 반환하는 Function
		Function<Integer,int[]> arrfR = int[]::new;
		//Integer를 받고 int[]을 반환하는 arrfR은
		//int[]의 new연산자의 연산값을 반환하는 Function
		
		System.out.println(arrf.apply(5).length == arrfR.apply(5).length); 
	}

}
