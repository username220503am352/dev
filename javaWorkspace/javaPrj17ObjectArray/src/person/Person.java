package person;

public class Person {
	
	//생성자
	public Person(String name, String hometown, int age, char gender) {
		this.name = name;
		this.hometown = hometown;
		this.age = age;
		this.gender = gender;
	}

	//data
	private String name;
	private String hometown;
	private int age;
	private char gender;
	
	//method
	public void goHome() {
		System.out.println("집에 가고싶다 ~~~");
	}
	
	public void study() {
		System.out.println("공부하자 ~~~");
	}
	
	public void workout() {
		System.out.println("운동하자 ~~~");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", hometown=" + hometown + ", age=" + age + ", gender=" + gender + "]";
	}
	
	

}//class

















