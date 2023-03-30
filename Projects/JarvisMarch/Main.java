import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();

        screen.init(500, 500, 0.05);

        while(!StdDraw.isKeyPressed(32)) {
            screen.update();
        }
        /*
        RandomGenerator dg = new RandomGenerator();
        dg.init("tests.txt");
        dg.generateTests(100, 10000);
         */


        /*DataGetter dt = new DataGetter();

        dt.init("tests.txt");
        ArrayList<Dot> dots = dt.getNextMassive();

        try {
            FileWriter fw = new FileWriter("countsAnDtimes.txt");
            while(dots != null) {
                double time = System.nanoTime();

                JarvisMarch jm = new JarvisMarch();

                ArrayList<Dot> a = jm.JarvisMarchAlgorithm(dots);

                fw.write((System.nanoTime() - time) + " " + (dots.size() * a.size())+ '\n');
                dots = dt.getNextMassive();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } */
    }
}
