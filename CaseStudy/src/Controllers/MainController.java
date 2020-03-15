package Controllers;

import Commons.Validation;
import Models.*;

import Commons.FuncWriteFileCSV;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        System.out.println("\n1.Add new Service. " +
                "\n2.Show Service. " +
                "\n3.Add Customer. " +
                "\n4.Show Information Customers. " +
                "\n5.Add New Booking Resort. " +
                "\n6.Show Information Employee. " +
                "\n7.Furama Film 4D. " +
                "\n8.Exit. ");
        switch (scanner.nextInt()) {
            case 1:
                addNewService();
                break;
            case 2:
                showServices();
                break;
            case 3:
                addNewCustomer();
                break;
            case 4:
                showInforCustomer();
                displayMainMenu();
                break;
            case 5:
                addNewBookingResort();
                break;
            case 6:
                showInforEmployee();
                break;
            case 7:
                getListCusBuyTicket();
                break;
            case 8:
                System.exit(0);
            default:
                System.out.println("\nError. Back to Menu.");
                displayMainMenu();
        }
    }

    public static void addNewCustomer() {
        String content = "";
        String errMes = "";
        Customer cus = new Customer();
        cus.setIdCus(UUID.randomUUID().toString().replace("-", ""));
        scanner.nextLine();
        System.out.println("Enter Name Customer:");
        cus.setNameCustomer(scanner.nextLine());
        while (!Validation.checkNameService(cus.getNameCustomer())) {
            System.out.println("Name Customer is Invalid. Please try again !!!");
            System.out.println("Enter Name Customer:");
            cus.setNameCustomer(scanner.nextLine());
        }
        System.out.println("Enter Gender(Male / Female / Unknow):");
        cus.setGender(scanner.nextLine());
        while (!Validation.checkGender(cus.getGender())) {
            System.out.println("Gender is Invalid. Please try again !!!");
            System.out.println("Enter Gender(Male / Female / Unknow :");
            cus.setGender(scanner.nextLine());
        }

        System.out.println("Enter ID Card:");
        cus.setIdCard(scanner.nextLine());
        while (!Validation.checkIdCard(cus.getIdCard())) {
            System.out.println("ID Card is Invalid. Please try again !!!");
            System.out.println("Enter ID Card:");
            cus.setIdCard(scanner.nextLine());
        }

        content = "Enter Phone: ";
        errMes = "Phone is Invalid. Please try again!!!";
        cus.setPhone(Validation.checkNumberInteger(content, errMes));
        while (cus.getPhone() <= 0) {
            System.out.println(errMes);
            cus.setPhone(Validation.checkNumberInteger(content, errMes));
        }

        System.out.println("Enter Email:");
        cus.setMail(scanner.nextLine());
        while (!Validation.checkEmail(cus.getMail())) {
            System.out.println("Email is Invalid. Please try again !!!");
            System.out.println("Enter Email:");
            cus.setMail(scanner.nextLine());
        }

        System.out.println("Enter Type Customer:");
        cus.setTypeCustomer(scanner.nextLine());
        while (!Validation.checkNameService(cus.getTypeCustomer())) {
            System.out.println("Type Customer is Invalid. Please try again!!!");
            System.out.println("Enter Type Customer:");
            cus.setTypeCustomer(scanner.nextLine());
        }

        System.out.println("Enter Address:");
        cus.setAddress(scanner.nextLine());
        while (!Validation.checkNameService(cus.getAddress())) {
            System.out.println("Address is Invalid. Please try again!!!");
            System.out.println("Enter Address:");
            cus.setAddress(scanner.nextLine());
        }

        System.out.println("Enter Birthday (MM/DD/YYYY):");
        cus.setBirthday(scanner.nextLine());
        while (!Validation.checkBirthday(cus.getBirthday())) {
            System.out.println("Birthday is Invalid. Please try again!!!");
            System.out.println("Enter Birthday:");
            cus.setBirthday(scanner.nextLine());
        }
        ArrayList<Customer> listCustomer = FuncWriteFileCSV.getCustomerFromCSV();
        listCustomer.add(cus);
        FuncWriteFileCSV.writeCustomerToFileCSV(listCustomer);
        System.out.println("\nAdd Customer: " + cus.getNameCustomer() + " Successfully!!!");
        displayMainMenu();
    }

    private static void addNewBookingResort() {
        scanner.nextLine();
        ArrayList<Customer> listCustomer = FuncWriteFileCSV.getCustomerFromCSV();
        Collections.sort(listCustomer);
        int i = 1;
        for (Customer customer : listCustomer) {
            System.out.println("--------------");
            System.out.println("NO " + i);
            System.out.println(customer.showInfor());
            System.out.println("--------------");
            i++;
        }
        System.out.println("Choose Customer Booking:");
        Customer customer = listCustomer.get(scanner.nextInt() - 1);
        System.out.println("\n1.Booking Villa." +
                "\n2.Booking House." +
                "\n3.Booking Room.");
        System.out.println("Choose Service Booking.");
        switch (scanner.nextInt()) {
            case 1:
                i = 1;
                ArrayList<Villa> listVilla = FuncWriteFileCSV.getVillaFromCSV();
                for (Villa villa : listVilla) {
                    System.out.println("----------------------------");
                    System.out.println("NO " + i);
                    villa.showInfor();
                    System.out.println("----------------------------");
                    i++;
                }
                System.out.println("Choose Villa Booking.");
                Villa villa = listVilla.get(scanner.nextInt() - 1);
                customer.setService(villa);
                break;
            case 2:
                i = 1;
                ArrayList<House> listHouse = FuncWriteFileCSV.getHouseFromCSV();
                for (House house : listHouse) {
                    System.out.println("----------------------------");
                    System.out.println("NO " + i);
                    house.showInfor();
                    System.out.println("----------------------------");
                    i++;
                }
                System.out.println("Choose House Booking.");
                House house = listHouse.get(scanner.nextInt() - 1);
                customer.setService(house);
                break;
            case 3:
                i = 1;
                ArrayList<Room> listRoom = FuncWriteFileCSV.getRoomFromCSV();
                for (Room room : listRoom) {
                    System.out.println("----------------------------");
                    System.out.println("NO " + i);
                    room.showInfor();
                    System.out.println("----------------------------");
                    i++;
                }
                System.out.println("Choose Room Booking.");
                Room room = listRoom.get(scanner.nextInt() - 1);
                customer.setService(room);
                break;
            default:
                displayMainMenu();
                break;
        }
        ArrayList<Customer> listBooking = FuncWriteFileCSV.getBookingFromCSV();
        listBooking.add(customer);
        FuncWriteFileCSV.writeBookingToFileCSV(listBooking);
        System.out.println("\nAdd Booking For " + customer.getNameCustomer() + " Successfully !!!");
        displayMainMenu();
    }

    public static void addNewService() {
        int choose;
        System.out.println("1. Add New Villa" +
                "\n2. Add New House" +
                "\n3. Add New Room" +
                "\n4. Back To Menu" +
                "\n5. Exit");
        choose = scanner.nextInt();
        switch (choose) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Failed !!!!!");
                break;
        }
    }

    public static void showServices() {
        int choose;
        System.out.println("1. Show All Villa" +
                "\n2. Show All House" +
                "\n3. Show All Room" +
                "\n4. Show All Name Villa Not Duplicate" +
                "\n5. Show All Name House Not Duplicate" +
                "\n6. Show All Name Room Not Duplicate" +
                "\n7. Back To Menu" +
                "\n8. Exit");
        choose = scanner.nextInt();
        switch (choose) {
            case 1:
                showVilla();
                showServices();
                break;
            case 2:
                showHouse();
                showServices();
                break;
            case 3:
                showRoom();
                showServices();
                break;
            case 4:
                showNameVilla();
                showServices();
                break;
            case 5:
                showNameHouse();
                showServices();
                break;
            case 6:
                showNameRoom();
                showServices();
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                System.exit(0);
            default:
                System.out.println("Failed !!!!!");
                break;
        }
    }

    public static Services addService(Services object) {
        String content;
        String err;
        object.setId(UUID.randomUUID().toString().replace("-", ""));
        scanner.nextLine();
        System.out.println("Enter name service: ");
        object.setNameService(scanner.nextLine());
        while (!Validation.checkNameService(object.getNameService())) {
            System.out.println("Name Service is invalid");
            System.out.println("Enter name Service: ");
            object.setNameService(scanner.nextLine());
        }
        content = "Enter the area can use: ";
        err = "Area can use is invalid, it's must be double and area > 30m2";
        object.setAreaUsing(Validation.checkNumberDouble(content, err));
        while (object.getAreaUsing() <= 30) {
            System.out.println(err);
            object.setAreaUsing(Validation.checkNumberDouble(content, err));
        }
        content = "Enter rent cost: ";
        err = "Rent cost is invalid, it's must be double and cost > 0";
        object.setCostRenting(Validation.checkNumberDouble(content, err));
        while (object.getCostRenting() < 0) {
            System.out.println(err);
            object.setCostRenting(Validation.checkNumberDouble(content, err));
        }
        content = "Enter max of people: ";
        err = "Max of people is invalid, it's must be integer and max people between 0 and 20";
        object.setMaxPeople(Validation.checkNumberInteger(content, err));
        while (object.getMaxPeople() < 0 && object.getMaxPeople() > 20) {
            System.out.println(err);
            object.setAreaUsing(Validation.checkNumberInteger(content, err));
        }
        System.out.println("Enter type renting: ");
        object.setTypeRenting(scanner.nextLine());
        while (!Validation.checkNameService(object.getTypeRenting())) {
            System.out.println("Type renting is invalid");
            System.out.println("Enter type renting: ");
            object.setTypeRenting(scanner.nextLine());
        }
        return object;
    }

    public static void addNewVilla() {
        String content;
        String err;
        Services villa = new Villa();
        addService(villa);
        System.out.println("Standard of room: ");
        ((Villa) villa).setRoomStandard(scanner.nextLine());
        while (!Validation.checkNameService(((Villa) villa).getRoomStandard())) {
            System.out.println("Room standard is invalid");
            System.out.println("Enter room standard: ");
            ((Villa) villa).setRoomStandard(scanner.nextLine());
        }
        System.out.println("Description: ");
        ((Villa) villa).setDescription(scanner.nextLine());
        content = "Enter area pool: ";
        err = "Area pool is invalid, it's must be double and area > 30m2";
        ((Villa) villa).setAreaPool(Validation.checkNumberDouble(content, err));
        while (((Villa) villa).getAreaPool() <= 30) {
            System.out.println(err);
            ((Villa) villa).setAreaPool(Validation.checkNumberDouble(content, err));
        }
        content = "Enter number of floor: ";
        err = "Number of floor is invalid, it's must be Integer";
        ((Villa) villa).setNumberOfFloor(Validation.checkNumberInteger(content, err));
        while (((Villa) villa).getNumberOfFloor() <= 0) {
            System.out.println(err);
            ((Villa) villa).setNumberOfFloor(Validation.checkNumberInteger(content, err));
        }
        ArrayList<Villa> listVilla = FuncWriteFileCSV.getVillaFromCSV();
        listVilla.add((Villa) villa);
        FuncWriteFileCSV.funcWriteFileCSVVilla(listVilla);
        System.out.println("\nAdd Villa: " + villa.getNameService() + " Successfully!!!");
        displayMainMenu();
    }

    public static void addNewHouse() {
        String content;
        String err;
        Services house = new House();
        addService(house);
        System.out.println("Standard of room: ");
        ((House) house).setRoomStandard(scanner.nextLine());
        while (!Validation.checkNameService(((House) house).getRoomStandard())) {
            System.out.println("Room standard is invalid");
            System.out.println("Enter room standard: ");
            ((House) house).setRoomStandard(scanner.nextLine());
        }
        System.out.println("Description: ");
        ((House) house).setDescription(scanner.nextLine());
        content = "Enter number of floor: ";
        err = "Number of floor is invalid, it's must be Integer";
        ((House) house).setNumberOfFloor(Validation.checkNumberInteger(content, err));
        while (((House) house).getNumberOfFloor() <= 0) {
            System.out.println(err);
            ((House) house).setNumberOfFloor(Validation.checkNumberInteger(content, err));
        }
        ArrayList<House> listHouse = FuncWriteFileCSV.getHouseFromCSV();
        listHouse.add((House) house);
        FuncWriteFileCSV.funcWriteFileCSVHouse(listHouse);
        System.out.println("\nAdd House: " + house.getNameService() + " Successfully!!!");
        displayMainMenu();
    }

    public static void addNewRoom() {
        Services room = new Room();
        addService(room);
        System.out.println("Enter free service included: ");
        ((Room) room).setFreeServiceIncluded(scanner.nextLine());
        while (!Validation.checkFreeService(((Room) room).getFreeServiceIncluded())) {
            System.out.println("Free service included is invalid, it's must be massage, karaoke, food, drink or car");
            System.out.println("Enter free service included: ");
            ((Room) room).setFreeServiceIncluded(scanner.nextLine());
        }
        ArrayList<Room> listRoom = new ArrayList<Room>();
        listRoom.add((Room) room);
        FuncWriteFileCSV.funcWriteFileCSVRoom(listRoom);
        System.out.println("\nAdd Room: " + room.getNameService() + " Successfully!!!");
        displayMainMenu();
    }

    public static void showVilla() {
        ArrayList<Villa> listVilla = FuncWriteFileCSV.getVillaFromCSV();
        for (Villa villa : listVilla) {
            System.out.println("--------------");
            villa.showInfor();
            System.out.println("--------------");
        }
        displayMainMenu();
    }

    private static void showHouse() {
        ArrayList<House> listHouse = FuncWriteFileCSV.getHouseFromCSV();
        for (House house : listHouse) {
            System.out.println("--------------");
            house.showInfor();
            System.out.println("--------------");
        }
        displayMainMenu();
    }

    private static void showRoom() {
        ArrayList<Room> listRoom = FuncWriteFileCSV.getRoomFromCSV();
        for (Room room : listRoom) {
            System.out.println("--------------");
            room.showInfor();
            System.out.println("--------------");
        }
        displayMainMenu();
    }

    public static void showInforCustomer() {
        ArrayList<Customer> listCustomer = FuncWriteFileCSV.getCustomerFromCSV();
        Collections.sort(listCustomer);
        for (Customer customer : listCustomer) {
            System.out.println("------------------");
            System.out.println(customer.showInfor());
            System.out.println("------------------");
        }
        displayMainMenu();
    }

    public static void showNameVilla() {
        String pathVilla = "data/Villa.csv";
        Path path = Paths.get(pathVilla);
        if (!Files.exists(path)) {
            System.out.println("File Villa does not exists!");
        } else {
            TreeSet<String> listVillaTreeSet = FuncWriteFileCSV.getAllNameServiceFromCSV(pathVilla);
            System.out.println("\nList Name Service Villa Not Duplicate");
            for (String str : listVillaTreeSet) {
                System.out.println("\n---------------");
                System.out.println(str);
                System.out.println("\n---------------");
            }
        }
        scanner.nextLine();
        displayMainMenu();
    }

    public static void showNameHouse() {
        String pathHouse = "data/House.csv";
        Path path = Paths.get(pathHouse);
        if (!Files.exists(path)) {
            System.out.println("File House does not exists!");
        } else {
            TreeSet<String> listHouseTreeSet = FuncWriteFileCSV.getAllNameServiceFromCSV(pathHouse);
            System.out.println("\nList Name Service Villa Not Duplicate");
            for (String str : listHouseTreeSet) {
                System.out.println("\n---------------");
                System.out.println(str);
                System.out.println("\n---------------");
            }
        }
        scanner.nextLine();
        displayMainMenu();
    }

    public static void showNameRoom() {
        String pathRoom = "data/Room.csv";
        Path path = Paths.get(pathRoom);
        if (!Files.exists(path)) {
            System.out.println("File Room does not exists!");
        } else {
            TreeSet<String> listRoomTreeSet = FuncWriteFileCSV.getAllNameServiceFromCSV(pathRoom);
            System.out.println("\nList Name Service Villa Not Duplicate");
            for (String str : listRoomTreeSet) {
                System.out.println("\n---------------");
                System.out.println(str);
                System.out.println("\n---------------");
            }
        }
        scanner.nextLine();
        displayMainMenu();
    }

    public static void showInforEmployee(){
        Map<String, Employee> map = new HashMap<String, Employee>();
        Employee employee = new Employee("Linh",20,"Da Nang");
        Employee employee1 = new Employee("Duy",21,"Hue");
        Employee employee2 = new Employee("Nhan",22,"Quang Tri");
        Employee employee3 = new Employee("Phuong",22,"Quang Tri");
        Employee employee4 = new Employee("Quynh",22,"Quang Tri");
        Employee employee5 = new Employee("Huyen",22,"Quang Tri");
        Employee employee6 = new Employee("Chau",22,"Quang Tri");
        Employee employee7 = new Employee("Dung",22,"Quang Tri");
        Employee employee8 = new Employee("Hung",22,"Quang Tri");
        Employee employee9 = new Employee("Cuong",22,"Quang Tri");
        Employee employee10 = new Employee("Giang",22,"Quang Tri");
        map.put(getIRandomDEm(), employee);
        map.put(getIRandomDEm(), employee1);
        map.put(getIRandomDEm(), employee2);
        map.put(getIRandomDEm(), employee3);
        map.put(getIRandomDEm(), employee4);
        map.put(getIRandomDEm(), employee5);
        map.put(getIRandomDEm(), employee6);
        map.put(getIRandomDEm(), employee7);
        map.put(getIRandomDEm(), employee8);
        map.put(getIRandomDEm(), employee9);
        map.put(getIRandomDEm(), employee10);
        // show map
        for (Map.Entry<String, Employee> entry : map.entrySet()) {
            System.out.println("\n------------------------");
            System.out.println("\nId Employee: "+entry.getKey() + " " + entry.getValue());
            System.out.println("\n------------------------");
        }
    }

    public static String getIRandomDEm(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void getListCusBuyTicket(){
        Queue<Customer> customers = new LinkedList<Customer>();
        scanner.nextLine();
        ArrayList<Customer> listCustomer = FuncWriteFileCSV.getCustomerFromCSV();
        Collections.sort(listCustomer);
        int i = 1;
        for(int k = 0; k<3;k++) {
            for (Customer customer : listCustomer) {
                System.out.println("--------------");
                System.out.println("NO " + i);
                System.out.println(customer.showInfor());
                System.out.println("--------------");
                i++;
            }
            System.out.println("Choose Customer Buy Ticket:");
            Customer customer = listCustomer.get(scanner.nextInt() - 1);
            customers.add(customer);
            System.out.println("\nCustomer: " + customer.getNameCustomer() + " Buy Successfully!!!");
            i=1;
        }
        System.out.println("Dont have any ticket!!!!!!!!!!!");
        System.out.println("List of customer bought ticket: ");
        while (true) {
            Customer name = customers.poll();
            if (name == null) {
                break;
            }
            System.out.println("\n--------------");
            System.out.println(name.showInfor());
            System.out.println("\n--------------");
        }
    }
}
