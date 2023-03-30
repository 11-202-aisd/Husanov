import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DataGetter {
    Queue<ArrayList<Dot>> tests;
    private String filePath;
    private boolean isInit = false;
    public void init(String filePath) {
        this.filePath = filePath;

        isInit = true;
        tests = new LinkedList<>();

        try {
            FileReader fr = new FileReader(filePath);

            Scanner scan = new Scanner(fr);

            while (scan.hasNext()) {
                int count = scan.nextInt();

                ArrayList<Dot> dots = new ArrayList<>();

                for (int i = 0; i < count; i++) {
                    dots.add(new Dot(scan.nextDouble(), scan.nextDouble()));
                }

                tests.add(dots);
            }
        } catch (IOException e) {
            System.out.println("File Not Found! *DataGetter exception");
        }
    }
    public ArrayList<Dot> getNextMassive() {
        if(!isInit) throw  new RuntimeException("File Not Found! *DataGetter exception");
        if(tests.size() == 0) return null;

        return tests.poll();
    }
}
