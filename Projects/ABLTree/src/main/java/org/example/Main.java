package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();

        Random r = new Random();

        Set<Integer> buf = new HashSet<>();

        for(int i = 0; i < 10000; i++) {
            test.add(r.nextInt());
        }
        double timeIns = 0;
        double iterIns = 0;

        ABLTree tree = new ABLTree(new Node(test.get(0)));

        for(int i = 1; i < test.size(); i++) {
            tree.insert(test.get(i));

            timeIns += tree.getTime() * 1.0 / test.size();
            iterIns += tree.getIterCount() * 1.0 / test.size();
        }

        for(int i = 0; i < 2000; i++) {
            if(buf.size() < 1000) buf.add(r.nextInt(test.size() - 1));
        }

        List<Integer> itemsDelete = new ArrayList<>();
        itemsDelete = buf.stream().toList();

        double timeFind = 0;
        double iterFind = 0;

        for(int i = 0; i < 100; i++) {
            tree.find(itemsDelete.get(i));

            timeFind += tree.getTime() * 1.0 / 100;
            iterFind += tree.getIterCount() * 1.0 / 100;
        }

        double timeDelete = 0;
        double iterDelete = 0;

        for(int i = 0; i < 1000; i++) {
            tree.remove(itemsDelete.get(i));

            timeDelete += tree.getTime() * 1.0 / 1000;
            iterDelete += tree.getIterCount() * 1.0 / 1000;
        }

        System.out.println("Insert time/iter:" + timeIns + " " + iterIns);
        System.out.println("Delete time/iter:" + timeDelete + " " + iterDelete);
        System.out.println("Find time/iter:" + timeFind + " " + iterFind);

    }
}
