package oop;
class Point { //변수 x와 y가 담긴 Point 클래스
	int x;
	int y;
	
	Point(int x, int y){ //Point 클래스의 생성자
		this.x = x;
		this.y = y;
	}
	
	public String toString() { //Point클래스는 Object클래스를 자동으로 상속받으므로 toString()의 오버라이딩이 가능하다
		//Object 클래스의 toString() 은 원래 public 이 붙어있기 때문에 접근제어자를 일치시켜준것
		return "x = " + x + "& y = " + y;
	}
}

public class Overriding {

	public static void main(String[] args) {
		Point p = new Point(3,7); 
		System.out.println(p); //System.out.println() 메서드가 인자로 전달된 객체의 toString() 메서드를 자동으로 호출

	}

}
