package other;

import java.util.Objects;

class Xy{
	String x = "x";
	String y = "y";

public boolean equals(Object obj) { //equals 오버라이딩
	if(!(obj instanceof Xy)) { //Object타입으로 들어온 매개변수 obj를 Xy타입으로 형변환할수 없다면
		return false;
	}
	Xy xy = (Xy)obj; //Object타입으로 들어온 매개변수 obj를 Xy타입 객체 xy에 담음
	return this.x.equals(xy.x) && this.y.equals(xy.y); 
	//이 메서드가 있는 클래스인 Xy(this)의 
	//x변수값이(.x)
	//들어온 매개변수 xy녀석의 x변수값(xy.x)과 같으면서
	//이 클래스의 y변수값과 xy의 y변수값이 같다면 true, 다르다면 false반환
}

public int hashCode() { //hashCode오버라이딩
	return Objects.hash(x,y);
	//Objects클래스는 객체와 관련된 유용한 메서드를 제공하는 유틸 클래스
	//hash(x,y)는 가변인자를 매개변수로 가져서 호출시 지정하는 매개변수의 개수가 정해져있지 않음
	//원래 hashCode()메서드는 객체마다 다른 해시코드를 반환하지만
	//Objects.hash(변수)는 변수값마다 다른값을 반환
}

public String toString() { //hashCode오버라이딩
	return "Xy [ x = "+x+", y = "+y+" ]";
	//Objects클래스는 객체와 관련된 유용한 메서드를 제공하는 유틸 클래스
	//hash(x,y)는 가변인자를 매개변수로 가져서 호출시 지정하는 매개변수의 개수가 정해져있지 않음
}

}

public class HashCode {
	public static void main(String[] args) {
		Xy xy1 = new Xy();
		Xy xy2 = new Xy();
		
		System.out.println(xy1.equals(xy2)); //원래는 false지만 iv 값이 일치한다면 true가 나오게 오버라이딩
		
		System.out.println(xy1.hashCode()); //원래는 1586600255지만 iv값에 따라 코드가 나오도록 오버라이딩 
		System.out.println(xy2.hashCode()); //원래는 474675244지만 iv값에 따라 코드가 나오도록 오버라이딩
		
		System.out.println(xy1.toString()); //원래는 other.Xy@12c2지만 지정한 문장이 나오도록 오버라이딩
	}

}
