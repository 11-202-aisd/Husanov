// Java program to find modular
// inverse of a under modulo m
// using Fermat's little theorem.
// This program works only if m is prime.

import java.util.Scanner;

class GFG {
    static int __gcd(int a, int b)
    {

        if (b == 0) {
            return a;
        }
        else {
            return __gcd(b, a % b);
        }
    }

    // To compute x^y under modulo m
    static int power(int x, int y, int m)
    {
        if (y == 0)
            return 1;
        int p = power(x, y / 2, m) % m;
        p = (p * p) % m;

        return (y % 2 == 0) ? p : (x * p) % m;
    }

    // Function to find modular
    // inverse of a under modulo m
    // Assumption: m is prime
    static boolean modInverse(int a, int m)
    {
        if (__gcd(a, m) != 1)
            return false;
        else {
            return true;
            // If a and m are relatively prime, then
            // modulo inverse is a^(m-2) mode m

        }
    }

    // Driver code
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n > 0) {
            boolean t = true;
            for (int i = 0; i < 15; i++) {
                int a = (int) (Math.random()*(n - 1) + 2);
                if(a >= n) {
                    a = n - 1;
                }
                t = (modInverse(a, n) ? t : false);
            }
            System.out.print(n + ": ");
            if(t) {
                System.out.println("Modular multiplicative invers");
            } else {
                System.out.println("Inverse doesn't exist");
            }
            n--;
        }

    }
}

// This code is contributed by Anant Agarwal.
