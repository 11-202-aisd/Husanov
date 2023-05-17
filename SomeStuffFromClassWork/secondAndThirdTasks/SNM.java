package secondAndThirdTasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SNM {
    private ArrayList<ArrayList<Integer>> matrix;

    private ArrayList<Integer> colors;

    public SNM(int n, int[][] connections) {
        matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            matrix.get(connections[i][0]).add(connections[i][1]);
            matrix.get(connections[i][1]).add(connections[i][0]);
        }

        colors = new ArrayList<>();

        recalculateColors();
    }

    public boolean isConnected(int ver1, int ver2) {
        if(ver1 >= matrix.size() || ver2 >= matrix.size() || ver1 < 0 || ver2 < 0)throw new RuntimeException();

        return Objects.equals(colors.get(ver1), colors.get(ver2));
    }

    public void makeConnection(int ver1, int ver2) {
        matrix.get(ver1).add(ver2);
        matrix.get(ver2).add(ver1);

        recalculateColors();
    }

    private void recalculateColors() {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < matrix.size(); i++) {
            if (colors.get(i) == 0) {
                queue.add(i);
                int color = count + 1;
                while (queue.peek() != null) {
                    int verticle = queue.poll();

                    colors.add(verticle, color);

                    for (int j : matrix.get(verticle)) {
                        if (colors.get(j) == 0) {
                            colors.add(j, color);

                            queue.add(j);
                        }
                    }
                }

                count++;
            }
        }
    }
}
