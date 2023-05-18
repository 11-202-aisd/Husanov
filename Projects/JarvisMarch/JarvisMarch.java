import java.util.ArrayList;
import java.util.Random;

public class JarvisMarch {
    private static final double EPS = 0.05;


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
                if(dots.get(q).getOrientation(dots.get(p), dots.get(i)) == 2 && dots.get(i).getDistance(dots.get(q)) > EPS * EPS) {
                    q = i;
                }
            }

            p = q;
        } while (p != l && dots.get(p).getDistance(dots.get(l)) > EPS*EPS && ans.size() < dots.size());

        return ans;
    }
}
