package General_Assignment_BTJB_opt1_Day1;

public class Cau11 {
	
    //11.	Làm một ví dụ để phân biệt khái niệm by pass value và by pass refference

    public int num;

    public Cau11(int num) {
        this.num = num;
    }

    public static void main(String[] args) {

        //Ví dụ về Pass by value
        int a = 10;
        int b = 20;
        swapNumPassByValue(a,b);
        System.out.println(a);
        System.out.println(b);

        //Ví dụ về Pass by Reference
        Cau11 x = new Cau11(2);
        Cau11 y = new Cau11(4);

        swapNumPassByReference(x,y);

        System.out.println(x.num);
        System.out.println(y.num);


    }

    public static void swapNumPassByValue(int a, int b){
        int temp;
        temp =a;
        a = b;
        b=temp;
    }

    public static void swapNumPassByReference(Cau11 x, Cau11 y) {
        int temp;
        temp = x.num;
        x.num = y.num;
        y.num=temp;
    }
}
