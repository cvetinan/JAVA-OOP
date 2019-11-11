package entities;

import interfaces.Addable;

public class AddCollection extends Collection implements Addable {

    public AddCollection() {
    }

    @Override
    public int add(String string) {
        String temp = string;

        if (this.items.size() < maxSize) {
            this.items.add(temp);
        }
        return this.items.indexOf(temp);
    }
}
