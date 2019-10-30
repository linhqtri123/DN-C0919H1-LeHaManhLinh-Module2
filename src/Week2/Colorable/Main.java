package Week2.Colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] s = new Shape[4];
        s[0] = new Circle(6);
        s[2] = new Rectangle(5,7);
        s[1] = new Square(6);
        s[3] = new Square(3);

        for (int i = 0; i <s.length ; i++) {
            System.out.println(s[i]);
            if (s[i] instanceof Square) {
                Colorable colorable = (Square) s[i];
                colorable.howToColor();
            }
        }
    }
}
