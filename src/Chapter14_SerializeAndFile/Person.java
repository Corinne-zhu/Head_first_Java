package Chapter14_SerializeAndFile;

import java.io.Serializable;

//驗證序列化對象不使用SerialUID 發生什麼錯誤

public class Person implements Serializable {

	private static final long serialVersionUID = -3241517977665588852L;

	// 原本只有age 一個實例變量
	private int age , tel;

	// 增加name
	private String name, address;

	public Person() {
		super();
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTel() {
		return this.tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}



}
