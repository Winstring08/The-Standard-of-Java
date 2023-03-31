package nextCh12;
enum Direction2 { 
EAST(1,">"), SOUTH(5,"v"), WEST(-1,"<"), NORTH(10,"^"); //원하는 값을 괄호에 대입
//각 enum 상수는 Direction2 클래스의 객체이며 각각 int x, String y를 인스턴스 변수로 가짐
//이 경우 인스턴스 변수와 생성자가 존재해야 함
	
private final int x; //각 enum상수의 인스턴스 변수
private final String y; //각 enum상수의 인스턴스 변수

Direction2 ( int x, String y) { //enum의 생성자는 항상 private이므로 외부에서 생성 불가능
this.x = x;
this.y = y;
} 

public int getX() { //enum의 iv는 private이므로 변수를 사용하기 위해서 getter를 생성해야 함
return x; //상수 객체의 x값 반환
}

public String getY() {
return y; //상수 객체의 y값 반환
}

}
public class EnumEx2 {

	public static void main(String[] args) {
		Direction2 d1 = Direction2.EAST;
		Direction2 d2 = Direction2.valueOf("WEST");
		
		System.out.printf("d1의 x값 : %d, d1의 y값 : %s%n",d1.getX(),d1.getY()); 
		System.out.printf("d2의 x값 : %d, d2의 y값 : %s%n",d2.getX(),d2.getY()); 
		
		Direction2[] arrD = Direction2.values(); //Direction2에 있는 모든 상수객체들을 배열로 반환
		for(Direction2 d : arrD) { //상수배열에서 순서대로 상수를 하나씩 꺼내 반복문 실행
			System.out.printf("%d번째값 : x=%d, y=%s%n",d.ordinal(),d.getX(),d.getY());
			//상수객체의 번째수, 상수객체의 x변수값, 상수객체의 y변수값
		}
	}

}
