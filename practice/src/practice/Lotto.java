package practice;

public class Lotto {

	public static void main(String[] args) {

		//1~45의 수를 랜덤으로 6개 출력하는 메서드

		//먼저 1~45의 숫자가 들어있는 길이가 45인 배열을 생성한다

		int[] Arr = new int[45];

		for(int i=0; i<45; i++){
		Arr[i] = i+1;
		}

		//2개의 변수값을 교환하기 위해서는 하나의 빈 변수가 필요하다

		int tmp =0;

		//6개의 숫자를 뽑을것이므로 섞는 횟수도 6회로 충분하다

		int j = 0;

		for(int i=0; i<6; i++){
		 j = (int)(Math.random()*45) ; // 0~44사이의 수를 랜덤 출력한 값을 j에 담는다
		//Arr[i]와 Arr[j]를 바꿔 '랜덤한 수 j'번째의 값을 i번째 값과 교환한다 
		tmp = Arr[i]; 
		Arr[i] = Arr[j];
		Arr[j] = tmp;
		System.out.printf("Arr[%d] = %d%n", i,Arr[i]);
		//백틱처럼 출력할 문장을 ""안에 쓰고 변수를 %d꼴로 표시, 쉼표뒤에 변수의 값을 입력
		}
	}
}
