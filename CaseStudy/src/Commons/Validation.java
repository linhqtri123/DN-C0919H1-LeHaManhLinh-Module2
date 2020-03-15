package Commons;

import java.util.Scanner;

public class Validation {
    private static String regex = "";
    private static Scanner scanner;

    public static boolean checkNameService(String nameService) {
        regex = "^[A-Z][a-z]{1,}(?: [A-Z][a-z]*){0,6}$";
        return nameService.matches(regex);
    }

    public static double checkNumberDouble(String content,String err) {
            try {
                scanner = new Scanner(System.in);
                System.out.println(content);
                return scanner.nextDouble();
            } catch (Exception ex) {
                System.out.println(err);
            }
            return 0;
    }

    public static int checkNumberInteger(String content, String err) {
            try {
                scanner = new Scanner(System.in);
                System.out.println(content);
                return scanner.nextInt();
            } catch (Exception ex) {
                System.out.println(err);
            }
        return 0;
    }

    public static boolean checkFreeService(String freeService){
        if((freeService.equals("massage"))||(freeService.equals("karaoke"))||
                (freeService.equals("food"))||(freeService.equals("drink"))||(freeService.equals("car"))){
            return true;
        }
        return false;
    }

    public static boolean checkEmail(String str) {
        regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        return str.matches(regex);
    }
    public static boolean checkBirthday(String str) {
        regex = "^(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/((19|20)\\d\\d)$";
        return str.matches(regex);
    }
    public static boolean checkIdCard(String str) {
        regex = "^[1-9][\\d]{8}$";
        return str.matches(regex);
    }
    public static boolean checkGender(String str) {
        regex = "^[mM][aA][lL][eE]|[fF][eE][mM][aA][lL][eE]|[uU][nN][kK][nN][oO][wW]$";
        return str.matches(regex);
    }
}
