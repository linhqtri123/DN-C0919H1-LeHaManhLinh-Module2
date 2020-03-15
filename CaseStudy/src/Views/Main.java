package Views;

import Controllers.MainController;
import Models.House;
import Models.Room;
import Models.Services;
import Models.Villa;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Services[] s = new Services[3];
//        s[0]= new Villa("Villa1","Villa",50,30,5,"Year","Vip","None",30,2);
//        s[1] = new House("House1","House",60,70,3,"Year","None","None",2);
//        s[2] = new Room("Room1","Room",20,30,1,"Day","Normal");
//        System.out.println("Information of services: ");
//        for(int i=0;i<s.length;i++) {
//            s[i].showInfor();
//            System.out.println("--------------------------------------");
//            System.out.println("\n");
//        }
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }
}
