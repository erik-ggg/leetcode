package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {

        if(s.length() == 1) return false;

        var op = new HashSet<>() {{
            add('(');
            add('[');
            add('{');
        }};
        var vp = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        var os = new Stack<>();

        for (char c : s.toCharArray()) {
            if (op.contains(c)) os.add(c);
            else {
                if (os.isEmpty() || !vp.get(os.pop()).equals(c)) return false;
            }
        }
        return os.isEmpty();
    }
}
