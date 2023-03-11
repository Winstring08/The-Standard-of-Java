package oop;

public interface Interface { //추상 메서드의 집합, 모든 메서드의 구현부가 존재하지 않음
	//Object가 최고 조상이 아님 , interface는 interface만을 조상으로 가짐	
	
	//인스턴스 멤버(iv, im)와 생성자를 가질 수 없다 
	//모든 변수가 public static final 제어자를 자동으로 가짐 (상수)
	//별도로 쓰지 않더라도 컴파일러가 자동으로 이 속성들을 붙임
	int x = 1 ; //( public static final int x )
	int y = 5; //( public static final int y = 5 )
	
	//모든 메서드가 public abstract 제어자를 자동으로 가짐 
	void method1(); //( public abstract method1() )
	void method2(); //( public abstract method2() )
	//void method2() {}; //abstract 메서드이므로 구현부를 가지는것이 불가능
	
	//별도로 구현할 수 있는 것 – default메서드, static메서드
	default void method3() { //default 메서드를 구현부 없이 생성하는것은 불가능
		System.out.println("c");
	};
	static void method4() { //static 메서드를 구현부 없이 생성하는것은 불가능
		System.out.println("c");
	};

}

//인터페이스의 구현 : 추상 메서드의 구현부( {} )를 완성하는것
	class Child1 implements Interface { //다중 상속(implements)도 가능 //class Child implements Parent1, Parent2 {}
	public void method1(){
		System.out.println("a");
		}
	public void method2(){
		System.out.println("b");
		}
	}

	//일부만 구현할 경우 여전히 추상상태이므로 abstract를 에 붙여야 함
	 abstract class Child2 implements Interface { //추상메서드(미구현된 메서드)가 존재하므로 abstract 클래스
		public void method1(){
			System.out.println("a");
			}
	}
