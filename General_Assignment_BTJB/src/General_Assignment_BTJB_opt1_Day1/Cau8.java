package General_Assignment_BTJB_opt1_Day1;

import java.util.Arrays;
import java.util.Scanner;

public class Cau8 {
	
    /*
    8.	Viết chương trình thực hiện các công việc như sau :
    a.	Nhập một mảng a gồm n phần tử kiểu nguyên int
    b.	Tính tổng số dương lẻ của mảng a
    c.	Nhập vào phần tử k, tìm xem k có xuất hiện trong mảng a không. Nếu có chỉ ra các vị trí của k trong mảng.
    d.	Sắp sếp mảng a theo thứ tự tăng dần.
    e.	Chèn một số p vào mảng a sao cho mảng a vẫn đảm bảo tăng dần.
     */

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
        //    a.	Nhập một mảng a gồm n phần tử kiểu nguyên int
        System.out.println("a. mời nhập số phần tử của mảng a:");
        int n = input.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Mời nhập phần tử vị trí " + i);
            arr[i] = input.nextInt();
            if (arr[i] > 0 && arr[i] % 2 > 0) {
                sum += arr[i];
            }
        }

        //b.	Tính tổng số dương lẻ của mảng a
        System.out.println("b. Tổng số dương lẻ trong mảng a là :" + sum);

        //c.	Nhập vào phần tử k, tìm xem k có xuất hiện trong mảng a không. Nếu có chỉ ra các vị trí của k trong mảng.
        System.out.println("c. Mời nhập vào phẩn tử k để kiểm tra có trong mảng a hay không:");
        int k = input.nextInt();
        boolean check = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                System.out.println(k + " có trong mảng a và ở vị trí: " + i);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println(k + " không có trong mảng a");
        }

        //d.	Sắp sếp mảng a theo thứ tự tăng dần.

        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Mảng sau khi sắp xếp: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

        //e.	Chèn một số p vào mảng a sao cho mảng a vẫn đảm bảo tăng dần.
        int[] newArray = new int[arr.length + 1];
        System.out.println("Mời nhập số cần chèn: ");
        int p = input.nextInt();
        System.out.println("Mảng mới sau khi chèn p: ");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < p) {
                newArray[i] = arr[i];
            } else {
                if (count == 0) {
                    newArray[i] = p;
                    p = arr[arr.length - 1];
                    count++;
                } else {
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(newArray));

	}

}
