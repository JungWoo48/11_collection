package edu.kh.collection.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.model.vo.Member;

public class SetService {
	
	
	//Set(집합)
	// - 순서를 유지하지 않음(== index가 없다)
	// - 중복을 허용하지 않는다. ( +null도 중복허용하지 않는다, 1개만 저장 가능)
	
	
	//******** Set이 중복을 확인하는 방법 *************
	//컬렉션은 객체만 저장할수 있다. ( Set도 컬렉션이 떄문에 객체만 저장)
	// -> Set은 객체가 가지고 있는 필드값이 모두 같으면 붕복으로 판단한다.
	// --> 이 때 필드값이 같은지 비교하기 위해서 
	//    객체에 "equals()" 가 반드시 오버라이딩 되어야 한다.
	
	
	public void ex1() {
		
		Set<String> set = new HashSet<String>();
		
		// HashSet : Set의 대표적인 자식 클래스
		// 사용 조건 1 : 저장되는 객체 equals() 오버라이딩 필수
		// 사용 조건 2 : 저장되는 객체에 HashCode() 오버라이딩 필수
		// String은 굉장히 완성도가 높은 클래스로 
		// 이미 equals HashCode가 오러라이딩 되어있다.
		// 다른 클래스를 만들떄는 equals HashCode를 오버라이딩 해야한다
		
		// Set.add(String e) : 추가
		set.add("네이버");
		set.add("카카오");
		set.add("쿠팡");
		set.add("배민");
		//순서가 유지 되지 않는다 
		set.add("배민");
		set.add("배민");
		set.add("배민");
		//중복값을 허용하지 않아서 1개만 출력된다
		set.add(null);
		set.add(null);
		set.add(null);
		//null 역시 중복이 안된다
		
		System.out.println(set);
		
		
		//size() : 저장된 데이터의 개수 반환
		System.out.println("저장된 데이터의 수 : " + set.size());
		
		
		//remove(String e) : Set에 저장된 객체중 매개변수 e와 필드값이 같은 객체를 제거
		//Hash 라느 단어가 포함된 Set이면 HashCode()도 같아야 한다.
		
		System.out.println( set.remove("배민")); // 삭제하면 true/ 실패하면 flase
		System.out.println( set.remove("당근"));
		
		
		System.out.println(set);//제거확인 출력
		
		//List는 index가 있어서 get()으로 요소를 하나 얻어올수 있었지만
		//Set은 순서가 없어서 지정된객체 하나를 얻어 올 방법이 없다
		//-> 대신에 Set전체의 데이터를 하나씩 반복적으로 얻어올수 있다 -> 그게 Iterator
		
		
		//1. Iterator (반복자)
		//-컬렉션애서 제공하는 컬렉션 객체 반복 접근자
		// (컬렉션에 저장된 데이터를 임의로 하나씩 반복적으로 꺼내는 역할)
		
		
		Iterator<String> it = set.iterator();
		//set.iterator() : Set을 Iterator 하나씩 꺼내갈수 있는 모양으로 변환한것
		
		while(it.hasNext()) {  //hasNext : 다음 값이 있는지 확인하는 문구- 다음값이 있으면 true-다음값이 없으면 false 종료
			
			//it.next() : 다음값(객체) 를 얻어온다
			String temp = it.next();
			System.out.println(temp);
		}
		
		System.out.println("=================================");
		
		
		//iterator는 너무 복잡하다
		//향상된 for문 사용 
		//for( 하나씩 꺼내서 저장할 변수 : 컬렉션 )
		for(String temp : set) {
			System.out.println(temp);
		}
		
		
	}
	
	public void ex2() {
		
		// Hash 함수 : 입력된 단어를 지정된 길이의 문자열로 변환하는 함수( 중복이 없다)
		// ex) 입력 111 - > "asdfg" (5글자)
		//     입력 1234567 -> "qwert" (5글자)
		// Hash코드는 암호화에 사용한다
		// 일정한 길이의 랜덤값을 생성, 중복X
		
		// hashCode() : 필드 값이 다르면 중복되지 않는 숫자를 만드는 메서드
		// -> 빠른 데이터 검색을 위해서 만듬(객체가 어디에 있는지 빨리 찾는다)
		
		// HashSet() : 중복없이 데이터를 저장(Set)하고 데이터 검색이 빠름(Hash)
		
		Member mem1 = new Member("user01", "pass01", 30);
		Member mem2 = new Member("user01", "pass01", 30);
		Member mem3 = new Member("user02", "pass02", 50);
		
		
		System.out.println(mem1 == mem2 );//참조형이기 때문에 주소를 비교한다
											//값은 같아도 주소가 다르기때문에 false
											//얕은 복사가 아니라면 다 false이다.
		
		//값을 비교할때는 equals 오버라이딩을 사용한다
		
		System.out.println(mem1.equals(mem2)); // mem1 과 mem2의 필드가 같은지 묻는 구문 주소값이 아니라 값을 묻는다. 객체 상속 다형성 복습
		//- true
		System.out.println(mem1.equals(mem3)); // mem1과 mem3의 필드가 다른가?
		//- false
		
		
	}
	
