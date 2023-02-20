package main.utils.read_and_write;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.entities.ForeignPhone;
import main.entities.HomePhone;
import main.entities.OldPhone;
import main.entities.Phone;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01
 */
public class ReadCSVAndWriteToDatabase {

	static Scanner input = new Scanner(System.in);
	public static final String DATA_PATH = "src/main/data/phone.txt";
	static BufferedReader bufferedReader = null;
	static File file = null;

//	public static void main(String[] args) {
//		readFile();
//	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @return
	 * @TODO
	 */
	public static List<Phone> readFile() {
		List<Phone> list = new ArrayList<>();
		try {
			file = new File(DATA_PATH);
			bufferedReader = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				String[] array = line.split(",");
//				System.out.println(array.length);
				if (array[0].startsWith("CH")) {
					HomePhone phone = new HomePhone();
					phone.setId(array[0]);
					phone.setName(array[1]);
					phone.setScreenSize(Double.parseDouble(array[2]));
					phone.setChipset(array[3]);
					phone.setRam(Integer.parseInt(array[4]));
					phone.setStorage(Integer.parseInt(array[5]));
					phone.setPrice(Double.parseDouble(array[6]));
					phone.setManufacture(array[7]);
					phone.setWarranty(Integer.parseInt(array[8]));
					phone.setRange(Integer.parseInt(array[9]));
					list.add(phone);
				} else if (array[0].startsWith("XT")) {
					ForeignPhone phone = new ForeignPhone();
					phone.setId(array[0]);
					phone.setName(array[1]);
					phone.setScreenSize(Double.parseDouble(array[2]));
					phone.setChipset(array[3]);
					phone.setRam(Integer.parseInt(array[4]));
					phone.setStorage(Integer.parseInt(array[5]));
					phone.setPrice(Double.parseDouble(array[6]));
					phone.setManufacture(array[7]);
					phone.setCountry(array[8]);
					phone.setPriceWarranty(Double.parseDouble(array[9]));
					list.add(phone);
				} else if (array[0].startsWith("OD")) {
					OldPhone phone = new OldPhone();
					phone.setId(array[0]);
					phone.setName(array[1]);
					phone.setScreenSize(Double.parseDouble(array[2]));
					phone.setChipset(array[3]);
					phone.setRam(Integer.parseInt(array[4]));
					phone.setStorage(Integer.parseInt(array[5]));
					phone.setPrice(Double.parseDouble(array[6]));
					phone.setManufacture(array[7]);
					phone.setStatus(Integer.parseInt(array[8]));
					phone.setBodyStatus(Integer.parseInt(array[9]));
					phone.setPriceWarranty(Double.parseDouble(array[10]));
					list.add(phone);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
