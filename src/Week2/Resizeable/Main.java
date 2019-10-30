package Week2.Resizeable;

public class Main {
    public static void main(String[] args) {
        Shape[] s = new Shape[4];
        s[0] = new Circle(6);
        s[1] = new Rectangle(5,7);
        s[2] = new Square(6);

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
            s[i].resize(getRandom()/100);
        }
    }
    public static double getRandom(){
        return (Math.random() * 100 + 1);
    }
}
