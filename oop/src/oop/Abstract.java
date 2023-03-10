package oop;
abstract class AbParent{ //추상클래스
	abstract void printInt(int i); //추상메서드, 구현부( {} ) 가 존재하지 않는다
	abstract void printString(String s);
}
class AbChild extends AbParent{ //추상클래스를 상속
	void printInt(int i) {
		System.out.println(i); //구현부를 완성시킨다
	};
	void printString(String s){
		System.out.println(s);
	};
}
public class Abstract {

	public static void main(String[] args) {
		//AbParent ap = new AbParent(); //추상클래스는 객체 생성이 불가능
		AbChild ac = new AbChild(); //모든 추상메서드를 구현했으므로 객체생성이 가능
		AbParent ap = new AbChild(); //다형성도 가능 
		ac.printInt(5);
		ap.printString("a");

	}

}
