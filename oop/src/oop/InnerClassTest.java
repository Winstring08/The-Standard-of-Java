package oop;

class OuterClass { //외부 클래스
	
	class InstanceInner{ //인스턴스 내부 클래스
		int iiv;
		StaticInner s = new StaticInner(); //스태틱 객체 생성 가능
	} 
	
	static class StaticInner{ //스태틱 내부 클래스	
		int civ;
		static int ccv = 100; //내부 스태틱 변수 생성 가능
		//InstanceInner i = new InstanceInner(); //인스턴스 객체 생성 불가능
	} 
	
	void Outermethod(){ //외부 인스턴스 메서드
		int lv = 1; //로컬 변수
		//lv = 2; //로컬 변수의 값이 변하면 로컬 내부 클래스에서 사용 불가능
		final int flv = 1;
	class LocalInner{//로컬 내부 클래스	
		int llv = lv; //값이 한번도 변하지 않은 로컬 변수는 상수로 취급되어 사용가능
		int fllv = flv; //상수 사용 가능
	} 
	}

}

public class InnerClassTest{
public static void main(String[] args) {
	System.out.println(OuterClass.StaticInner.ccv); //스태틱 클래스의 cv는 클래스 객체 생성 없이 사용 가능
	//System.out.println(OuterClass.StaticInner.civ); //객체가 생성되지 않았으므로 iv사용 불가능
	
	OuterClass.StaticInner si = new OuterClass.StaticInner(); //내부 스태틱 클래스 객체 생성 방법
	System.out.println(si.civ); //내부 스태틱 클래스 객체생성시 내부 스태틱 클래스의 iv사용 가능
	
	//InstanceInner ii= new InstanceInner(); //외부 클래스 객체를 먼저 생성해야 내부 인스턴스 클래스 사용 가능
	OuterClass oc = new OuterClass(); //외부 클래스 객체 생성
	OuterClass.InstanceInner ii = oc.new InstanceInner(); //내부 인스턴스 클래스 객체 생성 방법
	
	}
}
