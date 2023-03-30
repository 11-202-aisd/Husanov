import java.util.ArrayList;
import java.util.Random;

public class JarvisMarch {
    private static final double EPS = 0.000001;


    public ArrayList<Dot> JarvisMarchAlgorithm(ArrayList<Dot> dots) {
        int l = 0;

        ArrayList<Dot> ans = new ArrayList<>();

        for(int i = 1; i < dots.size(); i++) {
            Dot dot = dots.get(i);
            if (dots.get(l).getX() >= dot.getX()) {
                l = i;
            }
        }

        int p = l, q;
        int n = dots.size();

        do {
            ans.add(dots.get(p));

            q = (p + 1) % n;
            for(int i = 0; i < n; i++) {
                if(dots.get(q).getOrientation(dots.get(p), dots.get(i)) == 2) {
                    q = i;
                }
            }

            p = q;
        } while (p != l);

        return ans;
    }

    /*public static ArrayList<Dot> generateTest(int count, double fieldBound) {
        ArrayList<Dot> dots = new ArrayList<>();

        Random r = new Random();

        for (int i = 0; i < count; i++) {
            dots.add(new Dot(r.nextDouble(-fieldBound, fieldBound), r.nextDouble(-fieldBound, fieldBound)));
        }

        return dots;
    }
     */

    /*public static void main(String[] args) {
        Random r = new Random();

        int maxField = 100;
        int maxDotsCount = 10000;
        ArrayList<ArrayList<Dot>> tests = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            tests.add(generateTest(r.nextInt(maxDotsCount), maxField));
        }

        for(int i = 0; i < 100; i++) {
            //...
        }
    }
     */

}
