package General_Assignment_BTJB_opt1_Day1;

import java.util.Scanner;

public class Cau2 {

	// 2. Viết chương trình tính : S=1+1/2+1/3+....+1/n. Số n được nhập từ bàn phím
	
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
        System.out.println("Mời nhập số n:");
        int n = input.nextInt();
        float sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (float) 1 / i;
        }
        System.out.println("Kết quả có được là: " + sum);
	}

}
