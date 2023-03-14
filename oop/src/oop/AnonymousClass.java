package oop;
interface Interface1{
	void method1 (); //인터페이스에 public abstract void method1이라는 메서드를 만듦
}

public class AnonymousClass{
	public static void main(String[] args) {
		new Interface1(){ //interface1 인터페이스를 구현한 새로운 이름없는 객체를 일회용으로 생성
			public void method1() { //인터페이스의 빈메서드 내용을 구현
				System.out.println("a");
				}
			} //여기까지가 하나의 객체로서의 의미를 가짐
		.method1(); //만들자마자 즉시 사용
	}
}
	


