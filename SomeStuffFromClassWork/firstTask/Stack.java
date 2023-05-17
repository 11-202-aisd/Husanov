package firstTask;

import java.util.ArrayList;

public class Stack {
    private int pointer;

    private ArrayList<Integer> items;

    public Stack() {
        pointer = -1;
        items = new ArrayList<>();
    }

    public void add(int item) {
        pointer ++;
        items.add(pointer, item);
    }

    public int poll() {
        pointer --;
        return items.get(pointer + 1);
    }

    public int size() {
        return pointer + 1;
    }
}
