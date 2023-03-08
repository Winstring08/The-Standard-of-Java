package oop;

import java.util.Scanner;
//키보드로 숫자를 입력받아 구구단을 출력하는 메서드와
//두 숫자를 입력받아 더 큰수를 출력하는 메서드
class Mathmatics {
	int max(int a, int b) { //큰수 반환 메서드
		int result = a>b ? a:b; //a>b이면 a가 값이되고 아니면 b가 값이됨
		return result;
		
	}
	 void multiplication(int dan) {
		 if(!(2<=dan&&dan<10)) {
			 return; //메서드 실행을 중단하고 메서드가 호출된곳으로 돌아감
		 }
		 for(int i=1;i<10;i++) {
			 System.out.printf("%d * %d = %d%n",dan,i,dan*i);
		 }
	 }
}
public class Method {

	public static void main(String[] args) {
		
		Mathmatics m = new Mathmatics();
		Scanner sc = new Scanner(System.in);
		System.out.println("출력할 구구단 단수를 입력하세요(2~9) 아닐시 자동 취소");
		m.multiplication(sc.nextInt());
		System.out.println("두 숫자를 입력하시면 더 큰수를 출력합니다");
		System.out.println(m.max(sc.nextInt(), sc.nextInt()));
	}
 
}
