package oop;
public class SuperEx{ //extends Object를 컴파일러가 자동으로 삽입
	int x;
	int y;
	SuperEx (){
		this(0,0); //자신의 객체의 생성자인 SuperEx(int x, int y){}를 호출
	}
	SuperEx(int x, int y){
		                    //첫줄에 생성자를 호출하지 않았으므로 컴파일러가 자동으로 첫 줄에 super(); 삽입
		                    //이 경우 super(); 는 Object의 기본 생성자인 Object(); 를 호출
		this.x = x;
		this.y = y;
	}
}
class SuperTest extends SuperEx{
	int z;
	SuperTest(int x, int y, int z){
	                      //첫 줄에 생성자를 호출하지 않았으므로 컴파일러가 super();가 자동으로 삽입 
		                  //이 경우 SuperEx의 기본 생성자인 SuperEx(){}를 호출
		                  //하지만 기본 생성자인 SuperEx(){}가 존재하지 않는다면 컴파일러 에러가 발생
	//super(x,y)  // 그 경우 이미 존재하는 SuperEx(int x, int y){}를 호출해서 첫 줄에 생성자를 호출할 수 있음 
		this.z = z;
	}
	public void main(String[] args) {
		SuperEx s = new SuperTest(1,2,3);
		
	}
}



