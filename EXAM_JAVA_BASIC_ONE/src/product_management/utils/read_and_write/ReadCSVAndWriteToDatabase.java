package product_management.utils.read_and_write;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import product_management.entities.Laptop;
import product_management.entities.LaptopMacbook;
import product_management.entities.LaptopWindows;

public class ReadCSVAndWriteToDatabase {

	static Scanner input = new Scanner(System.in);
	public static final String LAPTOP_PATH = "src/product_management/data/laptopdb.csv";

	public static List<Laptop> readFile() {

		File file = new File(LAPTOP_PATH);
		List<Laptop> laptopList = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				String[] array = line.split(",");
				if (array[0].equals("1")) {
					LaptopWindows laptop = new LaptopWindows();
					laptop.setTypeId(Integer.parseInt(array[0]));
					laptop.setLaptopId(array[1]);
					laptop.setName(array[2]);
					laptop.setBrand(array[3]);
					laptop.setRam(array[4]);
					laptop.setSsd(array[5]);
					laptop.setResolution(array[6]);
					laptop.setCpu(array[7]);
					laptop.setImportDate(array[8]);
					laptop.setPrice(Integer.parseInt(array[9]));
					laptop.setTouchScreen(array[10]);
					laptop.setNumpad(array[11]);
					laptopList.add(laptop);
				} else if (array[0].equals("2")) {
					LaptopMacbook laptop = new LaptopMacbook();
					laptop.setTypeId(Integer.parseInt(array[0]));
					laptop.setLaptopId(array[1]);
					laptop.setName(array[2]);
					laptop.setBrand(array[3]);
					laptop.setRam(array[4]);
					laptop.setSsd(array[5]);
					laptop.setResolution(array[6]);
					laptop.setCpu(array[7]);
					laptop.setImportDate(array[8]);
					laptop.setPrice(Integer.parseInt(array[9]));
					laptop.setMacType(array[12]);
					laptop.setCpuType(array[13]);
					laptop.setMacTypeCharge(array[14]);
					laptopList.add(laptop);
				}
			}
		} catch (

		IOException e) {
			e.printStackTrace();
		}
		return laptopList;
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
