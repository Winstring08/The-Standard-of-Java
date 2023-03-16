package oop;
class Data{
	int x;
}
public class Parameter {

	public static void main(String[] args) {

			System.out.println("012345".indexOf(50));

	
		Data d = new Data(); //호출스택 main생성, 변수 d공간 생성, d에 새로운 Data객체의 주소값을 넣는다
		d.x = 10; //주소값을 통해 Data객체와 연결되어 Data객체의 변수값을 바꿀수 있다
		Data d2 = copy(d); //main스택에 변수 d2공간을 생성하고 호출스택 copy를 올린다 (copy로 이동)
		//즉 copy(d)가 tmp로 변하게 되고 main스택에 변수 d2공간에 tmp의 주소값을 대입한다
		System.out.printf("d.x=%d%n",d.x); //최초의 new Data()가 가지고 있던 10의 값
		System.out.printf("d2.x=%d",d2.x); // tmp의 주소값을 받은 d2가 가지고 있던 10의 값
	}
	static Data copy(Data d) { //copy스택에 변수 d공간을 생성하고 main스택의 변수d공간에 저장된 객체의 주소값을 대입한다
		Data tmp = new Data(); //변수 tmp공간을 생성하고 새로운 Data객체의 주소값을 넣는다
		tmp.x = d.x; //copy스택의 d공간은 main스택의 객체의 주소값을 대입받은 상태
		//copy스택의 d또한 처음의 new Data();의 컨트롤권을 가지고 있다
		//처음 new Data()의 x값 10을 다음 new Data()인 tmp의 x값에 대입한다
		return tmp;//x가 대입된 tmp의 주소값을 호출된 곳에 리턴한다 이후 copy스택은 제거된다
		
	}
}
