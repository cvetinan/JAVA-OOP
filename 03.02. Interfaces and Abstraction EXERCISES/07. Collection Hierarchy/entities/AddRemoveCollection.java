package entities;

import interfaces.AddRemovable;


public class AddRemoveCollection extends Collection implements AddRemovable {

    public AddRemoveCollection() {
    }

    @Override
    public int add(String string) {
        if (this.items.size() < maxSize) {
            this.items.add(0, string);
        }
        return 0;
    }

    @Override
    public String remove() {
        if (this.items.isEmpty()) {
            return "";
        }

        String temp = this.items.get(this.items.size() - 1);
        this.items.remove(temp);
        return temp;
    }
}
