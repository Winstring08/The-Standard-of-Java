package exception;

import java.io.File;
import java.util.Scanner;

public class Throws {
	public static void main(String[] args) {
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("텍스트 파일 생성기");
		System.out.println("생성하고자 하는 파일명을 입력해주세요");
		try {			
			File f = createFile(sc.next()); //createFile메서드에 sc.next를 들고 이동 
			//createFile()에서 예외가 발생한 경우 throw에 의해 이곳에 예외가 던져져 이곳에서 예외가 발생된것으로 간주
			System.out.println(f.getName()+"파일이 생성되었습니다");//예외 발생시 이 문구는 출력되지 않고 즉시 catch로 넘어감
		} catch (Exception e) { //예외가 던져진 경우 이 문장이 실행
			System.out.println("파일이름이 비어있습니다 다시 입력해주세요");
		}
System.out.println("생성기를 종료합니다"); //예외 여부에 상관없이 try-catch문 이후의 문장 실행
//올바르게 예외 처리가 되지 않아 프로그램이 비정상 종료된경우에는 출력되지 않음
	}

	static File createFile(String fileName) throws Exception{ //Exception 발생시 이 메서드를 호출한 곳에 Exception객체를 throw한다는 뜻
		if(fileName==null||fileName.equals("")) { //값이 넘어오지 않았거나 빈값이 넘어온 경우
			throw new Exception("파일 이름이 유효하지 않습니다"); //이 예외 객체를 생성하여 자신을 호출한 곳으로 던짐	
		}
		File f = new File(fileName+".text"); //예외가 발생하지 않았다면 이어서 실행
		f.createNewFile();//파일 생성
		return f;
	}

}
