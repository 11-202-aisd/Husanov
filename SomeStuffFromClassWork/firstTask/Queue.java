package firstTask;

public class Queue {
    private Stack buffer;
    private Stack out;

    public Queue() {
        buffer = new Stack();
        out = new Stack();
    }

    public void add(int item) {
        buffer.add(item);
    }

    public int poll() {
        if(out.size() <= 0) {
            while(buffer.size() > 0) {
                out.add(buffer.poll());
            }
        }

        return out.poll();
    }

    public int size() {
        return out.size() + buffer.size();
    }

    public int peek() {
        int item = poll();
        out.add(item);

        return item;
    }
}
