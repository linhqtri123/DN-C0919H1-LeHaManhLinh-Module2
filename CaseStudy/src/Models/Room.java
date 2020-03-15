package Models;

public class Room extends Services {
    private String freeServiceIncluded;

    public Room() {

    }

    public Room(String id, String nameService, double areaUsing, double costRenting, int maxPeople, String typeRenting, String freeServiceIncluded) {
        super(id, nameService, areaUsing, costRenting, maxPeople, typeRenting);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public void showInfor() {
        System.out.println("ID: "+super.getId()+
                "\nName of service: "+super.getNameService()+
                "\nArea using: "+super.getAreaUsing()+
                "\nCost renting: "+super.getCostRenting()+
                "\nMax people: "+super.getMaxPeople()+
                "\nType renting: "+super.getTypeRenting()+
                "\nFree service included: "+getFreeServiceIncluded());
    }
}
