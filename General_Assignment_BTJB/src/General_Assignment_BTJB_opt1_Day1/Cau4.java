package General_Assignment_BTJB_opt1_Day1;

import java.util.Scanner;

public class Cau4 {
	
    /*
    4.	Tính tổng và tích các chữ số của một số m, m được nhập từ bàn phím
        (Ví dụ : m = 234 => S = 2 + 3 + 4 = 9, P = 2 * 3 * 4 = 24)
     */
	
	
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
        System.out.println("Mời nhập số m:");
        int m = input.nextInt();
        System.out.println("Mời nhập số n:");
        int n = input.nextInt();

        System.out.println("Tổng của 2 số là: " + (m + n));
        System.out.println("Tích của 2 số là: " + m * n);
	}

}
