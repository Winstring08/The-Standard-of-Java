package exception;

public class ReThrowing {

	public static void main(String[] args) throws Exception {
		try {
			method(); //예외가 던져졌으므로 이곳에서 예외가 일어난것으로 간주
		} catch (Exception e) {
			System.out.println("예외 처리 한번 더 됐다는 내용"); //한번더 예외 처리
		}
	}
	
	static void method() throws Exception {
		try {
			throw new Exception("대충 예외 문구"); //인공적으로 예외를 생성하여 catch에 던짐
		} catch (Exception e) {
			System.out.println("대충 예외 처리 했다는 내용"); 
			throw e; //catch되어 예외처리가 되었지만 받아온 예외를 호출한 곳에 다시 던짐(re-throwing)
		}
	}

}
