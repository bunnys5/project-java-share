package AdminGood;

public class upgoods {
    public String id;
    public String lv3;
    public String lv2;
    public String lv1;
    public String nameup;
    public int Priceup;
    public int stocksup;
    
    public upgoods(String id, String nameup, int Priceup, int stocksup) {
        this.id = id;
//        this.lv3 = lv3;
//        this.lv2 = lv2;
//        this.lv1 = lv1;
        this.nameup = nameup;
        this.Priceup = Priceup;
        this.stocksup = stocksup;
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
        return nameup;
    }

    public int getUnitPrice() {
        return Priceup;
    }

    public int getStocks() {
        return stocksup;
    }
}
