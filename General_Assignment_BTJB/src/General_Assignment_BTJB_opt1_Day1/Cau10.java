package General_Assignment_BTJB_opt1_Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cau10 {

	/*
	 * 10. Viết chương trình đọc một file đầu vào có định dạng *.csv: Nội dung của
	 * file csv lưu thông tin của một nhóm sinh viên, bao gồm các thông tin sau:
	 * StdNo, StdName, StdPhone, StdEmail, GradePoint. a. Hãy viết function đọc file
	 * csv, sau đó hiển thị toàn bộ thông tin của các sinh viên lên màn hình
	 * console. b. Viết hàm kiểm tra dữ liệu của file csv, nếu sai định dạng phone
	 * hoặc email thì thông báo lỗi ra file error.txt.
	 */

	static Scanner input = new Scanner(System.in);
	public static final String STUDENTS_PATH = "src/General_Assignment_BTJB_opt1_Day1/STD.csv";
	public static final String ERROR_FILE = "src/General_Assignment_BTJB_opt1_Day1/error.txt";
	public static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$"; // check email of person
	public static final String REGEX_PHONE_NUMBER = "^(84|0[3|5|7|8|9])+([0-9]{8})$"; // check phone number of person

	public static void main(String[] args) {
		readFile(STUDENTS_PATH);
	}

	public static List<String[]> readFile(String path) {
		File file = new File(path);
		List<String[]> studentList = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line = "";
			int no = 0;
			while ((line = bufferedReader.readLine()) != null) {
				String[] studentArray = line.split(",");
				studentList.add(studentArray);
				no++;
				if (validate(studentArray[2], studentArray[3]) != null) {
					writeFile(ERROR_FILE, "Line " + no + " : " + " co loi sai dinh dang "
							+ validate(studentArray[2], studentArray[3]));
				}
			}
			for (String[] item : studentList) {
				System.out.println(Arrays.toString(item));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public static void writeFile(String path, String str) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
			bw.write(str);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.out.println("The copy file is not found!, please create copy file!");
		}
	}

	public static String validate(String phone, String email) {
		if (!phone.matches(REGEX_PHONE_NUMBER)) {
			if (!email.matches(REGEX_EMAIL)) {
				return "StdPhone, StdEmail";
			} else {
				return "StdPhone";
			}
		} else if (!email.matches(REGEX_EMAIL)) {
			return "StdEmail";
		}
		return null;
	}

}
