import java.util.*;

public class SlidingSubarray {

    public static List<Integer> slidingSubarrayBeauty(List<Integer> arr, int k, int n) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.size(); ++i) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr.get(dq.peekLast()) > arr.get(i)) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= k - 1) {
                int index = dq.peekFirst() + n - 1;
                if (index < arr.size()) {
                    result.add(arr.get(index));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Scanner ss = new Scanner(input);
        List<Integer> arr = new ArrayList<>();
        while (ss.hasNextInt()) {
            arr.add(ss.nextInt());
        }

        int k = sc.nextInt();
        int n = sc.nextInt();

        List<Integer> result = slidingSubarrayBeauty(arr, k, n);

        for (int i = 0; i < result.size(); ++i) {
            System.out.print(result.get(i) + " ");
        }

        System.out.println();

        sc.close();
        ss.close();
    }
}
