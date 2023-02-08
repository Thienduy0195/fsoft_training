package General_Assignment_BTJB_opt1_Day1;

import java.util.Arrays;
import java.util.Scanner;

public class Cau9 {
	
    /*
    9.	Viết chương trình thực hiện công việc sau:
    a.	Nhập ma trận A (m dòng, n cột) gồm các phần tử kiểu int
    b.	Tính tích các số là bội số của 3 nằm trên dòng đầu tiên của ma trận
    c.	Tạo ra mảng một chiều X với X[i] là các giá trị lớn nhất trên từng dòng i của ma trận A.
     */

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		//a.	Nhập ma trận A (m dòng, n cột) gồm các phần tử kiểu int
        System.out.println("Mời nhập số dòng của ma trận A : ");
        int m = input.nextInt();
        System.out.println("Mời nhập số cột của ma trận A: ");
        int n = input.nextInt();

        int[][] array = new int[m][n];
        int[] arrayX = new int[m];
        int max;
        int s = 1;
        for (int i = 0; i < m; i++) {
            max = 0;
            for (int j = 0; j < n; j++) {
                System.out.println("Mời nhập phần tử [" + i + "][" + j + "]");
                array[i][j] = input.nextInt();
                if (array[0][j] % 3 == 0) {
                    s *= array[0][n];
                }
                if (array[i][j] > max) {
                    max = array[i][j];
                }
                arrayX[i] = max;
            }
            //b.	Tính tích các số là bội số của 3 nằm trên dòng đầu tiên của ma trận
            System.out.println("Tích các số là bội số của 3 nằm trên dòng đầu tiên của ma trận là: " + s);
        }

        //c.	Tạo ra mảng một chiều X với X[i] là các giá trị lớn nhất trên từng dòng i của ma trận A.
        System.out.print("Mảng X là: " + Arrays.toString(arrayX));
	}

}
