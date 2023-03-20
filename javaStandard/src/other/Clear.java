package other;

import java.util.Calendar;

public class Clear {
	public static int getDifference(String yyyymmdd1, String yyyymmdd2) { 
		//두 날짜 차이가 며칠 차이인지 알려주는 계산기
		int difference = 0; 
		try { //계산중 예외가 발생하면 프로그램을 종료하지 않고 실행을 이어서 하도록 함
			int year1 = Integer.valueOf(yyyymmdd1.substring(0,4));
			int month1 = Integer.valueOf(yyyymmdd1.substring(4,6)) - 1; //set에 넣어야하는 값은 번째수이므로
			int date1 = Integer.valueOf(yyyymmdd1.substring(6,8));
			int year2 = Integer.valueOf(yyyymmdd2.substring(0,4));
			int month2 = Integer.valueOf(yyyymmdd2.substring(4,6)) - 1;
			int date2 = Integer.valueOf(yyyymmdd2.substring(6,8));
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.clear();
			c2.clear();
			//두 인스턴스 생성시점이 완전히 동일한 시점이 아니기때문에 ms단위의 오차가 발생할 수 있으므로
			//00시 00분 00초로 초기화 해주는것이 좋음
			c1.set(year1,month1,date1);
			//한번에 설정하는 방식, 나머지 값은 현재 시간을 기준으로 설정된 값을 유지
			c2.set(Calendar.YEAR, year2);
			c2.set(Calendar.MONTH, month2);
			c2.set(Calendar.DATE, date2);
			//하나하나 골라서 설정하는 방식
			difference = (int) (Math.abs(c1.getTimeInMillis() - c2.getTimeInMillis())/(1000*60*60*24));
		} catch (Exception e) {
			difference = -1; //예외가 발생하면 try문을 중단하고 difference에 -1을 대입한뒤 이어서 프로그램을 실행
		}
		return difference;
		
	}
	public static void main(String[] args) {
		System.out.println(getDifference("20230101", "20230103")); 
		System.out.println(getDifference("20230101", "20230101"));
		System.out.println(getDifference("20230101", "230101")); //catch문을 실행후 try-catch를 벗어남
	}

}
