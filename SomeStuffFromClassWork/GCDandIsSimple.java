public class GCDandIsSimple {
    public static boolean isSimple(int a) {
        for (int i = 2; i <= Math.sqrt(a) + 1; i++) {
            if (a % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int ans1(int[] a, int k) {
        int c = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (isSimple(a[i])) {
                c++;
            }
            if (c == k) {
                return a[i];
            }
        }
        return 0;
    }

    public static int GCD(int a, int b) {
        if (a < b) {
            int c = a;
            a = b;
            b = c;
        }

        if (b == 0) {
            return  a;
        }

        return GCD(b, a%b);
    }

    public static void main(String[] args) {
        System.out.println(GCD(1,1));
    }
}
