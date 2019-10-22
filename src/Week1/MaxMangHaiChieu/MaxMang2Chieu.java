package Week1.MaxMangHaiChieu;
import java.util.*;
public class MaxMang2Chieu {
    public static Scanner scanner = new Scanner(System.in);
    public static int[][] array;
    public static int n,m;
    public static void main(String[] args) {
        System.out.print("Nhập vào phần tử của hàng :");
        n = scanner.nextInt();
        System.out.print("Nhập vào phần tử của cột :");
        m = scanner.nextInt();
        array = new int[n][m];
        nhapMang();
        xuatMang();
        maxArray();

    }
    public static void nhapMang() {

        for (int i = 0; i < n; i++) {
            for (int j= 0; j < m ; j++){
                System.out.print("Phần tử Array[" + i + "]["+j+"] :");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println();
    }

    public static void xuatMang() {
        System.out.println("Array :");
        for (int i = 0; i < n; i++) {
            for (int j=0; j< m; j++){
                System.out.print("\t" + array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void maxArray() {
        int max = array[0][0];
        int indexi = 0;
        int indexj = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max < array[i][j]){
                    max = array[i][j];
                    indexi = i;
                    indexj = j;
                }
            }
        }
        System.out.print("Max Array "+max);
        System.out.print("Index Array["+indexi+"]["+indexj+"]");
    }
}
