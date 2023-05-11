package org.example;

public class ABLTree {
    private Node root;
    private int iterCount;
    private long time;


    public ABLTree(Node root) {
        this.root = root;
        iterCount = 0;
    }

    private int height(Node p)
    {
        return p != null ? p.getHeight():0;
    }

    private int bfactor(Node p)
    {
        return height(p.getRight())-height(p.getLeft());
    }

    private void fixheight(Node p)
    {
        int hl = height(p.getLeft());
        int hr = height(p.getRight());
        p.setHeight((hl > hr?hl : hr)+1);
    }

    private Node rotateRight(Node p)
    {
        Node q = p.getLeft();
        p.setLeft(q.getRight());
        q.setRight(p);

        fixheight(p);
        fixheight(q);

        return q;
    }

    private Node rotateLeft(Node q)
    {
        Node p = q.getRight();
        q.setRight(p.getLeft());
        p.setLeft(q);

        fixheight(q);
        fixheight(p);

        return p;
    }

    private Node balance(Node p)
    {
        fixheight(p);
        if(bfactor(p)== 2) {
            if(bfactor(p.getRight()) < 0 )
                p.setRight(rotateRight(p.getRight()));
            return rotateLeft(p);
        }
        if(bfactor(p)== -2) {
            if(bfactor(p.getLeft()) > 0  )
                p.setLeft( rotateLeft(p.getLeft()));
            return rotateRight(p);
        }
        return p;
    }
    public void insert(int k) {
        iterCount = 0;
        time = System.currentTimeMillis();
        insert(root, k);

        time = System.currentTimeMillis() - time;
    }

    private Node insert(Node p, int k)
    {
        iterCount ++;
        if(p == null) return new Node(k);
        if(k < p.getKey())
            p.setLeft(insert(p.getLeft(),k));
        else
            p.setRight(insert(p.getRight(),k));
        return balance(p);
    }

    private Node findMin(Node p)
    {
        iterCount ++;
        return p.getLeft() != null ? findMin(p.getLeft()) : p;
    }

    private Node removeMin(Node p)
    {
        iterCount ++;
        if(p.getLeft() == null)
            return p.getRight();
        p.setLeft(removeMin(p.getLeft()));
        return balance(p);
    }
    public void remove(int k) {
        iterCount = 0;
        time = System.currentTimeMillis();
        remove(root, k);
        time = System.currentTimeMillis() - time;
    }

    private Node remove(Node p, int k) {
        iterCount ++;
        if (p == null) return null;
        if (k < p.getKey())
            p.setLeft(remove(p.getLeft(), k));
        else if (k > p.getKey()) {
            p.setRight(remove(p.getRight(), k));
        }
        else {
            Node q = p.getLeft();
            Node r = p.getRight();
            if (r == null) return q;
            Node min = findMin(r);
            min.setRight(removeMin(r));
            min.setLeft(q);
            return balance(min);
        }
        return balance(p);
    }

    public Node find(int key) {
        iterCount = 0;
        time = System.currentTimeMillis();
        Node c = find(key, root);

        time = System.currentTimeMillis() - time;

        return c;
    }

    private Node find(int key, Node r) {
        iterCount ++;

        if(r == null) return null;

        if(r.getKey() > key) {
            return find(key, r.getLeft());
        } else if (r.getKey() < key) {
            return find(key, r.getRight());
        } else {
            return r;
        }
    }

    public int getIterCount() {
        return iterCount;
    }

    public long getTime() {
        return time;
    }
}
