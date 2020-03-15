package Models;

public abstract class Services {
    private String id;
    private String nameService;
    private double areaUsing;
    private double costRenting;
    private int maxPeople;
    private String typeRenting;

    public Services(){

    }

    public Services(String id, String nameService, double areaUsing, double costRenting, int maxPeople, String typeRenting){
        this.id = id;
        this.nameService = nameService;
        this.areaUsing = areaUsing;
        this.costRenting = costRenting;
        this.maxPeople = maxPeople;
        this.typeRenting = typeRenting;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUsing() {
        return areaUsing;
    }

    public void setAreaUsing(double areaUsing) {
        this.areaUsing = areaUsing;
    }

    public double getCostRenting() {
        return costRenting;
    }

    public void setCostRenting(double costRenting) {
        this.costRenting = costRenting;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeRenting() {
        return typeRenting;
    }

    public void setTypeRenting(String typeRenting) {
        this.typeRenting = typeRenting;
    }

    public abstract void showInfor();

}
