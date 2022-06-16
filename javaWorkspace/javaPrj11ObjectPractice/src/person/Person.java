package person;

public class Person {
	
	private String name;
	private String addr;
	private int birth;
	private char gender;
	private int age;
	
	//name
	public void setName(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	//addr
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddr() {
		return addr;
	}
	
	//birth
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public int getBirth() {
		return birth;
	}
	
	//gender
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return gender;
	}

	//age
	public void setAge(int age){
		if(this.age < age) {
			this.age = age;
		}
	}
	
	public int getAge(){
		return age;
	}
	
	

}//class






















