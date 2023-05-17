package fourth;

import firstTask.EasyQueue;

public class BinarySearchTree {
    private class Elem {
        int item;
        Elem left;
        Elem right;

        public Elem(int item) {
            this.item = item;
        }
    }
    private int size;
    private Elem head;

    public BinarySearchTree() {}

    public void add(int item) {
        if(head == null) {
            head = new Elem(item);
        } else {
            Elem iter = head;
            while(iter != null) {
                if(iter.item > item) {
                    if(iter.left == null) {
                        iter.left = new Elem(item);
                        break;
                    } else {
                        iter = iter.left;
                    }
                } else {
                    if(iter.right == null) {
                        iter.right = new Elem(item);
                        break;
                    } else {
                        iter = iter.right;
                    }
                }
            }
        }
        size ++;
    }

    public boolean contains(int item) {
        if(head == null) throw new RuntimeException();

        Elem iter = head;
        while(iter != null) {
            if(iter.item > item) {
                if(iter.left == null) {
                    return false;
                } else {
                    iter = iter.left;
                }
            } else {
                if(iter.item == item) return true;
                if(iter.right == null) {
                    return false;
                } else {
                    iter = iter.right;
                }
            }
        }

        return false;
    }

    public void remove(int k) {
        remove(head, k);
    }

    private Elem remove(Elem p, int k) {
        if (p == null) return null;
        if (k < p.item)
            p.left = (remove(p.left, k));
        else if (k > p.item) {
            p.right = (remove(p.right, k));
        }
        else {
            Elem q = p.left;
            Elem r = p.right;
            if(q == null && r == null) {
                return null;
            }
            if (r == null) return q;
            if (q == null) return r;
            Elem min = findMin(r);
            min.right = r;
            min.left = remove(p, min.item);
            return min;
        }
        return p;
    }

    private Elem findMin(Elem p)
    {
        return p.left != null ? findMin(p.left) : p;
    }

}
