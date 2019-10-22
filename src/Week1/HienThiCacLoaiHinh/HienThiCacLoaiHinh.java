package Week1.HienThiCacLoaiHinh;
import java.util.*;
public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1.Print the rectangle");
        System.out.println("2.Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
        System.out.println("3.Print isosceles triangle");
        System.out.println("4.Exit");

        System.out.print("Enter a number:");
        int number = scanner.nextInt();

        switch (number){
            case 1 :
                System.out.println("Nhập Chiều Dài");
                int lenght = scanner.nextInt();
                System.out.println("Nhập Chiều Rộng");
                int weight = scanner.nextInt();
                for (int i = 0; i< weight; i++){
                    for (int j = 0; j<lenght; j++){
                        System.out.print("*\t");
                    }
                    System.out.println();
                }
                break;
            case 2:
                System.out.println("Nhập Chiều Cao Của Tam Giác");
                int height = scanner.nextInt();
                for (int i = 0; i < height; i++){
                    for (int j = 0; j <= i; j++){
                        System.out.print("*\t");
                    }
                    System.out.println();
                }
                break;
            case 3:
                System.out.println("Nhập Chiều Cao Của Tam Giác");
                int height1 = scanner.nextInt();
                for (int i=0; i<= height1; i++){
                    for(int j=0; j<height1-i; j++){
                        System.out.print("\t");
                    }
                    for (int j=1; j<=2*i-1; j++){
                        System.out.print("*\t");
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Nhập Sai");
        }
    }
}
