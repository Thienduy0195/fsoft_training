package General_Assignment_BTJB_opt1_Day1;

import java.util.Scanner;

public class Cau3 {
	
	// 3. Viết chương trình tính : S = 1+1/3!+1/5!+…..+1/(2n-1)!. Số n được nhập từ bàn phím
	
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
	       System.out.println("Mời nhập số n:");
	        int n = input.nextInt(), s = 1;
	        float sum = 0;
	        for (int i = 1; i <= 2 * n - 1; i++) {
	            if (i % 2 != 0) {
	                for (int j = 1; j <= i; j++) {
	                    s *= j;
	                }
	                sum += (float) 1 / s;
	            }
	        }
	        System.out.println("Kết quả có được là: " + sum);
	}

}
