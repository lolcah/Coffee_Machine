package machine;

public class Espresso implements Coffee {

    @Override
    public int getBeans() {
        return 16;
    }

    @Override
    public int getPrice() {
        return 4;
    }

    @Override
    public int getMilk() {
        return 0;
    }

    @Override
    public int getWater() {
        return 250;
    }
}
