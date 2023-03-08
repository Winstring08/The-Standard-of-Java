package practice;

public class RSP {

	public static void main(String[] args) {
		//가위,바위,보 중 하나를 출력
		
		//가위,바위,보 가 들어있는 String[]을 생성
		
		String[] Arr = {"가위","바위","보"};
		
		//0~2사이의 수를 출력하는 수를 tmp라고 하자
		int tmp = (int)(Math.random()*3);
		
		System.out.println(Arr[tmp]); //Arr의 0~2번째수를 랜덤으로 출력한다
	}

}
