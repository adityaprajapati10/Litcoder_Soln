import java.util.Scanner;
public class ClumsyFactorial {
    
    public static int clumsy(int N) {
        if (N <= 2) {
            return N;
        } else if (N <= 4) {
            return N + 3;
        } else {
            if ((N - 4) % 4 == 0) {
                return N + 1;
            } else if ((N - 4) % 4 <= 2) {
                return N + 2;
            } else {
                return N - 2;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        int N = sc.nextInt();
        int clumsyFactorial = clumsy(N);
        System.out.println(clumsyFactorial);

        sc.close();
    }
}