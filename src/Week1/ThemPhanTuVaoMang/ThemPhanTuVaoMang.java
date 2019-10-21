package Week1.ThemPhanTuVaoMang;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    private int n;
    private int array[] = new int[100] ;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ThemPhanTuVaoMang add = new ThemPhanTuVaoMang();
        add.input();
        add.add();
        add.output();
    }
    public void input(){
        System.out.println("Enter the length of array: ");
        n = scanner.nextInt();
        for(int i=0; i<n; i++){
            System.out.println("Enter the element "+i+" : ");
            array[i] = scanner.nextInt();
        }
    }
    public void output(){
        for(int i=0; i<n; i++){
            System.out.print(array[i]+" ");
        }
    }
    public void add(){
        System.out.println("Enter the index you want to add: ");
        int index = scanner.nextInt();
        System.out.println("Enter the value you want to add: ");
        int value = scanner.nextInt();
        for(int i=n; i>=index; i--){
            array[i+1] = array[i];
        }
        array[index] = value;
        n++;
    }
}
