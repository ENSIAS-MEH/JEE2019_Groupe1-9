package Model;

public class Person {
	private int Id;
	private String Email;
	private String Password;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public Person(int id, String email, String password) {
		super();
		Id = id;
		Email = email;
		Password = password;
	}
}
