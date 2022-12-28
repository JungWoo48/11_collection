package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Student;

public class StudentService {
	//필드
	private Scanner sc = new Scanner(System.in);
	
	//학생 정보를 저장할 List생성 (객체 배열의 업그레이드 버전)
	
	//java.util.List 인터페이스 : List에 반드시 필요한 필수 기능을 모아둔 인터페이스
	// * 인터페이스는 객체 생성이 불가능 하지만 부모 참조 변수역할은 가능하다
	
	//java.util.ArrayList : 배열 형태 List ( 가장 대표적인 List 자식 클래스)
	
	//ArrayList() 기본생성자 : 기본 크기 10짜리 리스트를 생성한다
						// 리스트는 크기가 유동적이라 의미가 없다 그래서 기본생성자로 둔다
	
	//ArrayList(용량) : 용량 만틈의 리스트를 생성하지만 리스트틑 유동적이고 너무 큰 값을 작성하면 메모리 낭비이다.
	
	//List studentList = new ArrayList();
	private List<Student> studentList = new ArrayList<Student>();//제네릭스 사용문
	//List<Student> studentList = new LinkedList<Student>(); : LInkedList :추가 수정 삭제에 사용
	//Student로 저장되는 타입이 제한된 리스트를 생성한것
	//앞으로 
	
	public StudentService() {//studentList의 기본 생성자
		studentList.add(new Student("홍길동", 25, "서울시 중구", 'M', 90));
		studentList.add(new Student("고영희", 23, "경기도 안산시", 'F', 100));
		studentList.add(new Student("김아지", 30, "서울시 강남구", 'M', 80));
		studentList.add(new Student("오미나", 27, "충북 청주시", 'F', 90));
		studentList.add(new Student("박주희", 24, "서울 서대문구", 'F', 70));
	}

	
	public void ex() {
		//List 테스트
		
		//List.add(Object e) : 객체의 최상위 부모 objcet(객체)를 매개변수로 받는다
		//** 매갸변수 타입이 object == 모든 개체를 매개변수로 전달 할 수 있다.
		//(매개변수가 objcet == 최상위 부모 참조 변수 == 다형성 적용 가능)
		
		//studentList.add(new Student());//0번 인덱스
		//studentList.add(sc);//1번 인덱스
		//studentList.add("문자열");//2번인덱스 --위에서 제네릭스로 student로 정의했기에 사용불가능
		//studentList.add(new Object());//3번 인덱스
		// 컬렉션의 특딩 : 여러타입의 데이터 저장 가능
		
		//(반환형)
		//List.get(index i) : 리스트에서 i번쨰 인덱스에 있는 객체(object)를 반환
		//반환형이 object == 모든 객체를 반환할수 있다
		
		//System.out.println( studentList.get(3).toString() );//studentList의 n번쨰 인덱스를 출력한다는 뜻
		
		// [Student의 이름만 얻어오기]
		//student 객체가 맞는지 instanceof로 확인하고
		//get(int index) 메소드의 반환형이 object이기 때문에 다운캐스팅을 해야
		//student 기능이 사용 가능하다
		//if( studentList.get(0) instanceof Student ) {
			//System.out.println( ((Student)studentList.get(0)).getName());//(student)로 강제 형변환을 하여 get에 
																		//Student기능을 저장
		//}
		
		//-> 위 내용은 길고 복잡하다, 컬렉션의 장점인 여러객체 저장이 방해된다
		//그래서 ************제네릭스(Generics)***************를 사용한다 
		//< > 기호 사용
		//컬렉션에 저장되는 객체 타입을 한가지로 저장한다
		
		//System.out.println( studentList.get(0).getName());
		//위에서 제네릭스로 studentList는 Student라고 정의했기때문에 다운캐스팅 없이도 getName을 불러올수 있다
		
	}
	
