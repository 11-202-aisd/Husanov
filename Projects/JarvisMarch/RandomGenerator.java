import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class RandomGenerator {
    private Map<Integer, Integer> testsP;

    private String filePath;

    private boolean isInit = false;
    public void init(String filePath) {
        isInit = true;
        this.filePath = filePath;
    }

    public void generateTests(int maxTestsCount, int maxCountOfDotsInTest) {
        if(!isInit) throw new RuntimeException("Not initialized RandomGenerator!");

        FileWriter file = null;

        try {
            file = new FileWriter(filePath);

        } catch (IOException e) {
            System.out.println("Error, file is not found!");
        }

        Random random = new Random();

        for(int i = 0; i < maxTestsCount; i++) {
            int count = random.nextInt(maxCountOfDotsInTest);
            try {
                file.write("" + count + '\n');
            } catch (IOException e) {
                    System.out.println("Error, file is not found!");
            }
            for (int j = 0; j < count; j++) {
                double x = random.nextDouble(1);
                double y = random.nextDouble(1);
                try {
                    file.write(new DecimalFormat("#0.0##").format(x) + " " + new DecimalFormat("#0.0##").format(y) + '\n');
                } catch (IOException e) {
                    System.out.println("Error, file is not found!");
                }
            }
        }
        try{

        file.close();
        } catch (IOException e) {
            System.out.println("Error, file is not found!");
        }
    }
}
