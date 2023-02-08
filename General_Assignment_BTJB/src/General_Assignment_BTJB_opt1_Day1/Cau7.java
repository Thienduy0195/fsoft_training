package General_Assignment_BTJB_opt1_Day1;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Cau7 {

    /*
    7.	Nhập vào một String S,  thực hiện công việc sau:
    a.	In ra màn hình String đảo ngược của S
    b.	Đổi toàn bộ kí tự của S sang chữ Hoa
    c.	Đổi toàn bộ kí tự của S sang chữ thường
    d.	Đưa ra bảng tần số xuất hiện của các kí tự trong S
    e.	Trích ra chuỗi con của từ kí tự thứ n đến thứ m của S (n, m nhập từ bàn phím)
     */
	
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Mời nhập vào chuỗi :");
        String s = input.nextLine();
        String s1 = "";
        String s2 = "";
        String[] arr = s.split("");
        s = "";
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            s1 += arr[i];
            s += arr[s1.length() - 1].toUpperCase();
            s2 += arr[s1.length() - 1].toLowerCase();
        }
        for (int j = 0; j < arr.length; j++) {
            Integer b = map.get(arr[j]);
            if (b == null) {
                b = 0;
            }
            map.put(arr[j], b + 1);
        }

        System.out.println("a.Chuỗi đảo ngược là: " + s1);
        System.out.println("b.Chuyển sang chuỗi in hoa là: " + s);
        System.out.println("c.Chuyển sang chuỗi in thường là: " + s2);
        System.out.println("d. Đếm số lần xuất hiện ký tự trong chuỗi:");
        for (String key : map.keySet()) {
            System.out.println("Số lần xuất hiện ký tự " + key + " trong chuỗi là: " + map.get(key));
        }
        s = "";

        System.out.println("e. Trích ra chuỗi con của từ kí tự thứ n đến thứ m của S (n, m nhập từ bàn phím)");
        while (true) {
            System.out.println("Mời nhập vị trí n: ");
            int n = input.nextInt();
            System.out.println("Mời nhập vị trí m: ");
            int m = input.nextInt();

            if (0 <= n && n <= m && m <= arr.length) {
                for (int i = n; i <= m; i++) {
                    s += arr[i];
                }
                System.out.println("Chuỗi con từ " + n + " đến " + m + " là: " + s);
            } else {
                System.out.println("Vị trí n và m không hợp lệ, xin mời nhập lại!");
            }
        }

	}

}
