package Chapter14_SerializeAndFile;

import java.io.Serializable;

public class Duck implements Serializable {

	String name  ;
	int age;


	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}



}
