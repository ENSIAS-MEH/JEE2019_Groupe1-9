package Model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User extends Person {
	private String FirstName;
	private String LastName;
	private String BirthDate;
	private String Nationality;
	private String Gender;
	private boolean IsActive;
	private String ProfileImage;
	private int Age;
	
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getProfileImage() {
		return ProfileImage;
	}

	public void setProfileImage(String profileImage) {
		ProfileImage = profileImage;
	}

	public boolean isIsActive() {
		return IsActive;
	}

	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	
	public int getAge() {
		return Age;
	}
	
	public void setAge() {
		LocalDate d1 = LocalDate.parse(BirthDate, DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate d2 = LocalDate.now();
		Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
		long diffDays = diff.toDays();
		Age = (int) (diffDays/365);
	}
	

	public User(int id, String email, String password, String birthDate) {
		super(id, email, password);
		BirthDate = birthDate;
		setAge();
	}

	public User(int id, String email, String password, String firstName, String lastName, String nationality,
			String birthDate, String gender, String profileImage, boolean isActive) {
		super(id, email, password);
		FirstName = firstName;
		LastName = lastName;
		Nationality = nationality;
		BirthDate = birthDate;
		Gender = gender;
		ProfileImage = profileImage;
		IsActive = isActive;
		setAge();
		}
}

