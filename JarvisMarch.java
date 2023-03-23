import java.util.ArrayList;
import java.util.Random;

public class JarvisMarch {
    private static final double EPS = 0.000001;
    public static class Dot {
        private double x;
        private double y;

        Dot(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getY() {
            return y;
        }

        public double getX() {
            return x;
        }

        public double getDistance(Dot to) {
            return Math.sqrt((to.x - x)*(to.x - x) + (to.y - y)*(to.y - y));
        }

        public double getAngle(Dot first, Dot second) {
            double a = first.getDistance(this);
            double b = second.getDistance(this);
            double c = first.getDistance(second);
            double cos = (b*b + c*c - a*a) / 2*b*c;
            return cos > 0 ? Math.acos(cos) : 0;
        }

        public boolean isEqual(Dot dot) {
            return x - dot.x < EPS && y - dot.y < EPS;
        }

        public String toString() {
            return x + " " + y;
        }
    }


    public ArrayList<Dot> JarvisMarchAlgorithm(ArrayList<Dot> dots) {
        Dot f = dots.get(0);
        Dot s = dots.get(0);

        ArrayList<Dot> ans = new ArrayList<>();

        for(int i = 1; i < dots.size(); i++) {
            Dot dot = dots.get(i);
            if (f.getX() >= dot.getX()) {
                if (f.getX() == dot.getX() && f.getY() > dot.getY() || f.getX() > dot.getX()) {
                    s = f;
                    f = dot;
                }
            }
        }

        ans.add(f);
        ans.add(s);

        for(int i = 0; i < ans.size() - 1; i++) {
            f = ans.get(i);
            s = ans.get(i + 1);

            Dot third = dots.get(0);
            for (int j = 0; j < dots.size(); j++) {
                Dot dot = dots.get(j);
                if(dot.equals(f) || dot.equals(s)) {
                    continue;
                }

                if(third.getAngle(f, s) < dot.getAngle(f, s)) {
                    third = dot;
                } else if (third.getAngle(f, s) - dot.getAngle(f, s) < EPS && s.getDistance(third) < s.getDistance(dot)) {
                    third = dot;
                }
            }

            if(third.equals(ans.get(0))) {
                break;
            }

            ans.add(third);
        }

        return ans;
    }

    public static ArrayList<Dot> generateTest(int count, double fieldBound) {
        ArrayList<Dot> dots = new ArrayList<>();

        Random r = new Random();

        for (int i = 0; i < count; i++) {
            dots.add(new Dot(r.nextDouble(-fieldBound, fieldBound), r.nextDouble(-fieldBound, fieldBound)));
        }

        return dots;
    }

    public static void main(String[] args) {
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
}
