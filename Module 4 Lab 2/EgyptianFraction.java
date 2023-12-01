import java.util.Scanner;
public class EgyptianFraction {
    public static void egyptianFraction(int n, int d) {
        if (d == 0 || n == 0) {
            return;
        }
        if (d % n == 0) {
            System.out.println(d / n);
            return;
        }
        if (n % d == 0) {
            System.out.println(n / d);
            return;
        }
        if (n > d) {
            System.out.println(n / d);
            egyptianFraction(n % d, d);
            return;
        }
        int x = d / n + 1;
        System.out.println(x);
        egyptianFraction(n * x - d, d * x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numerator = sc.nextInt();
        int denominator = sc.nextInt();

        egyptianFraction(numerator, denominator);
        sc.close();
    }
}