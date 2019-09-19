package machine;

public class Latte implements Coffee {
    @Override
    public int getBeans() {
        return 20;
    }

    @Override
    public int getMilk() {
        return 75;
    }

    @Override
    public int getWater() {
        return 350;
    }

    @Override
    public int getPrice() {
        return 7;
    }
}
