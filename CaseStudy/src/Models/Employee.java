package Models;

public class Employee {
    private String nameEmployee;
    private int age;
    private String address;

    public Employee() {
    }

    public Employee(String nameEmployee, int age, String address) {
        this.nameEmployee = nameEmployee;
        this.age = age;
        this.address = address;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "\nName employee: "+getNameEmployee()+
                "\nAge: "+getAge()+
                "\nAddress: "+getAddress();
    }
}
