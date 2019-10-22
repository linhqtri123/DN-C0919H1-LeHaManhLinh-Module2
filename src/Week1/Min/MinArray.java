package Week1.Min;
import java.util.*;
public class MinArray {
    private int size;
    private int array[] = new int[30];
    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        MinArray minarr = new MinArray();
        minarr.inputArray();
        minarr.outputArray();
        minarr.minArray();
    }
    public void inputArray() {

        System.out.print("Nhập vào số phần tử : ");
        size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            System.out.print("Phần tử " + i + " :");
            array[i] = scanner.nextInt();
        }
        System.out.println();
    }

    public void outputArray() {
        System.out.print("Array :");
        for (int i = 0; i < size; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println();
    }
    public void minArray(){
        int min = array[0];
        int index = 0;
        for (int i = 0 ; i < size; i++){
            if (min > array[i]){
                min = array[i];
                index = i;
            }
        }
        System.out.println("Min Array : "+min+" Index : "+index);
    }
}
