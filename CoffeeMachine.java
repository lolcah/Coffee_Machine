package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine();
        boolean exit = false;
        while (!exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            switch (action) {
                case "buy": {
                    System.out.println("What do you want to buy 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:: ");
                    String input = scanner.next();
                    if ("back".equals(input))
                        break;
                    int type = Integer.parseInt(input);
                    Coffee coffee = machine.buy(type);
                    if (machine.checkIngridiens(coffee)) {
                        machine.makeCoffee(coffee);
                    }
                    break;
                }
                case "fill": {
                    int amount = 0;
                    System.out.println("Write how many ml of water do you want to add:");
                    amount = scanner.nextInt();
                    machine.fill("water", amount);
                    System.out.println("Write how many ml of milk do you want to add:");
                    amount = scanner.nextInt();
                    machine.fill("milk", amount);
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    amount = scanner.nextInt();
                    machine.fill("beans", amount);
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    amount = scanner.nextInt();
                    machine.fill("cups", amount);
                    break;
                }
                case "take": {
                    int amount = machine.getMoney();
                    System.out.println(String.format("I gave you %d", amount));
                    machine.take(machine.getMoney());
                    break;
                }
                case "exit": {
                    exit = true;
                    break;
                }
                case "remaining": {
                    machine.showInfo();
                }
            }
        }
    }

    public boolean checkIngridiens(Coffee coffee) {
        if (getBeans() < coffee.getBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (getWater() < coffee.getWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (getMilk() < coffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
        }
        return true;
    }

    public void showInfo() {
        System.out.println(String.format("The coffee machine has:\n%d of water\n%d of milk\n%d of coffe beans\n" +
                        "%d of disposable cups\n$%d of money"
                , getWater(), getMilk(), getBeans(), getCups(), getMoney()));

    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void makeCoffee(Coffee coffee) {
        water -= coffee.getWater();
        beans -= coffee.getBeans();
        milk -= coffee.getMilk();
        cups -= 1;
        money += coffee.getPrice();
    }

    public Coffee buy(int type) {
        Coffee coffee = null;
        switch (type) {
            case 1:
                coffee = new Espresso();
                break;
            case 2:
                coffee = new Latte();
                break;
            case 3:
                coffee = new Cappuccino();
                break;
        }
        assert coffee != null;
        return coffee;
    }

    public void fill(String type, int amount) {
        switch (type) {
            case "milk": {
                milk += amount;
                break;
            }
            case "water": {
                water += amount;
                break;
            }
            case "beans": {
                beans += amount;
                break;
            }
            case "cups": {
                cups += amount;
                break;
            }
        }
    }

    public int take(int amount) {
        money -= amount;
        return amount;
    }
}
