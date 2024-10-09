import java.util.*;
public class SetA<Item> {
    /* INSTANCE VARIABLES */
    private LinkedList<Item>[] table;
    private int size, cap;              // tracks logical size vs capacity (number of "buckets")
    private int code;                   // hashcode for the entire set (sum of all codes)


    /* CONSTRUCTORS */
    public SetA(int c) {
        cap = c;
        size = 0;
        code = 0;
        table = new LinkedList[cap];
        for (int i = 0; i < cap; i++) {
            table[i] = new LinkedList<Item>();
        }
    }

    public SetA() { this(11); }


    /* SET METHODS */
    public boolean isEmpty() { return size == 0;}

    public int size() { return size; }

    public boolean add(Item element) {                      // adds element to the table, returns whether the item has been sucessfully added
        if (this.contains(element)) { return false; }       // sets can't have identical elements

        int spot = element.hashCode() % cap;                
        code += element.hashCode();
        size++;
        
        return table[spot].add(element);
    }

    public boolean contains(Item element) {
        int spot = element.hashCode() % code;
        return table[spot].contains(element);               // using LinkedList.contains(), not SetA.contains()
    }

    public void clear() {
        for (int i = 0; i < cap; i++) { table[i].clear(); }
        size = 0;
        cap = 0;
    }

    public boolean remove(Item element) {
        int spot = element.hashCode() % cap;
        if (table[spot].remove(element)) {
            size--;
            code -= element.hashCode();
            return true;
        }

        return false;
    }

    public boolean equals(SetA s) {
        return this.code == s.code;
    }
}
