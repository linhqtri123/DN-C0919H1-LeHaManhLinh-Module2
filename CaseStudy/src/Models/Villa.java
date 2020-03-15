package Models;

public class Villa extends Services {
    private String roomStandard;
    private String description;
    private double areaPool;
    private int numberOfFloor;

    public Villa(){

    }

    public Villa(String id, String nameService, double areaUsing, double costRenting, int maxPeople, String typeRenting, String roomStandard, String description, double areaPool, int numberOfFloor) {
        super(id, nameService, areaUsing, costRenting, maxPeople, typeRenting);
        this.roomStandard = roomStandard;
        this.description = description;
        this.areaPool = areaPool;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public void showInfor() {
        System.out.println("ID: "+super.getId()+
                "\nName of service: "+super.getNameService()+
                "\nArea using: "+super.getAreaUsing()+
                "\nCost renting: "+super.getCostRenting()+
                "\nMax people: "+super.getMaxPeople()+
                "\nType renting: "+super.getTypeRenting()+
                "\nRoom standard: "+getRoomStandard()+
                "\nDescription: "+getDescription()+
                "\nArea of pool: "+getAreaPool()+
                "\nNumber of floor: "+getNumberOfFloor());
    }
}
