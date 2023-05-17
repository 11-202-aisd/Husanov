package firstTask;

public class EasyQueue {
    private class Elem {
        int item;
        Elem next;

        public Elem(int item) {
            this.item = item;
        }
    }
    private int size;
    private Elem first;
    private Elem last;

    public void add(int item) {
        if(last == null) {
            first = new Elem(item);
            last = first;
        } else if (last == first) {
            Elem newElem = new Elem(item);
            first.next = newElem;
            last = newElem;
        } else {
            Elem newElem = new Elem(item);
            last.next = newElem;
            last = newElem;
        }

        size ++;
    }

    public int poll() {
        int item;
        if(first == null){
            throw new RuntimeException();
        } else if (last == first) {
            item = last.item;

            first = null;
            last = null;
        } else {
            item = first.item;
            first = first.next;
        }

        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public int peek() {
        int item;
        if(first == null){
            throw new RuntimeException();
        } else {
            item = first.item;
        }

        return item;
    }
}
