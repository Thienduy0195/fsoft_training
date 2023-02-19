package main.utils.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Validate {
	public static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$"; // check email of person
	public static final String REGEX_FULLNAME = "^[a-zA-Z0-9\\s ]{10,50}+$"; // check full name valid
	public static final String REGEX_PHONE_NUMBER = "^(0)(3[1|5|8]|9[0|8|1])[0-9]{7}$"; // check phone number
	public static final String REGEX_PHONE_VN = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
	public static final String REGEX_ID = "^LT{1}+[0-9]{6}$";
	public static final String REGEX_BIRTH_DAY = "^(?:0[1-9]|[12]\\d|3[01])([\\/.-])(?:0[1-9]|1[012])\\1(?:19|20)\\d\\d$";

	public Validate() {
		// TODO Auto-generated constructor stub
	}

//	public static void main(String[] args) {
//		setFormatForDate("21/12/2020");
//	}

	public static boolean checkImportDate(String date) {
		try {
			Date date1 = new Date();
			Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			return date1.before(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean checkValidId(String id) {
		if (id.matches(REGEX_ID)) {
			return true;
		}
		return false;
	}

	public static boolean checkBirthday(String date) {

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			LocalDate dayOfBirths = LocalDate.parse(date, formatter.withResolverStyle(ResolverStyle.STRICT));
			if (dayOfBirths.getYear() < 1900 || ChronoUnit.DAYS.between(LocalDate.now(), dayOfBirths) > 0) {
				return false;
			}
		} catch (DateTimeException e) {
			System.out.println("Invalid year! Please check the date " + date);
			return false;
		}
		return true;
	}

	public static boolean checkFullName(String fullName) {
		fullName = fullName.trim();
		if (fullName.matches(REGEX_FULLNAME)) {
			return true;
		}
		return false;
	}

	public static boolean checkPhoneNumber(String phoneNumber) {
		phoneNumber = phoneNumber.trim();
		if (phoneNumber.matches(REGEX_PHONE_NUMBER)) {
			return true;
		}
		return false;
	}

	public static boolean checkEmail(String email) {
		if (email.matches(REGEX_EMAIL)) {
			return true;
		}
		return false;
	}

	public static String setFormatForDate(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
			return sdf2.format(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
