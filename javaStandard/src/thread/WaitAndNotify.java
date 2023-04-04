package thread;

import java.util.ArrayList;

class Customer implements Runnable{
	private Table table;
	private String food;
	
	public Customer(Table table, String food) {
		this.table=table;
		this.food=food;
	}
	
	@Override
	public void run() {
		while(true) { //실행중 이것을 계속 반복
			try {Thread.sleep(100);} catch (InterruptedException e) {}
			String name = Thread.currentThread().getName();
			table.remove(food); //food가 일치하는 table의 음식을 먹음
			System.out.println(name+" ate a "+food);
		}
	}
	}

class Cook implements Runnable{
private Table table;

public Cook(Table table) {
	this.table=table;
}

	@Override
	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table.dishNum());
			//0<=범위<'dishNames에 저장한 음식 개수' 의 랜덤숫자 //0<=범위<3
			table.add(table.dishNames[idx]); //dounut,dounut,burger 중 하나를 추가
			try {Thread.sleep(100);} catch (InterruptedException e) {}
		}
	}
	}

class Table{
	String[] dishNames = {"dounut","dounut","burger"}; 
	//도넛의 수를 많게 만들어 도넛이 추가될 확률을 높임
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	public synchronized void add(String dish) {
		while(dishes.size() >= MAX_FOOD) { //최대 음식량보다 현재 음식량이 크거나 같으면
			String name = Thread.currentThread().getName();
			System.out.println(name+" is waiting...");
			try {
				wait(); //만들면 안되므로 COOK 쓰레드를 기다리게 함
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		
		dishes.add(dish);
		notify(); //음식이 생겼으므로 기다리고있는 CUST쓰레드를 깨움
		System.out.println("dishes : "+dishes.toString());
	}
	
	public void remove(String dishName) {
		synchronized(this) { //임계영역으로 설정
			String name = Thread.currentThread().getName();
			while(dishes.size()==0) { //dishes가 하나도 없다면
				System.out.println(name+" is waiting");
				try {
					wait(); //먹을수 없으므로 CUST 쓰레드를 기다리게 함
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			
			while(true) {
				for(int i=0; i<dishes.size();i++) {//dishes의 모든 요소를 순서대로 탐색해서
					if(dishName.equals(dishes.get(i))) {
						//dishName과 이름이 일치하는 요소가 있다면
						dishes.remove(i); //그 요소를 삭제
						notify(); //테이블에 자리가 생겼으므로 COOK을 깨움
						return; //while문이 들어있는 함수 자체를 벗어남
						//remove()메서드의 남은 코드는 실행되지 않고 호출한 곳으로 돌아감
					}
				}
				try { //if문에 조건이 만족되지 않은 경우 return되지 않고 이곳으로 옴
					System.out.println(name+" is waiting");
					wait(); //원하는 음식이 없다는 뜻이므로 CUST쓰레드가 기다림
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			
		}
	}
	
	public int dishNum() {
		return dishNames.length; //dishNames의 길이(3) 을 리턴
	}
	
}
		

public class WaitAndNotify {

	public static void main(String[] args) throws Exception{
		Table table = new Table();
		
		new Thread(new Cook(table),"COOK").start();
		new Thread(new Customer(table,"dounut"),"CUST1").start();
		new Thread(new Customer(table,"burger"),"CUST2").start();
		Thread.sleep(10000);
		System.exit(0);
	}

}
