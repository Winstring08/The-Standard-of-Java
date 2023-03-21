package CollectionsFramework;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx {
	static Queue q = new LinkedList();
	static final int MAX = 5; // 최대 목록 개수를 사용하기 위해 상수 지정

	public static void main(String[] args) { // 최근 입력 목록
		while (true) { //무한 반복문
			System.out.println("값을 입력해주세요"); //처음 출력될 문구
			Scanner sc = new Scanner(System.in);
			String input = sc.next().trim(); // trim()으로 빈값에 공백만 존재하는 경우를 방지 ( "    " )
			if (input.equals("")) { //입력값을 trim()한값이 빈칸일경우
				continue; //반복문의 끝으로 가서 완료하고 ( } ) 다시 시작
			} else if (input.equals("history")) { //입력값이 history일경우
				LinkedList ll = (LinkedList) q; //LinkedList의 메서드인 get()을 사용하기 위해 q를 형변환
				final int SIZE = ll.size(); //메모리 낭비를  막기 위해 반복해서 사용되는 메서드를 상수로 지정
				for (int i = 0; i < SIZE; i++) { //q의 크기만큼 for문을 반복
					System.out.println(i + 1 + "." + ll.get(i)); //1.첫번째 입력값 2.두번째 입력값
				}
			} else { //빈칸도 history도 아닐 경우에는
				q.offer(input); //입력값을 q에 offer
				if (q.size() > MAX) { //q에 저장된 객체의 수가 5보다 많아진다면
					q.poll(); //q의 처음 저장된 맨 아래의 값을 꺼냄
				}
			}
		}
	}
}
