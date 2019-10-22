package Week1.DaoNguocMang;

import java.util.Scanner;

public class DaoNguocMang {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int size;
        int[] array;
        //Khai Báo kích thước của mảng không vượt quas 20
        do {
            System.out.print("Enter a size:");
            size = Scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
        //Nhập vào giá trị phần tử của mảng
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = Scanner.nextInt();
            i++;
        }

        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.printf("%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

    }

}
