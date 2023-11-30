import java.util.*;
public class SumWithUnits {
    public static int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        for (int i = 1; i <= num; i++) {
            int t = num - k * i;
            if (t >= 0 && t % 10 == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            if (sc.hasNextInt()) {
                int k = sc.nextInt();

                int result = minimumNumbers(num, k);
                if (result == -1) {
                    System.out.println("-1");
                } else {
                    System.out.println(result);
                }
            } else {
                System.out.println("-1");
            }
        } else {
            System.out.println("-1");
        }
        sc.close();
    }
}