package oop;
class Universe{ //모든 클래스의 조상인 Universe
	int state = 0; //상태변화 확인을 위한 변수
} 

interface Common {} //B클래스와 Yellow클래스에 공통관계를 부여하기 위한 interface

class Alphabet extends Universe{} //Alphabet클래스와 Color 클래스는 U를 상속받음
class A extends Alphabet{} //A와 B 클래스는 Alphabet을 상속받음
class B extends Alphabet implements Common{} //또한 B클래스는 Common을 구현하여 Yellow와 공통관계를 부여 

class Color extends Universe{} //Alphabet클래스와 Color 클래스는 U를 상속받음
class Red extends Color {} //Red와 Yellow 클래스는 Color를 상속받음
class Yellow extends Color implements Common{} //또한  Yellow클래스는 Common을 구현하여 B와 공통관계를 부여


public class CommonRelationship {
void upstateBYellow(Common c) { //Common타입만 매개변수로 들어올수 있는 메서드 생성
	if(c instanceof Universe) { 
		Universe u = (Universe)c; //Common타입은 아무 내용도 없기 때문에 state 제어권한이 없음
		//state 제어권한이 있으면서, B와 Yellow를 공통으로 다룰수 있는 Universe로 캐스팅
		u.state = 1; //Universe타입 참조변수를 만들지 않고 ((Universe) c).state = 1; 로 사용 가능
	}
}
	public static void main(String[] args) {
		CommonRelationship cr = new CommonRelationship();
		A a = new A();
		B b = new B();
		Red r = new Red();
		Yellow y = new Yellow();
		//cr.PrintBandYellow(a); //A와 Red는 Common을 implements하지 않았으므로 이 메서드를 사용할 수 없음
		cr.upstateBYellow(b);
		//cr.PrintBandYellow(r); //A와 Red는 Common을 implements하지 않았으므로 이 메서드를 사용할 수 없음
		cr.upstateBYellow(y);
		System.out.println(a.state);
		System.out.println(b.state); //upstateBYellow(Common c)를 사용한 두 클래스는 state 값이 변경됨
		System.out.println(r.state);
		System.out.println(y.state); //upstateBYellow(Common c)를 사용한 두 클래스는 state 값이 변경됨

	}

}
