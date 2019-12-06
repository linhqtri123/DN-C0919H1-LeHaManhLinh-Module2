package HienThiKhachHang;

import java.util.*;

public class ListOfCustomer {
    private static  Map<Integer, Customer> listCustomer = new HashMap<Integer, Customer>();

    static {
        initCustomer();
    }

    private static void initCustomer(){
        Customer cus1 = new Customer(1, "Lê Hà Mạnh Linh", "16/10/1998", "Quảng Trị");
        Customer cus2 = new Customer(2, "Nguyễn Văn Thiện Duy", "1/1/1998", "Huế");
        Customer cus3 = new Customer(3, "Tô Hữu Giang", "1/1/1998", "Đà Nẵng");

        listCustomer.put(cus1.getId(), cus1);
        listCustomer.put(cus2.getId(), cus2);
        listCustomer.put(cus3.getId(), cus3);
    }

    public static Customer getCustomer(int customerId){
        return listCustomer.get(customerId);
    }

    public static List<Customer> getAllCustomer(){
        Collection<Customer> c = listCustomer.values();
        List<Customer> list = new ArrayList<Customer>();
        list.addAll(c);
        return list;
    }
}
