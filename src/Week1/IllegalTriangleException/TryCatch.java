package Week1.IllegalTriangleException;

import java.util.Scanner;

public class TryCatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TryCatch tg = new TryCatch();
        System.out.print("Nhập Cạnh a : ");
        int a = scanner.nextInt();
        System.out.print("Nhập Cạnh b : ");
        int b = scanner.nextInt();
        System.out.print("Nhập Cạnh c : ");
        int c = scanner.nextInt();
        try {
            tg.ktTamGiac(a,b,c);
            System.out.println("Đây Là 3 cạnh của Tam Giác");
        }
        catch (IllegalTriangleException e){
            System.out.println("Error !!! ");
        }

    }
    public void ktTamGiac(int a, int b, int c) throws IllegalTriangleException {
        if ((a<0 && b<0 && c <0)||(a+b<c||a+c <b||b+c<a))
            throw new IllegalTriangleException();

    }
}
