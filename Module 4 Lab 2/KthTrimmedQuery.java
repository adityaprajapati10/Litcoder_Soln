import java.util.*;
class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}


class Solution {
    public List<Integer> smallestTrimmedNumbers(List<String> nums, List<int[]> queries) {
        List<Integer> res = new ArrayList<>();
        for (int[] x : queries) {
            PriorityQueue<Pair<String, Integer>> v = new PriorityQueue<>((a, b) -> b.getKey().compareTo(a.getKey()));
            for (int i = 0; i < nums.size(); i++) {
                int t = nums.get(i).length() - x[1];
                String p = nums.get(i).substring(t, t + x[1]);
                if (v.size() < x[0]) {
                    v.add(new Pair<>(p, i));
                } else {
                    if (v.peek().getKey().compareTo(p) > 0) {
                        v.poll();
                        v.add(new Pair<>(p, i));
                    }
                }
            }
            int val = Objects.requireNonNull(v.poll()).getValue();
            res.add(val);
        }
        return res;
    }
}

public class KthTrimmedQuery {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        List<String> nums = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        int q = scanner.nextInt();
        List<int[]> queries = new ArrayList<>();
        for (int i = 0; i < q; ++i) {
            queries.add(new int[]{scanner.nextInt(), scanner.nextInt()});
        }

        List<Integer> result = solution.smallestTrimmedNumbers(nums, queries);

        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
        scanner.close();
    }
}
