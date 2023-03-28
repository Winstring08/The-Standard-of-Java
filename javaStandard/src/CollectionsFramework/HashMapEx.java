package CollectionsFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapEx {

	public static void main(String[] args) { //로그인
		Map m = new HashMap(); //새로운 HashMap객체 생성
		m.put("aaa", "111");
		m.put("bbb", "222");
		m.put("ccc", "333");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) { //무한반복문
			System.out.println("id와 password를 입력해주세요");
			System.out.print("id : ");
			String id = sc.next().trim(); //스캐너에 입력한 값의 앞뒤에 빈칸이 있다면 제거하여 id에 저장
			
			System.out.print("password : ");
			String pwd = sc.next().trim();
			System.out.println(); //스캐너에 입력한 값의 앞뒤에 빈칸이 있다면 제거하여 pwd에 저장
			
			if(!m.containsKey(id)) { //m이 id를 키로 가지고있지 않다면
				System.out.println("일치하는 아이디가 존재하지 않습니다");
				continue; //반복문의 처음으로 돌아가 다시 반복함
			}else if(!m.get(id).equals(pwd)) { //m의 키가 id인 value값이 pwd와 같지않다면
				System.out.println("비밀번호가 일치하지 않습니다");
				continue;
			} else {
				System.out.println("아이디와 패스워드가 일치합니다");
				break; //반복문을 즉시 종료하고 벗어남
			}
		}

	}
}
