package Commons;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import Models.Customer;
import Models.House;
import Models.Villa;
import Models.Room;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class FuncWriteFileCSV {
    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';
    private static final int NUM_OF_LINE_SKIP = 1;
    private static final String csvVilla = "data/Villa.csv";
    private static final String csvHouse = "data/House.csv";
    private static final String csvRoom = "data/Room.csv";
    private static final String csvCustomer = "data/Customer.csv";
    private static final String csvBooking = "data/Booking.csv";
    private static String[] headerRecordVilla = new String[]{"id", "nameService", "areaUsing", "costRenting", "maxPeople", "typeRenting", "roomStandard", "description", "areaPool", "numberOfFloor"};
    private static String[] headerRecordHouse = new String[]{"id", "nameService", "areaUsing", "costRenting", "maxPeople", "typeRenting", "roomStandard", "description", "numberOfFloor"};
    private static String[] headerRecordRoom = new String[]{"id", "nameService", "areaUsing", "costRenting", "maxPeople", "typeRenting", "freeServiceIncluded"};
    private static String[] headerRecordCustomer = new String[]{"idCus", "nameCustomer", "gender", "idCard", "phone", "mail", "typeCustomer", "address", "birthday"};
    private static String[] headerRecordBooking = new String[]{"idCus", "nameCustomer", "gender", "idCard", "phone", "mail", "typeCustomer", "address", "birthday", "id", "nameService", "areaUsed", "rentalCosts", "maxNumberOfPeople", "typeRent"};

    public static void writeCustomerToFileCSV(ArrayList<Customer> arrayList){
        try(Writer writer = new FileWriter(csvCustomer);
            CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END))
        { csvWriter.writeNext(headerRecordCustomer);
            for (Customer customer: arrayList){
                csvWriter.writeNext(new String[]{
                        customer.getIdCus(), customer.getNameCustomer(),
                        customer.getGender(),
                        String.valueOf(customer.getIdCard()),
                        String.valueOf(customer.getPhone()),
                        customer.getMail(), customer.getTypeCustomer(), customer.getAddress(),
                        customer.getBirthday()});
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void funcWriteFileCSVVilla(ArrayList<Villa> arrayList) {
        try (Writer writer = new FileWriter(csvVilla);
             CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(headerRecordVilla);
            for (Villa villa : arrayList) {
                csvWriter.writeNext(new String[]{
                        villa.getId(), villa.getNameService(),
                        String.valueOf(villa.getAreaUsing()),
                        String.valueOf(villa.getCostRenting()),
                        String.valueOf(villa.getMaxPeople()),
                        villa.getTypeRenting(), villa.getRoomStandard(), villa.getDescription(),
                        String.valueOf(villa.getAreaPool()),
                        String.valueOf(villa.getNumberOfFloor())});
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void funcWriteFileCSVHouse(ArrayList<House> arrayList) {
        try (Writer writer = new FileWriter(csvHouse);
             CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(headerRecordHouse);
            for (House house : arrayList) {
                csvWriter.writeNext(new String[]{
                        house.getId(), house.getNameService(),
                        String.valueOf(house.getAreaUsing()),
                        String.valueOf(house.getCostRenting()),
                        String.valueOf(house.getMaxPeople()),
                        house.getTypeRenting(), house.getRoomStandard(),
                        house.getDescription(),
                        String.valueOf(house.getNumberOfFloor())});
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void funcWriteFileCSVRoom(ArrayList<Room> arrayList) {
        try (Writer writer = new FileWriter(csvRoom);
             CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(headerRecordRoom);
            for (Room room : arrayList) {
                csvWriter.writeNext(new String[]{
                        room.getId(), room.getNameService(),
                        String.valueOf(room.getAreaUsing()),
                        String.valueOf(room.getCostRenting()),
                        String.valueOf(room.getMaxPeople()),
                        room.getTypeRenting(),
                        room.getFreeServiceIncluded()});
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeBookingToFileCSV(ArrayList<Customer> arrayList){
        try (Writer writer = new FileWriter(csvBooking);
             CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(headerRecordBooking);
            for (Customer customer : arrayList) {
                csvWriter.writeNext(new String[]{
                        customer.getIdCus(), customer.getNameCustomer(),
                        customer.getGender(),
                        String.valueOf(customer.getIdCard()),
                        String.valueOf(customer.getPhone()),
                        customer.getMail(), customer.getTypeCustomer(), customer.getAddress(),
                        customer.getBirthday(),
                        customer.getService().getId(), customer.getService().getNameService(), String.valueOf(customer.getService().getAreaUsing()),
                        String.valueOf(customer.getService().getCostRenting()), String.valueOf(customer.getService().getMaxPeople()), customer.getService().getTypeRenting()});
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Villa> getVillaFromCSV(){
        Path path = Paths.get(csvVilla);
        if(!Files.exists(path)){
            try{
                Writer writer = new FileWriter(csvVilla);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Villa> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Villa.class);
        strategy.setColumnMapping(headerRecordVilla);
        CsvToBean<Villa> csvToBean = null;
        try{
            csvToBean = new CsvToBeanBuilder<Villa>(new FileReader(csvVilla)).withMappingStrategy(strategy).withSeparator(DEFAULT_SEPARATOR).withQuoteChar(DEFAULT_QUOTE).withSkipLines(NUM_OF_LINE_SKIP).withIgnoreLeadingWhiteSpace(true).build();
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return (ArrayList<Villa>) csvToBean.parse();
    }

    public static ArrayList<House> getHouseFromCSV(){
        Path path = Paths.get(csvHouse);
        if(!Files.exists(path)){
            try{
                Writer writer = new FileWriter(csvHouse);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        ColumnPositionMappingStrategy<House> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(House.class);
        strategy.setColumnMapping(headerRecordHouse);
        CsvToBean<House> csvToBean = null;
        try{
            csvToBean = new CsvToBeanBuilder<House>(new FileReader(csvHouse)).withMappingStrategy(strategy).withSeparator(DEFAULT_SEPARATOR).withQuoteChar(DEFAULT_QUOTE).withSkipLines(NUM_OF_LINE_SKIP).withIgnoreLeadingWhiteSpace(true).build();
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return (ArrayList<House>) csvToBean.parse();
    }

    public static ArrayList<Room> getRoomFromCSV(){
        Path path = Paths.get(csvRoom);
        if(!Files.exists(path)){
            try{
                Writer writer = new FileWriter(csvRoom);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Room> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Room.class);
        strategy.setColumnMapping(headerRecordRoom);
        CsvToBean<Room> csvToBean = null;
        try{
            csvToBean = new CsvToBeanBuilder<Room>(new FileReader(csvRoom)).withMappingStrategy(strategy).withSeparator(DEFAULT_SEPARATOR).withQuoteChar(DEFAULT_QUOTE).withSkipLines(NUM_OF_LINE_SKIP).withIgnoreLeadingWhiteSpace(true).build();
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return (ArrayList<Room>) csvToBean.parse();
    }

    public static ArrayList<Customer> getCustomerFromCSV() {
        Path path = Paths.get(csvCustomer);
        if(!Files.exists(path)){
            try{
                Writer writer = new FileWriter(csvCustomer);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Customer> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Customer.class);
        strategy.setColumnMapping(headerRecordCustomer);
        CsvToBean<Customer> csvToBean = null;
        try{
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader(csvCustomer)).withMappingStrategy(strategy).withSeparator(DEFAULT_SEPARATOR).withQuoteChar(DEFAULT_QUOTE).withSkipLines(NUM_OF_LINE_SKIP).withIgnoreLeadingWhiteSpace(true).build();
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return (ArrayList<Customer>) csvToBean.parse();
    }

    public static ArrayList<Customer> getBookingFromCSV(){
        Path path = Paths.get(csvBooking);
        if(!Files.exists(path)){
            try{
                Writer writer = new FileWriter(csvBooking);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Customer> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Customer.class);
        strategy.setColumnMapping(headerRecordBooking);
        CsvToBean<Customer> csvToBean = null;
        try{
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader(csvBooking)).withMappingStrategy(strategy).withSeparator(DEFAULT_SEPARATOR).withQuoteChar(DEFAULT_QUOTE).withSkipLines(NUM_OF_LINE_SKIP).withIgnoreLeadingWhiteSpace(true).build();
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return (ArrayList<Customer>) csvToBean.parse();
    }

    public static TreeSet<String> getAllNameServiceFromCSV(String path){
        BufferedReader br =  null;
        TreeSet<String> result = new TreeSet<String>();
        try{
            String line;
            br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            while(line != null){
                line = br.readLine();
                if(getNameServicesFromFile(line).equals("nameService")){
                    continue;
                }
                result.add(getNameServicesFromFile(line));
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static String getNameServicesFromFile(String csvLine){
        String name = "";
        if(csvLine != null){
            String[] splitData = csvLine.split(",");
            name = splitData[1];
        }
        return name;
    }
}
