package other;

import java.util.Calendar;

public class CalendarSet {

	public static String mytoString(Calendar cal) {
		return cal.get(Calendar.YEAR)+"년 " +(cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DATE)+"일 ";
		//Calendar값을 보여주는 메서드를 만들어 보기 쉽게 만듦
	}
	
	public static void main(String[] args) {
		final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};
		//Calendar.DAY_OF_WEEK 의 반환값으로 나오는 1~7의 숫자를 각각의 요일에 배정하기 위한 배열을 만듦
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		//셋다 기본적으로 현재 시간으로 설정됨

		c1.set(2019,3,29,0,0,0); //(년, 몇번째월, 일) 이므로 3월이 아닌 4월임에 주의
		c3.clear(); //1970년 1월 1일 00시 00분으로 초기화
		System.out.println(mytoString(c3));
		
		System.out.println(mytoString(c1) + DAY_OF_WEEK[c1.get(Calendar.DAY_OF_WEEK)]+"요일"); 
		//toString의 반환값 + 2019년 3월 29일의 요일
		//c1.DAY_OF_WEEK는 c1.get( Calendar.DAY_OF_WEEK ) 와 전혀 다름
		System.out.println(mytoString(c2) + DAY_OF_WEEK[c2.get(Calendar.DAY_OF_WEEK)]+"요일");
		//toString의 반환값 + 현재 요일
		System.out.println(mytoString(c3) + DAY_OF_WEEK[c3.get(Calendar.DAY_OF_WEEK)]+"요일");
		//toString의 반환값 + 1970년 1월1일의 요일
		
		int[] TIME_UNIT = {86400,3600,60,1}; 
		String[] TIME_UNIT_NAME = {"일 ","시 ","분 ","초 "};
		//일,시,분,초 단위로 변환하기 위한 나눌값의 배열들
		
		//두 날짜의 차이를 계산하는 법
		long difference = Math.abs((c1.getTimeInMillis() - c2.getTimeInMillis())/1000);
		//1/1000초 단위로 반환한 값의 차이를 1000으로 나눈 값의 절대값, 즉 두 시간의 차이를 초로 나타낸값
		System.out.println(difference+ "초 차이");
		String tmp = ""; //완성시킬 문장을 담아둘 그릇
		for(int i=0; i<TIME_UNIT.length; i++) { 
			tmp += (difference/TIME_UNIT[i]) + TIME_UNIT_NAME[i]; 
			//시간차이를 일,시,분으로 나눈 int값을 String으로 변환하여 tmp에 더한다
			difference %= TIME_UNIT[i]; //시간차이를를 일,시,분으로 나눈 int값의 나머지를 difference로 재정의한다
		}
		System.out.println(tmp); //완성된 문장을 출력
	}

}
