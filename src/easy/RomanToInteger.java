package easy;

import java.util.HashMap;

public class RomanToInteger {

    static HashMap<Character, Integer> romanNumbers = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {

        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            num = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> num;
            };
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }
}
