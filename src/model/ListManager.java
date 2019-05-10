package model;

public class ListManager {
    private CurrentList currentList; // has 3 items
    private CompletedList completedList; // has all completed items
    private AllDoList allDoList; //has all to do items

    public ListManager() {
        currentList = new CurrentList();
        completedList = new CompletedList();
        allDoList = new AllDoList();
    }

    public CurrentList getCurrentList (){
        return currentList;
    }

}
