package Week2.QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a:");
        double a = scanner.nextDouble();
        System.out.print("Enter b:");
        double b = scanner.nextDouble();
        System.out.print("Enter c:");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        if(quadraticEquation.getDiscriminant() >0){
            System.out.println("Having two root: "+quadraticEquation.getRoot1()+" and: "+quadraticEquation.getRoot2());
        }
        else if(quadraticEquation.getDiscriminant() == 0){
            System.out.println("Having one root: "+quadraticEquation.getRoot1());
        }
        else System.out.println("The equation has no roots");
    }
}
