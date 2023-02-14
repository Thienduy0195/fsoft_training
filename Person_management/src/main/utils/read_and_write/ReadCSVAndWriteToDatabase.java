package main.utils.read_and_write;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.entities.Beneficiary;
import main.entities.Diasease;
import main.entities.Disaster;
import main.entities.Indigent;

public class ReadCSVAndWriteToDatabase {

	static Scanner input = new Scanner(System.in);
	public static final String PERSON_PATH = "src/main/data/data1.csv";

	public static void main(String[] args) {
		List<Beneficiary> aa = readFile();
		for (Beneficiary beneficiary : aa) {
			System.out.println(beneficiary.showInfo());
		}
	}

	public static List<Beneficiary> readFile() {

		File file = new File(PERSON_PATH);
		List<Beneficiary> beneficiaries = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				String[] array = line.split(",");
				if (array[0].equals("1")) {
					Diasease p = new Diasease();
					p.setTypeId(Integer.parseInt(array[0]));
					p.setId(array[1]);
					p.setName(array[2]);
					p.setBirthdate(array[3]);
					p.setAddress(array[4]);
					p.setPhone(array[5]);
					p.setBenefitDate(array[6]);
					p.setBenefit(Integer.parseInt(array[7]));
					p.setIllness(array[8]);
					p.setSickDate(array[9]);
					beneficiaries.add(p);
				} else if (array[0].equals("2")) {
					Disaster p = new Disaster();
					p.setTypeId(Integer.parseInt(array[0]));
					p.setId(array[1]);
					p.setName(array[2]);
					p.setBirthdate(array[3]);
					p.setAddress(array[4]);
					p.setPhone(array[5]);
					p.setBenefitDate(array[6]);
					p.setBenefit(Integer.parseInt(array[7]));
					p.setDisasterType(array[10]);
					p.setImpactDate(array[11]);
					p.setTotalDamage(Integer.parseInt(array[12]));
					beneficiaries.add(p);
				} else if (array[0].equals("3")) {
					Indigent p = new Indigent();
					p.setTypeId(Integer.parseInt(array[0]));
					p.setId(array[1]);
					p.setName(array[2]);
					p.setBirthdate(array[3]);
					p.setAddress(array[4]);
					p.setPhone(array[5]);
					p.setBenefitDate(array[6]);
					p.setBenefit(Integer.parseInt(array[7]));
					p.setIncome(Integer.parseInt(array[13]));
					p.setDependantAmount(Integer.parseInt(array[14]));
					beneficiaries.add(p);
				}
			}
		} catch (

		IOException e) {
			e.printStackTrace();
		}
		return beneficiaries;
	}

}
