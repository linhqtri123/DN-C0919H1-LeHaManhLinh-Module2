package Models;

public class Customer implements Comparable<Customer> {
    private String idCus;
    private String nameCustomer;
    private String gender;
    private String idCard;
    private int phone;
    private String mail;
    private String typeCustomer;
    private String address;
    private String birthday;
    private Services service;

    public Customer() {
    }

    public Customer(String idCus, String nameCustomer, String gender, String idCard, int phone, String mail, String typeCustomer, String address, String birthday, Services service) {
        this.idCus = idCus;
        this.nameCustomer = nameCustomer;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.mail = mail;
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.birthday = birthday;
        this.service = service;
    }

    public String getIdCus() {
        return idCus;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public String showInfor() {
        return "ID: " + getIdCus() +
                "\nName Customer: " + getNameCustomer() +
                "\nGender: " + getGender() +
                "\nId Card: " + getIdCard() +
                "\nPhone: " + getPhone() +
                "\nMail: " + getMail() +
                "\nType Customer: " + getTypeCustomer() +
                "\nAddress: " + getAddress() +
                "\nBirthday: " + getBirthday();
    }

    @Override
    public int compareTo(Customer o) {
        if (nameCustomer == o.nameCustomer)
            return 0;
        else if (nameCustomer.compareTo(o.nameCustomer) > 0)
            return 1;
        else
            return -1;
    }
}
