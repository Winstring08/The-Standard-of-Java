package oop;

public class CvInitialization { //cv의 복잡한 초기화
	static int[] Arr = new int[10]; //배열 Arr생성
	
	static {
		for(int i=0; i<Arr.length;i++) {
			Arr[i] = i+1; //Arr을 static{}에서 초기화
		}
	}
	
	public static void main(String[] args) {
		for(int i=0;i<Arr.length;i++) {
			System.out.println(Arr[i]);
		}
	}
	
}
