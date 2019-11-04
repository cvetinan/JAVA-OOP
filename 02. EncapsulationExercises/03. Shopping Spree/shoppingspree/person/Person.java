package shoppingspree.person;

import shoppingspree.product.Product;

import java.util.ArrayList;
import java.util.List;

import static validator.Validator.*;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        double price = product.getCost();
        haveEnoughMoney(this.getName(), this.getMoney(), product, price);
        this.products.add(product);
        this.setMoney(this.getMoney() - price);
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void setMoney(double money) {
        validateValue(money);
        this.money = money;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s - ", this.getName()));
        if (this.products.isEmpty()){
            output.append("Nothing bought");
            output.append(System.lineSeparator());
        } else {
            products.forEach(product -> output.append(product).append(", "));
            output.append(System.lineSeparator());
            output.deleteCharAt(output.length() - 2);
            output.append(System.lineSeparator());
        }
        return output.toString();
    }
}
