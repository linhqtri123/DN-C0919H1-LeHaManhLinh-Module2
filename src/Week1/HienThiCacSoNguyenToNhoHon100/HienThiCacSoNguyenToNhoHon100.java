package Week1.HienThiCacSoNguyenToNhoHon100;

import java.util.Scanner;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        for(int i=2; i<100;i++){
            if(isPrime(i))
                System.out.print(i+" ");
        }
    }
    static boolean isPrime(int value){
        for(int i=2; i<Math.sqrt(value);i++){
            if(value % i == 0)
                return false;
        }
        return true;
    }
}
