package practice;

import java.util.Scanner;

public class ArrayQuiz {

	public static void main(String[] args) {
		String[][] Arr = {
				{"Apple","사과"}
				,{"Banana","바나나"}
				,{"Cat","고양이"}
				};
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<Arr.length;i++) { //행 수만큼 반복
				System.out.printf("Q%d %s의 뜻은?",i+1,Arr[i][0]);
				String answer = sc.next(); //입력받은 값을 answer에 넣는다
				if(answer.equals(Arr[i][1]) ) { //그 값이 정답과 같다면
					System.out.println("정답입니다");
				} else {
					System.out.printf("틀렸습니다 답은 %s입니다%n",Arr[i][1]);
				}
		}

	}

}
