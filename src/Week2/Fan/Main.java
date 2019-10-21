package Week2.Fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setOn(true);
        fan1.setColor("yellow");
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        Fan fan2 = new Fan();
        System.out.println("Fan 1: "+fan1.toString());
        System.out.println("Fan 2: "+fan2.toString());
    }
}
