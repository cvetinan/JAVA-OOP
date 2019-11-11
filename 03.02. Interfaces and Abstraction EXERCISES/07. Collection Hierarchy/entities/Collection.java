package entities;
import interfaces.MyList;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    protected final static int maxSize = 100;
    protected List<String> items;

    protected Collection() {
        this.items = new ArrayList<>(maxSize);
    };

    protected int getSize(){
        return this.items.size();
    }
}
