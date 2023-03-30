package Customer;

public class Goods {
    private String id;
    private String lv3;
    private String lv2;
    private String lv1;
    private String name;
    private double unitPrice;
    private int stocks;

    public Goods(String id, String lv3, String lv2, String lv1, String name, double unitPrice, int stocks) {
        this.id = id;
        this.lv3 = lv3;
        this.lv2 = lv2;
        this.lv1 = lv1;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stocks = stocks;
    }

    public String getId() {
        return id;
    }

    public String getLv3() {
        return lv3;
    }

    public String getLv2() {
        return lv2;
    }

    public String getLv1() {
        return lv1;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getStocks() {
        return stocks;
    }
}
