package generics;
enum Direction2 { 
EAST(1), SOUTH(5), WEST(-1), NORTH(10); //원하는 값을 괄호에 대입
//각 enum 상수는 Direction2 클래스의 객체이며, 각각 int x를 인스턴스 변수로 가짐
	
private final int x; //이 경우 인스턴스 변수와 생성자가 존재해야 함

Direction2 ( int x ) { //enum의 생성자는 항상 private이므로 외부에서 생성 불가능
this.x = x;
} 

public int getValue() {
return x; //상수 객체의 x값 반환
}

}
public class EnumEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
