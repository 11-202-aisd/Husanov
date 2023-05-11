package org.example;

public class Node {
    private int key;
    private int height;
    private Node left;
    private Node right;
    public Node(int k) { key = k; left = right = null; height = 1; }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getHeight() {
        return height;
    }

    public int getKey() {
        return key;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