	/**
	 * 메뉴 출력 메서드
	 * alt + shift + j
	 * @author 누가 적었는지 알아보기 위한 메서드
	 */
	public void displayMenu() {
		int menuNum = 0;
		
		do {
			System.out.println("\n========== 학생관리 프로그램 =========\n");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(포함)");
			
			System.out.println("0. 프로그램 종료");
			
			System.out.println("\n메뉴 번호 선택 >>");
			
			try {
				menuNum = sc.nextInt();
				System.out.println();//줄바꿈
				
				switch(menuNum) {
				case 1: System.out.println(addStudent());  break;
				case 2: selectAll(); break;//selectAll();는 학생 전체조회 메서드이다 모든 값을 출력하도록 한다.
				case 3: System.out.println( updateStudent());   break;
				case 4: System.out.println( removeStudent());  break;
				case 5: searchNmae1(); break;
				case 6: searchNmae2(); break;
				case 0: System.out.println("프로그램 종료"); break;
				default : System.out.println("메뉴의 번호만 입력"); 
				
				}
				
				
				
			} catch(InputMismatchException e) {
				
				System.out.println("\n잘못된 입력,다시 입력");
				sc.nextLine();// 입력 버퍼에 남아있느 잘못 입력된 문자열 제거용
				menuNum = -1; // 첫 반복시 잘못입력하는 경우 menuNum에 0이 있어서 프로그램이 바로 종료된다
								//그래서 -1을 menuNum으로 만들어 while문으로 넘어가지 않고 다시 do로 돌아간다
			}
			
		}while(menuNum !=0);
		
		
	}
	

	
	/*
	 * 1.학생 정보 추가 메서드
	 * -추가 성공시 "성공" 실패시 '실패" 문자열 반환
	 * 
	 * 
	 * 
	 * *@author 임정우
	 * @return "성공" or "실패" 문자열 반환
	 * @throws InputMismatchException
	 */
	public String addStudent() throws InputMismatchException {
		System.out.println("========학생 정보 추가========");
		
		System.out.println("이름 :");
		String name = sc.next();
		
		System.out.println("나이 :");
		int age = sc.nextInt();
		sc.nextLine();//개행
		
		System.out.println("사는곳 :");
		String region = sc.nextLine();
		
		System.out.println("성별 :");
		char gender = sc.next().charAt(0); //String -> char
		
		System.out.println("점수 :");
		int score = sc.nextInt();
		
		// Student 객체 생성후 List 추가 
		if(studentList.add(new Student(name, age, region, gender, score)) ) {
			return "성공";
		} else {
			return "실패";
		}
			
		
	}
	
	/**2.학생정보 전체 조회 메서드
	 * 
	 */
	public void selectAll() {
		//List 인덱스가 있다(0번부터 시작)
		//List에 저장된 데이터 개수를 얻어 오는법 : int List.size()
		// -> 배열명.length 대신 사용한다
		
		System.out.println("===== 학생 전체 조회 ======");
		//studentList 가 비어있는 걍우 "학생 정보가 없습니다" 출력
		
		//List가 비어있는지 확인하는 방법
		//boolean List.isEmpty() : 비어있으면 true를 반환하는 문구
		
		if(studentList.isEmpty()) {//studentList가 비어있으면 true반환
			System.out.println("학생 정보가 없습니다.");
			
			return;//반환형(void)  없는 return 구문은 현재 메소드를 종료하고 호출한 곳을 돌아간다
					//자동으로 else문을 슨것
			
			
		}
		//일반for문으로 학생정보 있을경우
		
		//for(int i = 0; i < studentList.size(); i++) {
			//System.out.println(studentList.get(i));
			// studentList에서 i번째 인덱스 요소를 얻어와 출력
			
		//}
		
		//향산된for문 (for each믄)
		// - 컬렉션, 배열 의 모든 요소를 순차적으로 반복 접근할 수 있느 for문
		//( 순차적: 0번 인덱스부터 마지막 요소까지 인덱스를 1씩 증가)
		
		//[작성법]
		// for(컬렉션 or 배열에서 꺼낸 한개의 요소를 저장할 변수 : 컬랙션 명 또는 배열명) {} 
		int index = 0;
		
		for( Student std : studentList) {
			System.out.print((index++) + "번 : ");//std에는 for문 반복시 마다 0,1,2,.....인덱스 요소들을 한번씩 저장됨
			System.out.println(std);
		}
		
		
	}
	
	
	/**
	 * 3.학생 정보 수정 메서드
	 * @return
	 */
	public String updateStudent() throws InputMismatchException {
		
		//List.set(int index, Student e)
		//--> List의 index 요소를 전달받은 e로 변경
		//-> 반환값 Student == 변경 전 Student 객체가 담겨있다
		
		System.out.println("===== 학생 정보 수정 =====");
		
		 System.out.println("인덱스 번호 입력 : ");
		 int index = sc.nextInt();
		 sc.nextLine();//개행
		 
		 //1) 학생 정보가 studentList에 있는가 확인
		 if( studentList.isEmpty()) {
			 return "입력된 학생정보 없음";
		 
	     //2) 입력된 숫자가 0보다 작은가 확인
		 }else if ( index < 0) {
			 return "음수는 입력불가";
			 
			 //+문자열을 입력한 경우 -> throws로 예외처리
			 
			 //3) 입력받은 숫자가 studentList 범위 내 인덱스 번호인가?
		 } else if( index >= studentList.size()) {
			 return "범위 외 숫자 입력";
			 
			 
		 } else {
			 
			 //오류가 없는걸 확인 한 이후 수정코드
			
			 //원래 저장된 학생정보
			 System.out.println(index + "번째 인덱스에 저장된 학생 정보");
			 System.out.println(studentList.get(index));
			 
			 //수정할 정보 입력
			 System.out.println("이름 :");
			 String name = sc.next();
				
			 System.out.println("나이 :");
			 int age = sc.nextInt();
				sc.nextLine();//개행
				
				System.out.println("사는곳 :");
				String region = sc.nextLine();
				
				System.out.println("성별 :");
				char gender = sc.next().charAt(0); //String -> char
				
				System.out.println("점수 :");
				int score = sc.nextInt();
				
				Student temp = studentList.set(index, new Student(name, age, region, gender, score));
			 
				
				return temp.getName() + "의 정보가 변경 되었습니다.";
		 }
		
		
	}

