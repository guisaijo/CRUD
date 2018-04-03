package domain;

public class User extends DomainEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	private String id;
	private String name;
	private int age;
	private String gender;
}
