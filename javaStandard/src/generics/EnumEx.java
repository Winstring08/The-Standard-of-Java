package generics;
enum Direction { EAST, SOUTH, WEST, NORTH }
public class EnumEx {
	
	public static void main(String[] args) {
		Direction dir1 = Direction.EAST; //열거형타입.상수이름으로 초기화
		Direction dir2 = Direction.valueOf("WEST"); //상수명이 WEST인 열거형 객체 반환 
		Direction dir3 = Enum.valueOf(Direction.class, "EAST"); 
		//enum타입이 Direction이고 상수명이 EAST인 열거형 객체 반환 
		
		System.out.println(dir1); //EAST
		System.out.println(dir2); //WEST
		System.out.println(dir3); //EAST
		
		System.out.println(dir1==dir2); //true
		System.out.println(dir1==dir3); //false
		System.out.println(dir1.equals(dir3)); 
		System.out.println(dir1.compareTo(dir2)); //-2
		//dir1<dir2 부등호를 사용할 수 없기 때문에 양수와 음수의 반환값으로 대소판별
		
		switch(dir1){
			case EAST : //Direction.EAST로 사용 불가능 (문법)
				System.out.println("EAST입니다");
				break;
			case SOUTH :
				System.out.println("SOUTH입니다");
				break;
			case WEST :
				System.out.println("WEST입니다");
				break;
			case NORTH :
				System.out.println("NORTH입니다");
				break;
		}
		Direction[] dArr = Direction.values(); //열거형 타입의 모든 객체를 배열형태로 저장
		for(Direction d : dArr) { //dArr의 요소중 하나를 순서대로 d라하고 반복문 실행
			System.out.printf("이름은%s,순서는%d%n",d.name(),d.ordinal());
			//d열거형 객체의 상수이름, 순서를 반환
		}

	}

}
