package machine;

public class Cappuccino implements Coffee {
    @Override
    public int getBeans() {
        return 12;
    }

    @Override
    public int getMilk() {
        return 100;
    }

    @Override
    public int getWater() {
        return 200;
    }

    @Override
    public int getPrice() {
        return 6;
    }
}
