package main.test;

public class TestRegex {

	public static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$"; // check email of person
	public static final String REGEX_FULLNAME = "^[a-zA-Z0-9\\s ]{10,50}+$"; // check full name valid
	public static final String REGEX_PHONE_NUMBER = "^(0)(3[1|5|8]|9[0|8|1])[0-9]{7}$"; // check phone number
	public static final String REGEX_PHONE_VN = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
	public static final String REGEX_ID = "^LT{1}+[0-9]{6}$";
	public static final String REGEX_BIRTH_DAY = "^(?:0[1-9]|[12]\\d|3[01])([\\/.-])(?:0[1-9]|1[012])\\1(?:19|20)\\d\\d$";

	public TestRegex() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		checkMatchRex("0909999999", REGEX_PHONE_NUMBER);
	}

	public static void checkMatchRex(String value, String regex) {
		if (value.matches(regex)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

}
