package Week1.TongDuongCheoChinhMaTranVuong;
import java.util.*;
public class TongDuongCheoChinhMaTranVuong {
    public  Scanner scanner = new Scanner(System.in);
    public int[][] array =  new int[30][30];
    public  int n,m;

    public static void main(String[] args) {
        TongDuongCheoChinhMaTranVuong sum = new TongDuongCheoChinhMaTranVuong();
        sum.inputArray();
        sum.outputArray();
        sum.sumMainDiagonal();
    }
    public void inputArray() {
        System.out.println("Nhập Vào Ma Trận Vuông");
        System.out.print("Nhập vào phần tử của hàng :");
        n = scanner.nextInt();
        System.out.print("Nhập vào phần tử của cột :");
        m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j= 0; j < m ; j++){
                System.out.print("Phần tử Array[" + i + "]["+j+"] :");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println();
    }

    public void outputArray() {
        System.out.println("Array :");
        for (int i = 0; i < n; i++) {
            for (int j=0; j< m; j++){
                System.out.print("\t" + array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void sumMainDiagonal(){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ( i == j){
                    sum += array[i][j];
                }
            }
        }
        System.out.print("Sum Main Diagonal : "+sum);
    }
}