	/**
	 * 4. 학생 정보 제거 메서드
	 * @return
	 */
	public String removeStudent() {
		
		//List.remove(int index)
		//리스트에서 index번쨰 요소를 제거
		//이때 제거된 요소가 반환된다.
		//List는 중간에 비어있는 인덱스가 없게 하기 위해서 remove() 동작시 뒤쪽 요소를 한칸씩 당겨온다
		
		System.out.println("===== 학생 정보 제거 =====");
		
		System.out.println("인덱스 번호 입력");
		int index = sc.nextInt();
		sc.nextLine();//개행
		
		
		//1) 학생 정보가 studentList에 있는가 확인
		if( studentList.isEmpty()) {
			 return "입력된 학생정보 없음";
		 
	     //2) 입력된 숫자가 0보다 작은가 확인
		 }else if ( index < 0) {
			 return "음수는 입력불가";
			 
			 //+문자열을 입력한 경우 -> throws로 예외처리
			 
			 //3) 입력받은 숫자가 studentList 범위 내 인덱스 번호인가?
		 } else if( index >= studentList.size()) {
			 return "범위 외 숫자 입력";
			 
		 } else { 
			 //학생 정보 제거
			 
			 System.out.println("정말 삭제 하겠습니까? (Y/N) : ");
			 char ch = sc.next().toUpperCase().charAt(0);
			 		//String -> 대문자 String -> 대문자 0번 인덱스 문자
			 
			 		//String.toUpperCase() : 문자열을 대문자로 변경
			 		//String.LowerCase() : 문자열을 소문자로 변경
			
			 if(ch == 'Y') {
				 Student temp = studentList.remove(index);
				 return temp.getName() + "의 정보가 제거되었습니다.";
				 
			 } else {
				 return "취소";
			 }
			 
			 
		 }
		
		

	}
	
	/**
	 * 5.이름이 일치하는 학생을 찾아서 조회하는 메서드
	 */
	public void searchNmae1() {
		
		System.out.println("======학생 검색(이름 일치)========");
		
		System.out.println("검색할 이름 입력 : ");
		String input = sc.next();
		
		boolean flag = true; //flag가 true인 경우 == > "검색 결과가 없습니다."
		
		for( Student std : studentList ) {
			
			if( input.equals(std.getName())) { //이름이 일치하는 경우
				System.out.println(std);
				flag = false;
				
			}
		}
		
		if(flag) {
			System.out.println("검색결과가 없습니다.");
		}
		

		
	}
	
	
	
	
	/**
	 * 6.이름에 특정 문자열이 포함되는 학생을 찾아서 조회하는 메서드
	 * 
	 */
	public void searchNmae2() {
		
		System.out.println("======학생 검색(문자열 포함)========");
		
		System.out.println("이름에 포함될 문자열 입력 : ");
		String input = sc.next();
		
		boolean flag = true; //flag가 true인 경우 == > "검색 결과가 없습니다."
		
		for( Student std : studentList ) {
			
			// contains : 포함
			// boolean String.contains(문자열) : String에 문자열이 포함되어있으면 true
			if( std.getName().contains(input)) { //포함이 되어있으면 true 아니면 false
				System.out.println(std);
				flag = false;
				
			}
		}
		
		if(flag) {
			System.out.println("검색결과가 없습니다.");
		}
	}
}
