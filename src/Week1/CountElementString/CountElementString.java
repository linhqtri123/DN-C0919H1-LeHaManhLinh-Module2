package Week1.CountElementString;
import java.util.*;
import java.lang.String;
public class CountElementString {
    private String string;

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CountElementString cet = new CountElementString();
        cet.inoutString();
        cet.countElement();
    }
    public void inoutString(){
        System.out.print("Enter Any String : ");
        string = scanner.nextLine();
        System.out.println("String : "+string);
    }
    public void countElement(){
        System.out.print("Enter the Character : ");
        char ch =(char) scanner.next().charAt(0);
        int count = 0;

        for (int i = 0 ; i < string.length(); i++ ){
            if (ch == string.charAt(i)){
                count ++;
            }
        }
        System.out.print("Ký Tự "+ch+" "+count+" Xuất Hiện");
    }
}
