package main.utils.read_and_write;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.entities.GoodStudent;
import main.entities.NormalStudent;
import main.entities.Student;

public class ReadCSVAndWriteToDatabase {

	static Scanner input = new Scanner(System.in);
	public static final String GOOD_STUDENT_PATH = "src/main/data/good_student.csv";
	public static final String NORMAL_STUDENT_PATH = "src/main/data/normal_student.csv";

	public static List<Student> readGoodStudentFile() {
		File file1 = null;
		File file2 = null;
		BufferedReader bufferedReader = null;
		List<Student> students = new ArrayList<>();
		try {
			file1 = new File(GOOD_STUDENT_PATH);
			file2 = new File(NORMAL_STUDENT_PATH);
			bufferedReader = new BufferedReader(new FileReader(file1));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				String[] array = line.split(",");

				GoodStudent goodStudent = new GoodStudent();
				goodStudent.setFullName(array[0].trim());
				goodStudent.setDoB(array[1]);
				goodStudent.setSex(array[2]);
				goodStudent.setPhoneNumber(array[3]);
				goodStudent.setUniversityName(array[4]);
				goodStudent.setGradeLevel(array[5]);
				goodStudent.setGpa(Double.parseDouble(array[6]));
				goodStudent.setBestRewardName(array[7]);
				students.add(goodStudent);

			}
			bufferedReader.close();
			file2 = new File(NORMAL_STUDENT_PATH);
			bufferedReader = new BufferedReader(new FileReader(file2));
			while ((line = bufferedReader.readLine()) != null) {
				String[] array = line.split(",");

				NormalStudent student = new NormalStudent();
				student.setFullName(array[0]);
				student.setDoB(array[1]);
				student.setSex(array[2]);
				student.setPhoneNumber(array[3]);
				student.setUniversityName(array[4]);
				student.setGradeLevel(array[5]);
				student.setEnglishScore(Integer.parseInt(array[6]));
				student.setEntryTestScore(Double.parseDouble(array[7]));
				students.add(student);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}

	public static void writeFile(String path, String str) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(path, true));
			bw.write(str);
			bw.newLine();
		} catch (IOException e) {
			System.out.println("The copy file is not found!, please create copy file!");
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
