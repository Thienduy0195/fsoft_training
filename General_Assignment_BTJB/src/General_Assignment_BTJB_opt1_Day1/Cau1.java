package General_Assignment_BTJB_opt1_Day1;

import java.util.Scanner;

public class Cau1 {
	
	// 1. in ra hình tam giác có chiều cao n, với n được nhập từ bàn phím
	
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		while (true) {
            System.out.println("Mời nhập chiều cao tam giác:");
            int n = input.nextInt();
            if (n > 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (j <= i) {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                break;
            } else {
                System.out.println("Mời nhập số dương: ");
            }
        }
	}

}

