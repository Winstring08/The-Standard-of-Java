package CollectionsFramework;

import java.util.Stack;

public class StackEx {

	public static void main(String[] args) { //괄호 검사기
		Stack st = new Stack();
		String expression = "((()))"; //괄호 개수를 검사할 문자열
		
		try { //pop()메서드가 실패시 예외가 발생하므로 try-catch문에 넣고 실행
			final int exlength = expression.length();
			for( int i=0; i<exlength; i++) { //이곳에 직접 i<expression.length(); 입력시 반복문 시행시마다 
				//expression.length();를 실행하게 되므로 비효율적임
				char ch = expression.charAt(i); //expression의 한글자 한글자를 순서대로 ch에 담음
				if( ch=='(') 
					st.push("("); //'('가 있다면 "("를 st에 넣음, "("에 큰 의미는 없고 그냥 값이 들어간다는게 중요
				 else if (ch == ')') 
					st.pop(); //'('가 있다면 st의 맨 위의 값을 꺼냄
				//st.pop()이 실패할 경우 예외가 발생
			}
				if(st.empty()) { //그렇게 for문을 돌린 후 st가 비어있다면
					System.out.println("괄호의 개수가 일치합니다");
				} else { //st가 비어있지 않다면
					System.out.println("괄호의 개수가 일치하지않습니다");
				}
			
		} catch (Exception e) { 
			System.out.println("닫는 괄호의 개수가 여는 괄호보다 많습니다");
		}
		
	} 

}
