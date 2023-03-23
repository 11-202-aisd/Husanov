import java.math.*;
import java.util.Scanner;

public class FermaAlg {

    static boolean isS(long n) {
        int d = 5;
        boolean t = true;

        for(int i = 0; i < d; i++) {
            long a = (int) (Math.random()*(n - 1) + 2);
            if(a >= n) {
                a = n - 1;
            }
            long s = 1;
            for(int j = 0; j < n - 1; j++) {
                s = s * a % n;
            }

            if(s != 1) {
                t = false;
                break;
            }
        }
        return t;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();

        while(n > 0) {
            System.out.println(n +": " + (isS(n) ? "Simple" : "Not Simple"));
            n--;
        }
    }
}
