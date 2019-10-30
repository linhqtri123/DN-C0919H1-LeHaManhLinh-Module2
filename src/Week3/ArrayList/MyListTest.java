package Week3.ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        MyList<Integer> list3 = new MyList<>();
        list.add(0, 2);
        list.add(1, 1);
        list.add(2, 3);
        list.add(3, 4);
        list.add(4, 1);
        list.add(5);
    }
}
