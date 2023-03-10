package oop;

class Parent {
	int x;
	int y;
	int z;
}
public class Child extends Parent {
	 int n;
	 int m;
	 public static void main(String[] args) {
		 Parent p = new Child(); //부모 타입으로 자신을 구속
		 Child c = (Child)p; //구속을 해제

		 Parent p2 = new Parent(); //그냥 부모 객체
//		 Child c2 = (Child)p2; //없는 힘을 줄 수 없으므로 불가능

		 Child c3 = new Child(); //그냥 자식 객체
		 Parent p3 = c3; //부모타입으로 자신을 구속
		 Child c3_1 = (Child) c3; //구속 해제
		 
		 if(p instanceof Child){ //instanceof 연산자로 형변환 가능 여부를 확인
			 c = (Child)p; //true를 반환했을때만 형변환 하도록 만듦
			 }
	 }
	 
	 
}