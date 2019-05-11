package model;

public class Item {
    String name; // is basically the content
    int uuid; // an unique id

    public Item(String n){
        this.name = n;
    }

    public String getName(){
        return this.name;
    }

    // https://www.mkyong.com/java/java-how-to-overrides-equals-and-hashcode/

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Item)) {
            return false;
        }

        Item item = (Item) o;

        return item.name.equals(name); // !!
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        return result;
    }
}