import java.util.*;

public class QuantumNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(transform(n));
    }

    static int transform(int n) {
        int res = 1;
        int pos = 1;

        while (n > 0) {
            int d = n % 10;

            res ^= (factorial(d) + (int)Math.pow(d, pos));

            n /= 10;
            pos++;
        }

        return twist(res);
    }

    static int factorial(int x) {
        int f = 1;
        for (int i = 1; i <= x; i++) f *= i;
        return f;
    }

    static int twist(int x) {
        return (x << 2) | (x >> 2);
    }
}
