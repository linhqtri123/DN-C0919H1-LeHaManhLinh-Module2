package Week1.GopMang;
import java.util.*;
public class GopMang {
    private static int size;
    private static int array[];
    private static int array1[];
    private static int array2[];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nhập vào số phần tử Mảng Thứ 1 : ");
        int size1 = scanner.nextInt();
        array1 = new int[size1];
        nhapMang(array1,size1);
        xuatMang(array1,size1);

        System.out.print("Nhập vào số phần tử Mảng Thứ 2 : ");
        int size2 = scanner.nextInt();
        array2 = new int[size2];
        nhapMang(array2,size2);
        xuatMang(array2,size2);

        System.out.println("Mảng Sau Khi Gộp :");
        gopMang(array1,size1,array2,size2,array,size);


    }
    public static void nhapMang(int array[],int n) {

        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + i + " :");
            array[i] = scanner.nextInt();
        }
        System.out.println();
    }

    public static void xuatMang(int array[],int n) {
        System.out.print("Array :");
        for (int i = 0; i < n; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println();
    }
    public static void gopMang(int array1[], int size1,int array2[], int size2, int array[], int size){
        size = size1 + size2;
        array = new int[size];
        for (int i = 0; i < size; i++){
            if (i < size1){
                array[i] = array1[i];
            }
            else
                array[i] = array2[i - size1];
        }
        System.out.print("Array :");
        for (int j = 0; j < size; j++){
            System.out.print("\t" + array[j]);
        }

    }
}
