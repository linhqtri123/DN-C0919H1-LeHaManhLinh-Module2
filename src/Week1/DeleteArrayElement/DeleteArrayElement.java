package Week1.DeleteArrayElement;
import java.util.*;
public class DeleteArrayElement {
    private int size;
    private int array[] = new int[30];
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DeleteArrayElement dae = new DeleteArrayElement();
        dae.inputArray();
        dae.outputArray();
        dae.deleteElement();
        System.out.print("Mảng Sau Khi Xóa :");
        dae.outputArray();
    }

    public void inputArray() {

        System.out.print("Nhập vào số phần tử : ");
        size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            System.out.print("Phần tử " + i + " :");
            array[i] = scanner.nextInt();
        }
        System.out.println();
    }

    public void outputArray() {
        System.out.print("Array :");
        for (int i = 0; i < size; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println();
    }
    public void deleteElement(){
        System.out.print("Nhập giá trị cần xóa");
        int value = scanner.nextInt();
        int index = 0;

        for (int i = 0; i < size; i++){
            if (array[i] == value){
                index = i;
                for (int j = index; j < size-1; j++ ){
                    array[j] = array[j+1];
                }
                size--;
            }
        }

    }
}
