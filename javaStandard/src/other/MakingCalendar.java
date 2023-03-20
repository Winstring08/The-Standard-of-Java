package other;

import java.util.Calendar;

public class MakingCalendar {

	public static void main(String[] args) {//년월을 입력하면 달력을 생성하는 메서드
		int year = 2023;
		int month = 3;
		
		Calendar start = Calendar.getInstance(); //시작일을 담을 Calendar객체 생성
		Calendar end = Calendar.getInstance(); //말일을 담을 Calendar객체 생성
		
		start.set(year, month-1, 1); //지정 년월의 1일로 set
		end.set(year, month, 1); //지정 년월 다음달의 1일 set
		end.add(Calendar.DATE, -1); //1일을 빼서 지정 년월의 마지막 일로 변경함
		//Calendar.DATE와 같은 필드 값은 단독으로 사용하는 것과 
		//get, set, add등의 Calendar메서드에서 사용하는 것과 차이가 있음
		System.out.printf("                  %d년%d월%n",year,month); //달력 제목
		System.out.println("  SU  MO  TU  WE  TH  FR  SA"); //달력 요일
		for(int i=1; i<start.get(Calendar.DAY_OF_WEEK);i++) { 
			System.out.print("       ");//1일의 요일의 전 요일수 만큼 공백 수를 추가
		}
		for(int i=1,n=start.get(Calendar.DAY_OF_WEEK); i<=end.get(Calendar.DATE); i++,n++) {
			//i는 일, n은 요일; 일수는 말일보다 작거나 같게, 1씩 증가
			System.out.print((i<10) ? "     " + i : "    " + i ); //일수가 10보다 작다면 공백을 더 크게하고 일수를 출력
			if(n%7==0) { //그런 다음, 요일이 7로 나누어 떨어진다면 
				System.out.println(); //줄을 바꿈
			}
		}
}
}
