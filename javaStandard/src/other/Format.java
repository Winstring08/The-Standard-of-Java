package other;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {

	public static void main(String[] args) {
		//DecimalFormat
		
		//숫자 -> 형식문자열
		DecimalFormat df = new DecimalFormat("0.0"); //출력형식 0.0으로 DecimalFormat객체 생성
		String s = df.format(1234567.89d); //숫자를 형식문자열로 형변환 //“1234567.9“ 
		//소수 첫째자리에서 끊었으므로 둘째자리에서 반올림 된 값
		System.out.println(s);

		//형식문자열 -> 숫자
		DecimalFormat df2 = new DecimalFormat("#,###.##"); //출력형식 #,###.##으로 DecimalFormat객체 생성
		
		try {
			Number n = df2.parse("1,234,567.89"); //이 코드는 try-catch문에서 실행되어야 함
			//형식문자열을 Number타입으로 형변환 1234567.89
			double d = n.doubleValue(); //Number를 double형식으로 형변환
			System.out.println(d);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		//SimpleDateFormat
		
		//Date -> 문자열
		Date d1 = new Date(); 
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 d일 E요일");
		String ss = sf.format(d1);
		System.out.println(ss);
		
		//문자열 -> Date
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date d2 = new Date();
		try { //이 코드는 try-catch문에서 실행되어야 함
			d2= sf2.parse("2023년 3월 20일");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(d2);
	}
}
