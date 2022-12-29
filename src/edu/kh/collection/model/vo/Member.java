package edu.kh.collection.model.vo;

import java.util.Objects;

public class Member {
	
	private String id;
	private String pw;
	private int age;
	
	
	public Member() {
		
		
	}
	public Member(String id, String pw, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", age=" + age + "]";
		
		
	}
	//hashCode equals 
	@Override
	public int hashCode() {
		return Objects.hash(age, id, pw);
	}
	
	@Override//아래의 과정을 한번에 수행
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(pw, other.pw);
	}
	
	
	// Object.equals() 오버라이딩
	// - 현재 객체와 매개변수로 전달 받은 필드가 같은지 비교하는 형태로 오버라이딩
	
	//public boolean equals(Object obj) {
		//Member other = (Member)obj;//다운캐스팅
		
		//equals 객체에 무엇이 들어올지 몰라 최상위 객체인 object를 사용
		//그리고 obj를 Member 객체에 다운 캐스팅을 하고 other라는 이름으로 저장
		
		//이제 other와 객체안에 있는 값을 비교
		//return this.id.equals(other.id) 
		 //&& this.pw.equals(other.pw) 
		 //&& this.age == other.age;
	//}
	
	
	
	// Object.hashCode() 오버라이딩
	

}
