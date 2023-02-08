package General_Assignment_BTJB_opt1_Day1;

import java.util.Scanner;

public class Cau5 {
	
    /*
    5.	Nhập 2 số nguyên dương a và b. 
    Sau đó in ra ước số chung lớn nhất và bội số chung nhỏ nhất của 2 số nguyên dương a và b đó.
     */
	
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Mời nhập số a:");
        int a = input.nextInt();
        System.out.println("Mời nhập số b:");
        int b = input.nextInt(), x = 0, y = 0;

        for (int i = 2; i < a; i++) {
            if (a % i == 0 && b % i == 0) {
                x = i;
            }
        }

        for (int i = 1; ; i++) {
            if (i % a == 0 && i % b == 0) {
                y = i;
                break;
            }
        }
        System.out.println("Ước chung lớn nhất: " + x);
        System.out.println("Bội chung nhỏ nhất: " + y);
	}
}
