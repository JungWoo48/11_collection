package edu.kh.collection.model.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.collection.model.vo.Member;

public class MapService {
	
	//Map : Key와 value 한쌍이 데이터가 되어 이를 모아둔 객체
	
	//- Key를 모아두면 Set의 특징(중복 X)
	//- Value를 모아두면 List의 특징(증복 O)
	
	public void ex1() {
		
		// HashMap<K , V> : Map의 자식 클래스중 가장 대표되는 Map
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//Map.put(Integer key, String value) : map에서 add의 역할을 갖고있음 == add
		map.put(1, "홍길동");
		map.put(2, "이길동");
		map.put(3, "김길동");
		map.put(4, "갑길동");
		map.put(5, "윤길동");
		
		System.out.println(map);
		
		
		
	}
	
	public void ex2() {
		// Map 사용 예제
		
		//V)(값 저장용 객체)는 특정 데이터 묶음 의 재사용이 많은 경우 주로 사용한다
		//-> 재사용이 적은 Vo는 오히려 코드 낭비이다
		//--> Map을 이용해서 Vo와 비슷한 코드를 작성할수 있다.
		
		
		//1) Vo버전
		
		Member mem = new Member();
		
		//값 세팅 
		mem.setId("user01");
		mem.setPw("pass01");
		mem.setAge(30);
		
		// 값 출력
		System.out.println( mem.getId());
		System.out.println( mem.getPw());
		System.out.println( mem.getAge());

		
		System.out.println("===============");
		//2) map 버전
		
		Map<String, Object> map = new HashMap<String, Object>();
		//value가 object 타입== 어떤 객체든 value에 들어갈수 있다
		
		//값 세팅
		map.put("id", "user01");
		map.put("pw", "pass01");
		map.put("age", 25); //int - integer
		
		//값 출력
		System.out.println();
		
		
		System.out.println( map.get("pw"));
		System.out.println( map.get("age"));
		
		System.out.println("===================");
		//***** Map에 저장된 데이터를 순차적으로 접근하기 ****
		
		
		// Map에서 Key만 모아두면 Set의 특징
		//-> 이를 활용할 수 있도록 Map에서 KeySet() 메서드 제공
		//--> Key만 모아서 Set으로 반환
		
		Set<String> set = map.keySet(); //id, pw ,age가 저장된 set을 반환
		
		System.out.println(set);
		
		
		//향상된 for문
		
		for(String key :set) {
			System.out.println(map.get(key));
			//Key가 반복될때마다 변경된다 -key-id key-pw key- age 한번씩 접근후 출력
			//-> 변경된 Key에 맞는 map의 value가 출력된다
			//set 안에 무엇이 들어있는지 몰라도 get(key)를 이용해서 어떤 value가 들어가 있는지 모두 뽑아낸다
			
		}
		
	
		
		//map에 저장된 데이터가 많을때, 
		//어떤 Key가 있는지 불분명 할때.
		//map에 저장된 모든 데이터에 접근해야할떄
		//KeySet() + 향상된 for문 코드를 사용한다-- key가 set안에 있는 모든 객체에 접근하여 그때마다 다른 value를 가져온다
		
		
		
	}
	
	public void ex3() {
		
		//List + Map 
		//user 10명 , user id를 다 뽑아낸다
		
		//k : v
		//"id : " user01"
		//"id : " user02"
		//"id : " user03"
		//.......
		
		List<Map<String, Object>> list = new ArrayList <Map<String, Object>>();
		//List안에 Map객체를 제네릭스 한것
		
		for (int i = 0; i < 10; i++ ) {
			//map 생성
			Map<String, Object> map = new HashMap<String, Object>();
								//여기 있는 map이 위에있는 list에 들어간다
			
			map.put("id", "user0"+ i);
			map.put("pw", "pass0"+ i);
			
			//map을 리스트에 추가
			list.add(map);
			
			
		}
		
		//for문 종료 시점에 List에는 10개의 Map객체가 추가 되어있다.
		
		//* List에 저장된 Map에서 Key가 id인경우의 Value를 모두 출력**
		
		//향상된 for문 이용
		for( Map<String, Object> temp : list ) {
			System.out.println( temp.get("id"));
		}
		
	}

}
