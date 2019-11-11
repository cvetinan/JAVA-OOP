package entities;

import interfaces.MyList;

public class MyListImpl extends Collection implements MyList {
    private int used;

    public MyListImpl() {
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
        if (this.items.isEmpty()){
            return "";
        }

        String temp = this.items.get(0);
        this.items.remove(temp);
        return temp;
    }

    @Override
    public int getUsed() {
        return this.used = getSize();
    }
}
