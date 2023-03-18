package other;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarClass {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Calendar 클래스를 구현한 클래스의 객체를 생성 
		//서양력 기준 new GregorianCalendar();
		//기본적으로 현재 날짜와 시간으로 갱신되며 cal인스턴스의 날짜와 시간이 설정됨
		
		System.out.println( cal.get(Calendar.YEAR) ); //이 해의 년도
		//cal.YEAR로도 사용할수 있지만 스태틱변수를 사용할때는 클래스명을 그대로 쓰는것이 좋음
		//GregorianCalendar.YEAR로도 사용할수 있지만 모든 력에서 공통으로 사용 가능한 부모클래스를 사용함
		System.out.println( cal.get(Calendar.MONTH) ); //이 해의 몇번째 달인지 반환 //0부터 셈에 주의
		System.out.println( cal.get(Calendar.DATE) ); //이 달의 며칠
		System.out.println( cal.get(Calendar.WEEK_OF_YEAR) ); //이 해의 몇째 주
		System.out.println( cal.get(Calendar.WEEK_OF_MONTH) ); //이 달의 몇째 주
		System.out.println( cal.get(Calendar.DAY_OF_MONTH) ); //이 달의 며칠 //Calendar.DATE와 같음
		System.out.println( cal.get(Calendar.DAY_OF_YEAR) ); //이 해의 며칠
		System.out.println( cal.get(Calendar.DAY_OF_WEEK) ); //요일을 일요일~토요일로 1~7로 반환
		System.out.println( cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) ); //이 달의 몇째 요일인지 반환
		System.out.println( cal.get(Calendar.AM_PM) ); //오전이면 0, 오후면 1을 반환
		System.out.println( cal.get(Calendar.HOUR) ); //0~11로 시간을 반환
		System.out.println( cal.get(Calendar.HOUR_OF_DAY) ); //0~23으로 시간을 반환
		System.out.println( cal.get(Calendar.MINUTE) ); //0~59로 분을 반환
		System.out.println( cal.get(Calendar.SECOND) ); //0~59로 초를 반환
		System.out.println( cal.get( Calendar.MILLISECOND ) ); //0~999로 1/1000초를 반환
		System.out.println( cal.getActualMaximum(Calendar.DATE) ); // 이 달의 마지막 일을 반환

		

	}

}
