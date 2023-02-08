package General_Assignment_BTJB_opt1_Day1;

import java.util.Scanner;
import java.util.Stack;

public class Cau6 {

	/*
	 * 6. Viết chương nhập vào một số nguyên dương n. Sau đó quy đổi n ra hệ nhị
	 * phân.
	 */

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("Mời nhập số nguyên dương n:");
			int n = input.nextInt();
			if (n > 1) {
				Integer x = 1;
				Stack<Integer> stack = new Stack<>();
				while (n > 0) {
					x = n % 2;
					stack.add(x);
					n = n / 2;
				}
				int a = stack.size();
				System.out.print("Kết quả chuyển sang hệ nhị phân: ");
				for (int i = 0; i < a; i++) {
					System.out.print(stack.pop());
				}
				System.out.println();
			} else {
				System.out.println("Bạn đã nhập sai yêu cầu!");
			}
		}

	}

}
