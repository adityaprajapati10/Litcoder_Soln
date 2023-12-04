import java.util.Scanner;
public class ArrayManipulation { // Change this class name to "Main" when you on litcoder
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int queries = sc.nextInt();
        int[] array = new int[size + 1];

        for (int i = 0; i < queries; ++i) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            int value = sc.nextInt();
            array[left] += value;
            if (right + 1 <= size) {
                array[right + 1] -= value;
            }
        }

        int maxVal = array[1];
        for (int i = 2; i <= size; ++i) {
            array[i] += array[i - 1];
            maxVal = Math.max(maxVal, array[i]);
        }

        System.out.println(maxVal);
        sc.close();
    }
}
