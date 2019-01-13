package entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class _user extends _person implements Serializable{
	private String _first_name;
	private String _last_name;
	private String _birth_date;
	private String _nationality;
	private String _gender;
	private int _is_active;
	private String _profile_img;
	private int _age;
	
	public int get_is_active() {
        return _is_active;
    }

    public void set_is_active(int _is_active) {
        this._is_active = _is_active;
    }

    public String get_profile_img() {
        return _profile_img;
    }

    public void set_profile_img(String _profile_img) {
        this._profile_img = _profile_img;
    }

    public _user() {
        super();
    }

    public String get_first_name() {
        return _first_name;
    }

    public String get_last_name() {
        return _last_name;
    }

    public String get_birth_date() {
        return _birth_date;
    }

    public String get_nationality() {
        return _nationality;
    }

    public String get_gender() {
        return _gender;
    }

    public void set_last_name(String _last_name) {
        this._last_name = _last_name;
    }

    public void set_birth_date(String _birth_date) {
        this._birth_date = _birth_date;
    }

    public void set_nationality(String _nationality) {
        this._nationality = _nationality;
    }

    public void set_gender(String _gender) {
        this._gender = _gender;
    }

    public void set_first_name(String _first_name) {
        this._first_name = _first_name;
    }


	
	



	public _user(int id, String email, String password, String birthDate) {
		super(id, email, password);
		_birth_date = birthDate;
		set_age();
	}

	
	
	
	
	
	
	
	
	
	
	
	public _user(int id, String email, String password, String firstName, String lastName, String nationality,
			String birthDate, String gender, String profileImage, int isActive) {
		super(id, email, password);
		_first_name = firstName;
		_last_name = lastName;
		_nationality = nationality;
		_birth_date = birthDate;
		_gender = gender;
		_profile_img = profileImage;
		_is_active = isActive;
		set_age();
		}
	
	 
	 
	 public int get_age() {
			return _age;
		}
		
		public void set_age() {
			LocalDate d1 = LocalDate.parse(_birth_date, DateTimeFormatter.ISO_LOCAL_DATE);
			LocalDate d2 = LocalDate.now();
			Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
			long diffDays = diff.toDays();
			_age = (int) (diffDays/365);
		}
}
