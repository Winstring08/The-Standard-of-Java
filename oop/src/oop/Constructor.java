package oop;

public class Constructor {
	String color; //this.color
	String type; //this.type
	String name; //this.name
	Constructor(String color, String type, String name){
		this.color = color; //iv와 lv를 구별해준다
		this.type = type;
		this.name = name;
	}
	Constructor(){
		this("white","A","angel"); //다른 생성자를 호출한다, this()는 첫줄에서만 사용 가능 
	}
	Constructor(String color){
		this(color,"B","banana"); //매개변수를 사용하는것도 가능
	}
}
