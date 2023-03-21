package CollectionsFramework;

import java.util.ArrayList;

public class ArrayListRemove {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(0);
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		
		for(int i=0; i<al.size();i++) {
			al.remove(i);//배열이 계속 복사되어 위로 올라오기 때문에 삭제되지 않음
		}
		System.out.println(al); 
		
		for(int i=al.size()-1; i>=0;i--) {
			al.remove(i);//계속 마지막 배열을 삭제하므로 배열이 복사되지 않음
		}
		System.out.println(al); 
	}

}
