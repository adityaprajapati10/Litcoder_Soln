import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SubseqMaximizer {
    public static long maximumSubsequenceCount(String text, String pattern) {
        long res = 0, cnt1 = 0, cnt2 = 0;
        for (char c : text.toCharArray()) {
            if (c == pattern.charAt(1)) {
                res += cnt1;
                cnt2++;
            }
            if (c == pattern.charAt(0)) {
                cnt1++;
            }
        }
        return res + Math.max(cnt1, cnt2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.next();
        String pattern = scanner.next();

        long result = maximumSubsequenceCount(text, pattern);
        System.out.println(result);
        scanner.close();
    }
}