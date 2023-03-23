import java.util.ArrayList;
import java.util.Queue;
class Solution {
    public int makeConnected(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int[] colors = new int[n];
        for(int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
        }
        int lll = 0;
        for(int i = 0; i < connections.length; i++) {
            matrix.get(connections[i][0]).add(connections[i][1]);
            matrix.get(connections[i][1]).add(connections[i][0]);
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(colors[i] == 0) {
                queue.add(i);
                int color = count + 1;
                while(queue.peek() != null) {
                    int verticle = queue.poll();

                    colors[verticle] = color;

                    for(int j : matrix.get(verticle)) {
                        if(colors[j] == 0) {
                            colors[j] = color;

                            queue.add(j);
                        }
                    }
                }

                count++;
            }
        }

        if(connections.length >= n - 1) {
            return count - 1;
        } else {
            return -1;
        }
    }