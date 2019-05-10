package model;

import java.util.ArrayList;
import java.util.List;

public abstract class ToDoList {
    private List<Item> listOfItems;

    public ToDoList() {
        listOfItems = new ArrayList<Item>();
    }

    public void addItem(Item item){
        if (!listOfItems.contains(item)){
            this.listOfItems.add(item);
        }
    }

    public void removeItem(Item item) {
            listOfItems.remove(item);
    }

    public List<Item> getLOI(){
        return listOfItems;
    }

}
