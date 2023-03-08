package practice;

public class ArrayPlanar {

	public static void main(String[] args) {
		// 5명의 3과목 점수를 2차원 배열에 저장하고 총점과 평균을 함께 출력해보기
		
		int[][] Arr = { {100,90,100},{80,70,80},{60,60,50},{20,30,40},{70,80,60} } ;
		
		System.out.println("번호    국어    영어    수학    총점    평균");
		System.out.println("===================================");
		int totalKor = 0;
		int totalEng = 0;
		int totalMath = 0;
		
		float avg = 0f;
		for(int i=0;i<Arr.length;i++) {
			//모든 학생의 과목별 총점을 저장한다
			totalKor += Arr[i][0]; 
			totalEng += Arr[i][1];
			totalMath += Arr[i][2];
			
			//j열 반복문 전에 sum의 값을 초기화한다
			int sum = 0;
			System.out.print(i+"          ");
			//i행의 모든 j열값을 sum에 순서대로 더하면서 출력한다
			for(int j=0;j<Arr[i].length;j++) {
				sum +=Arr[i][j];
				System.out.print(Arr[i][j]+"      ");		
			}
			//j열 반복이 끝난뒤 합계인 sum과 평균인 avg를 i행 반복에 붙여서 출력해준다
			System.out.print(sum+"      ");
			avg = sum/(float)Arr[i].length; //산술법칙으로 int로 변환되므로 float로 형변환한다
			System.out.println(Math.round(avg)); //소수점 첫째자리에서 반올림
		}
		//i행 반복이 끝난뒤 모든 학생의 과목 총점을 출력한다
		System.out.println("===================================");
		System.out.printf("총점 :  %d    %d    %d",totalKor,totalEng,totalMath);

	}

}
