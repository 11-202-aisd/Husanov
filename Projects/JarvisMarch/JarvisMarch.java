import java.util.ArrayList;
import java.util.Random;

public class JarvisMarch {
    private static final double EPS = 0.000001;

    public ArrayList<Dot> JarvisMarchAlgorithm(ArrayList<Dot> dots) {
        Dot f = dots.get(0);
        Dot s = dots.get(0);

        ArrayList<Dot> ans = new ArrayList<>();

        for(int i = 1; i < dots.size(); i++) {
            Dot dot = dots.get(i);
            if (f.getX() >= dot.getX()) {
                f = dot;
            }
        }

        ans.add(f);
        s = new Dot(f.getX(), f.getY() + EPS * 2);
        ans.add(s);


        for(int i = 0; i < dots.size(); i++) {
            f = ans.get(i);
            s = ans.get(i + 1);

            Dot third = dots.get(0);
            for (int j = 0; j < dots.size(); j++) {
                Dot dot = dots.get(j);

                if(dot.getAngle(f, s) - third.getAngle(f, s) > EPS) {
                    third = dot;
                }
            }

            if(third.equals(ans.get(0))) {
                break;
            }

            ans.add(third);
            dots.remove(third);
        }
        ans.remove(1);
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
