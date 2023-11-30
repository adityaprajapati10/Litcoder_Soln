import java.util.Scanner;

public class LegoBlocks {
    static final int MOD = 1000000007;
    static final int MAXN = 1000;

    public static void init(long[][] T, long[] B, long[] G) {
        T[1][0] = 1;
        for (int j = 1; j <= MAXN; j++) {
            T[1][j] = T[1][j - 1];
            if (j >= 2) T[1][j] = (T[1][j] + T[1][j - 2]) % MOD;
            if (j >= 3) T[1][j] = (T[1][j] + T[1][j - 3]) % MOD;
            if (j >= 4) T[1][j] = (T[1][j] + T[1][j - 4]) % MOD;
        }
        for (int i = 2; i <= MAXN; i++) {
            for (int j = 1; j <= MAXN; j++) {
                T[i][j] = (T[i - 1][j] * T[1][j]) % MOD;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        long[][] T = new long[MAXN + 1][MAXN + 1];
        long[] B = new long[MAXN + 1];
        long[] G = new long[MAXN + 1];

        init(T, B, G);

        B[1] = 0;
        G[1] = 1;
        for (int j = 2; j <= m; j++) {
            B[j] = 0;
            for (int k = 1; k < j; k++) {
                B[j] = (B[j] + (T[n][j - k] * G[k]) % MOD) % MOD;
            }
            G[j] = (T[n][j] + MOD - B[j]) % MOD;
        }
        System.out.println(G[m]);
        scanner.close();
    }
}