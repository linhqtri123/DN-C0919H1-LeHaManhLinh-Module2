package Week1.HienThi20SoNguyenToDauTien;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        int input = -1;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter the limit of array prime: ");
            input = scanner.nextInt();
            display(input);
        }while (input!=0);
    }
    static void display(int number){
        int count = 0;
        for(int i=2;i<=Integer.MAX_VALUE;i++){
            if(count == number)
                break;
            if(isPrime(i)){
                System.out.print(i+" ");
                count++;
            }
        }
        System.out.println();
    }
    static boolean isPrime(int value){
        for(int i=2; i<=Math.sqrt(value);i++){
            if(value % i == 0)
                return false;
        }
        return true;
    }
}
