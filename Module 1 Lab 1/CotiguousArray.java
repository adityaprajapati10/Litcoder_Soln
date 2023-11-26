import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
                        
public class CotiguousArray {  // Change this class name to "Main" when you on litcoder
    public static int findMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxLen = 0;
        int presum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) nums[i] = -1;
        }
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i = 0 ; i < nums.length ; i++){
            presum += nums[i];

            if (map.containsKey(presum)) {
                int idx = map.get(presum);
                int currLen = i - idx;
                maxLen = Math.max(maxLen, currLen);
            } else {
                map.put(presum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] numsStr = input.split("\\s+");
        int[] nums = new int[numsStr.length];

        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        int result = findMaxLength(nums);
        System.out.println(result);
        sc.close();
    }
}
