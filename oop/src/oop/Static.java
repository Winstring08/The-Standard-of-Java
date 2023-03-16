package oop;

class One {
	int x = 1;
	int y = 2;
	static int z = 3; //One클래스에 포함되지만 One객체에 포함되는 변수가 아님
	//z는 One 클래스가 프로그램 실행 중에 최초로 사용되는 시점에 생성됨
	
	One() {}
	
	One(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	public String toString() {
		return "One [x=" + x + ", y=" + y+ "]" + ", 스태틱 변수 z=" + z ;
	}

	}
public class Static {
	public static void main(String[] args) {
		One o1 = new One(); //인스턴스마다 존재하는 별도의 메모리 공간에 x,y생성
		//인스턴스에 z는 포함되지 않음
		//z는 One객체가 만들어지기 이전, One클래스가 메모리에 로드되었을때 먼저 생성됨
		One o2 = new One(10,20);
		System.out.println(o1); //[x=1, y=2], z=3
		System.out.println(o2); //[x=10, y=20], z=3
		
		One.z = 30; //One클래스 메모리 공간에 있는 z의 값을 30으로 변경
		System.out.println(o1);
		System.out.println(o2);
	}
}


