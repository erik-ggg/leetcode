package medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static String largestNumber(int[] nums) {

        var asStr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(asStr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                var o1 = a + b;
                var o2 = b + a;
                return o2.compareTo(o1);
            }
        });

        if (asStr[0].equals("0")) return "0";
        var strb = new StringBuilder();
        for (String n : asStr) {
            strb.append(n);
        }
        return strb.toString();
    }
}
