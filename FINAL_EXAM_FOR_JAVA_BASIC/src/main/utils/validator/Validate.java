package main.utils.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import main.entities.HomePhone;
import main.entities.OldPhone;
import main.entities.Phone;
import main.repotisory.IRepository;
import main.repotisory.RepositoryImpl;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01
 */
public class Validate {

	static IRepository repository = new RepositoryImpl();

	public static Map<String, Double> priceWarrantyMap = new HashMap<>();

	public static final String REGEX_FULLNAME = "^[a-zA-Z0-9\\s ]{10,50}+$"; // check full name valid
	public static final String REGEX_PHONE_NUMBER = "^(0)(3[1|5|8]|9[0|8|1])[0-9]{7}$"; // check phone number
	public static final String REGEX_PHONE_VN = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
	public static final String REGEX_ID = "^(CH|XT|OD){1}+[0-9]{4}$";
	public static final String REGEX_BIRTH_DAY = "^(?:0[1-9]|[12]\\d|3[01])([\\/.-])(?:0[1-9]|1[012])\\1(?:19|20)\\d\\d$";
	public static final String REGEX_STR = "^[a-zA-Z\\s]*$";
	public static final String REGEX_ID_CARD = "^\\d+$";
	public static final String REGEX_EMAIL = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}";
	public static final String REGEX_ID_ROOM = "(SVRO)[-][\\d]{4}";
	public static final String REGEX_RENTAL_PEOPLE = "[1-9]|[1][1-9]|[(20)]";
	public static final String REGEX_PRICE = "^([1-9][0-9])|([1-9][\\d]{2})$";
	public static final String REGEX_AREA = "^([3-9][0-9])|([1-9][0-9]{2,})$";
	public static final String REGEX_POOL_AREA = "^[1-2][0-9]$";

	static {
		priceWarrantyMap.put("Foreign", 0.06);
		priceWarrantyMap.put("OldPhone", 0.07);
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param date
	 * @return boolean
	 * @TODO check validate import date
	 */
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

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param id
	 * @return boolean
	 * @TODO check validate id
	 */
	public static boolean checkValidId(String id) {
		if (id.matches(REGEX_ID)) {
			return true;
		}
		return false;
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param id
	 * @return boolean
	 * @TODO check duplicated id
	 */
	public static boolean checkDuplicatedId(String id) {
		return repository.checkDuplicateId(id);
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param date
	 * @return boolean
	 * @TODO check validate birthdate
	 */
	public static boolean checkBirthday(String date) {

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			LocalDate dayOfBirths = LocalDate.parse(date, formatter.withResolverStyle(ResolverStyle.STRICT));
			if (dayOfBirths.getYear() < 1900 || ChronoUnit.DAYS.between(LocalDate.now(), dayOfBirths) > 0) {
				return false;
			}
		} catch (DateTimeException e) {
			System.out.println("Invalid birthdate! Please check the date " + date);
			return false;
		}
		return true;
	}

	public static boolean checkRangeAndStatus(Phone phone) {
		if (phone instanceof HomePhone) {
			HomePhone homePhone = (HomePhone) phone;
			if (homePhone.getRange() == 1 || homePhone.getRange() == 2) {
				return true;
			}
		} else if (phone instanceof OldPhone) {
			OldPhone oldPhone = (OldPhone) phone;
			if (oldPhone.getStatus() == 1 || oldPhone.getStatus() == 2) {
				return true;
			}
		} else {
			return true;
		}

		return false;
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param phoneNumber
	 * @return boolean
	 * @TODO check validate phone number
	 */
	public static boolean checkPhoneNumber(String phoneNumber) {
		phoneNumber = phoneNumber.trim();
		if (phoneNumber.matches(REGEX_PHONE_NUMBER)) {
			return true;
		}
		return false;
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param email
	 * @return boolean
	 * @TODO check validate email
	 */
	public static boolean checkEmail(String email) {
		if (email.matches(REGEX_EMAIL)) {
			return true;
		}
		return false;
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param date
	 * @return date with new format
	 */
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
