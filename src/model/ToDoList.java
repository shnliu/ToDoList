package model;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private String name;
    private List<Item> listOfItems;

    public ToDoList() {
        this.name = name;
        listOfItems = new ArrayList<Item>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void addItem(Item item){
        this.listOfItems.add(item);
    }

    public void removeItem(Item item) {
        this.listOfItems.remove(item);
    }
}
