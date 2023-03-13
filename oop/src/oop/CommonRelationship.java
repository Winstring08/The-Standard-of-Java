package oop;
class Universe{
	String s;
} 

interface Common {} //B클래스와 Yellow클래스에 공통관계를 부여하기 위한 interface

class Alphabet extends Universe{} //Alphabet클래스와 Color 클래스는 U를 상속받음
class A extends Alphabet{
	String s = "a";
} //A와 B 클래스는 Alphabet을 상속받음
class B extends Alphabet implements Common{
	String s = "b";
} //B클래스는 Common을 구현하여 Yellow와 공통관계를 부여 

class Color extends Universe{} //Alphabet클래스와 Color 클래스는 U를 상속받음
class Red extends Color {
	String s = "red";
} //Red와 Yellow 클래스는 Color를 상속받음
class Yellow extends Color implements Common{
	String s = "yellow";
} //Yellow클래스는 Common을 구현하여 B와 공통관계를 부여



public class CommonRelationship {
void PrintBandYellow(Common c) {
	if(c instanceof Universe) {
		Universe u = (Universe)c;
		System.out.println(u.s);
	}
}
	public static void main(String[] args) {
		CommonRelationship cr = new CommonRelationship();
		//cr.PrintBandYellow(new A());
		cr.PrintBandYellow(new B());
		//cr.PrintBandYellow(new Red());
		cr.PrintBandYellow(new Yellow());

	}

}