	public void ex3() {
		
		//오버라이딩 된 equals()를 이용하여 Member를 Set에 저장
		
		// [Key Point] : 중복이 제거 되는가?
		
		Set<Member> memberSet = new HashSet<Member>();
		
		
		memberSet.add(new Member("user01", "pass01", 30));
		memberSet.add(new Member("user02", "pass02", 40));
		memberSet.add(new Member("user03", "pass03", 45));
		memberSet.add(new Member("user04", "pass04", 20));
		memberSet.add(new Member("user04", "pass04", 20));
		
		
		for( Member mem : memberSet ) {
			System.out.println(mem);
			
		
			
			//중복된 4번은 한개만 나온다
			//중복을 제거하는 기능은 Member 클래스에서 만든 hashCode 오버라이딩이 중복을 제거하고있다.
		}
		
		Member mem1 = new Member("user01", "pass01", 30);
		Member mem2 = new Member("user01", "pass01", 30);
		Member mem3 = new Member("user02", "pass02", 50);
		
		System.out.println(mem1.hashCode());//-1142504125 
		System.out.println(mem2.hashCode());//-1142504125 이 두가지는 hashcode가 같다 그래서 중복으로 판명되어 한개만 나온다
		System.out.println(mem3.hashCode());//-1142484873
		
	}
	
	public void ex4() {

		//Wrapper 클래스 : 기본자료형(int,double등등)을 객체로 포장하는 클래스
		
		//컬렉션에 기본 자료형을 저장하고 싶을때 사용
		//-기본 자료형에 없던 추가 기능,값을 이용하고 싶을떄 사용
		
		//<Wrapper 클래스의 종류>
		// int -> Integer
		// doublid -> Double
		// Boolean, Byte, Short, Long, Float, Character
		
		int iNum = 10;
		double dNum = 3.14;
		
		//기본자료형을 포장
		Integer w1 = new Integer(iNum);//삭제선 : 방식이 옛날이라 곧 사라질 방식이란뜻
		double w2 = new Double(dNum);
		
		//Wrapper 클래스 활용
		System.out.println("int 최대값 : " + w1.MAX_VALUE);//기울어진 글씨는 static
		System.out.println("int 최대값 : " + w1.MIN_VALUE);
		
		System.out.println("=======static 빙식으로 Wrapper클래스 사용=========");
		System.out.println("int 최대값 : " + Integer.MAX_VALUE);
		System.out.println("int 최대값 : " + Integer.MIN_VALUE);
		
		//-------------------------------
		
		//parsing : 데이터읳형식을 변환
		
		//String 데이터를 기본 자료형을 ㅗ변환
		
		int num1 = Integer.parseInt("100");
		double num2 = Double.parseDouble("1.23456");
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num1 + num2);//기본 자료형이기 때문에 하나의 숫자로 더해진다
		
		
		
	}
	
	public void ex5() {
		
		// Wrapper 클래스에 AutoBoxing / AutoUnBoxing
		
		Integer w1 = new Integer(100);
		
		
		//원래 대로라면 Integer에 숫자이므로 오류가 나야한다
		//그러나 자바가 Integer가 int의 포장형인것을 알고 int를 Integer로 자동 포장해준다-AutoBoxing
		Integer w2 = 100;
		Integer w3 = 200;
		
		System.out.println("w2 + w3 =" + (w2 + w3));//300
		//원래 대로라면 Integer + Integer 즉 객체+객체라 더해질수가 없다
		//그러나 자바가 포장을 자동으로 해체하여 연산을 하기떄문에 300이 나온다-AutoUnBoxing
	
		
	}
	
	public void lotto() {
		
		//번호 생성기 
		
		//HashSet
		//LinkedhashSet
		//TreeSet(오름차순)
		
		//Set<Integer> lotto = new HashSet<Integer>();//순서 유지가 안된다, 중복 제거만 해준다
		//Set<Integer> lotto = new LinkedHashSet<Integer>();//순서가 유지된다
		Set<Integer> lotto = new TreeSet<Integer>();//중복을 제거해주고 순서를 오름차순으로 정렬해준다
		//Integer는 equals, hashCode 오버라이딩 완료 상태이다.
		
		while( lotto.size() < 6) {
			// lotto에 저장된 값이 개수가 6개 미만이면 반복한다
			
			
			int random = (int)(Math.random() * 45 + 1); // 1-45 난수 저장
			
			
			System.out.println(random); //발생 순서 확인
			
			
			lotto.add(random);//int값이 자동으로 Inteager로 포장되어 lotto추가
			
			
		}
		
		
		System.out.println("로또 번호 : " + lotto);
		
		
		
		
	}
	
	
	

}
