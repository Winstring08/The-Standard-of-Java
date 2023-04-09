package stream;

import java.util.Optional;

public class OptionalEx {

	public static void main(String[] args) {
		//int[] arr = null;
		int[] arr = new int[0];
		System.out.println("arr의 길이 : " + arr.length);
		
		//Optional<String> opt = null; //바람직하지 않은 초기화 방법
		//Optional<String> opt = Optional.empty();
		Optional<String> opt = Optional.of("abc");
		System.out.println("opt=" + opt);
		System.out.println(opt.get()); 
		
		String str = "";
		/*
		try {
			str = opt.get();
		} catch (Exception e) {
			str = ""; //예외가 발생하면 str을 빈문자열로 초기화함
		}
		*/
		str = opt.orElse("EMPTY"); //Optional에 저장된 값이 null이면 빈문자열("")을 반환함
		//str = opt.orElseGet(()->new String()); 
		str = opt.orElseGet(String::new);
		System.out.println("str은" + str);

	}

}
