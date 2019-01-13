package entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class _user extends _person implements Serializable{
	private String _firstName;
	private String _lastName;
	private String _birthDate;
	private String _nationality;
	private String _gender;
	private int _isActive;
	private String _profile_img;
	private int _age;
	
	public String get_first_name() {
		return _firstName;
	}

	public void set_first_name(String firstName) {
		_firstName = firstName;
	}

	public String get_last_name() {
		return _lastName;
	}

	public void set_last_name(String lastName) {
		_lastName = lastName;
	}

	public String get_nationality() {
		return _nationality;
	}

	public void set_nationality(String nationality) {
		_nationality = nationality;
	}

	public String get_birth_date() {
		return _birthDate;
	}

	public void set_birth_date(String birthDate) {
		_birthDate = birthDate;
	}

	public String get_gender() {
		return _gender;
	}

	public void set_gender(String gender) {
		_gender = gender;
	}

	public String get_profile_img() {
		return _profile_img;
	}

	public void set_profile_img(String profileImage) {
		_profile_img = profileImage;
	}

	public int get_is_active() {
		return _isActive;
	}

	public void set_is_active(int isActive) {
		_isActive = isActive;
	}
	
	public int get_age() {
		return _age;
	}
	
	public void set_age() {
		LocalDate d1 = LocalDate.parse(_birthDate, DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate d2 = LocalDate.now();
		Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
		long diffDays = diff.toDays();
		_age = (int) (diffDays/365);
	}
	

	public _user(int id, String email, String password, String birthDate) {
		super(id, email, password);
		_birthDate = birthDate;
		set_age();
	}

	public _user(int id, String email, String password, String firstName, String lastName, String nationality,
			String birthDate, String gender, String profileImage, int isActive) {
		super(id, email, password);
		_firstName = firstName;
		_lastName = lastName;
		_nationality = nationality;
		_birthDate = birthDate;
		_gender = gender;
		_profile_img = profileImage;
		_isActive = isActive;
		set_age();
		}
	 public _user() {
	        super();
	    }
}
