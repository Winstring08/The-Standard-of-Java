package nextCh12;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
//사용하지 않을 경우 ElementType.FIELD로 작성해야 함
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
enum Alphabet{FIRST,SECOND}

@interface DateTime{
	String yymmdd();
	String hhmmss();
}

@Retention(RUNTIME) //런타임중에 애너테이션이 실행되도록 설정
@Target( { FIELD, TYPE } ) //애너테이션의 적용대상을 지정
@interface MyAnnotation { //애너테이션 생성시 @interface를 붙여야 함
	int count() default 1; //인터페이스의 요소, 추상메서드 형태와 상수만 가능
	//애너테이션 사용시 count값을 지정하지 않아도 1로 지정됨
	String testedBy();
	String[] testTools() default {"JUnit1","JUnit2"}; 
	//애너테이션 사용시 testTools값을 지정하지 않아도 {"JUnit1","JUnit2"}로 지정됨
	Alphabet testType() default Alphabet.FIRST;
	//애너테이션 사용시 testType값을 지정하지 않아도 Alphabet.FIRST로 지정됨
	DateTime testDate();
} 
@Deprecated
@SuppressWarnings("엉터리로 입력") //유효하지 않은 애너테이션은 무시됨
@MyAnnotation (testedBy="aaa", testDate=@DateTime(yymmdd="230331",hhmmss="220346"))
//애너테이션 사용시 애너테이션 요소의 값을 지정해야 하며 내부애너테이션이 있을경우
//내부애너테이션의 요소의 값을 지정해야 함
public class AnnotationEx{ //TYPE
	public static void main(String[] args) {
		Class<AnnotationEx> c = AnnotationEx.class; //AnnotationEx 클래스의 정보를 객체로 얻음
		MyAnnotation ma = c.getAnnotation(MyAnnotation.class); 
		//AnnotationEx에 적용된 MyAnnotation을 가져옴
		//MyAnnotation 인터페이스의 정보객체를 c의 getAnnotation()메서드에 대입한 반환값을 ma에 대입
		//이 방식으로 클래스에 사용된 애너테이션을 매개변수에 담을 수 있음
		System.out.println(ma.count()); //1
		System.out.println(ma.testedBy()); //aaa
		for(String tt : ma.testTools()) {
			System.out.println(tt); //JUnit1 //JUnit2
		}
		System.out.println(ma.testType()); //FIRST
		System.out.println(ma.testDate().yymmdd()); //230331
		//ma.testDate()는 @MyAnnotation내부의 @DateTime 애너테이션이므로
		//@DateTime 애너테이션의 yymmdd()요소를 반환시키는것
		System.out.println(ma.testDate().hhmmss()); //220346
		
		Annotation[] annoArr = c.getAnnotations(); //AnnotationEx에 적용된 모든 애너테이션을 가져옴
		for(Annotation a : annoArr) { //순서대로 Annotation타입 a에 담아 반복문 실행
			System.out.println(a); //애너테이션을 출력
			//SupressWarnings는 유효하지 않은 애너테이션이므로 무시됨
		}
	
}
}