package product_management.utils.validates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Validate {

	// regex to check laptop id
	public static final String REGEX_ID = "^LT+[0-9]{6}$";

	public static Map<String, Double> discountBoard = new HashMap<>();

	static {
		discountBoard.put("Dell", 0.05);
		discountBoard.put("HP", 0.05);
		discountBoard.put("LENOVO", 0.075);
		discountBoard.put("ASUS", 0.075);
		discountBoard.put("GIGABYTE", 0.1);
		discountBoard.put("MSI", 0.1);
	}

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

	public static boolean checkValidIId(String id) {
		if (!id.matches(REGEX_ID)) {
			return false;
		}
		return true;
	}
}
