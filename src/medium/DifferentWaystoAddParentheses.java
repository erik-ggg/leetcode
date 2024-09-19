package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferentWaystoAddParentheses {

    static Set<Character> op = new HashSet<>() {{
        add('+');
        add('-');
        add('*');
        add('/');
    }};

    public static List<Integer> diffWaysToCompute(String expression) {

        return diffWaysToComputeAux(expression);
    }

    /// The exercise header says that you to have all the parentheses possibles but that's a trick.
    ///
    /// The problem is a divide and conquer. First we iterate through the expression and whenever we find
    /// an operator, we just split in half the expression, so we end with a left expression and a right expression.
    ///
    /// For the example (2-1-1) in the first split.
    /// ```java
    /// var left = subExpression.substring(0, i);
    /// var right = subExpression.substring(i + 1);
    /// ```
    /// Which produces 2 and 1-1. However, there is another combination possible which is 2-1 and 1. We will achieve both
    /// combinations thanks to the main loop.
    /// Both left and right subExpressions will be evaluated and stored in int arrays.
    ///
    /// If the `subExpression` is just one number, it will be returned.
    /// If is a direct expression like `2-1` it will be solved.
    /// In other cases, the expression will be split in half and the above possibilities will happen again.
    ///
    /// At the end of a possible combination, we have to iterate through the left and right results. The operator
    /// applied to this expression will be the one who started the recursion.
    ///
    private static ArrayList<Integer> diffWaysToComputeAux(String subExpression) {

        var r = new ArrayList<Integer>();
        for (int i = 0; i < subExpression.length(); i++) {
            var c = subExpression.charAt(i);
            if (op.contains(c)) {
                var left = subExpression.substring(0, i);
                var right = subExpression.substring(i + 1);
                var lres = diffWaysToComputeAux(left);
                var rres = diffWaysToComputeAux(right);

                for (int laux : lres) {
                    for (int raux : rres) {
                        switch (c) {
                            case '-' -> r.add(laux - raux);
                            case '+' -> r.add(laux + raux);
                            case '*' -> r.add(laux * raux);
                            case '/' -> r.add(laux / raux);
                        }
                    }
                }
            }
        }
        if (r.isEmpty()) {
            r.add(Integer.parseInt(subExpression));
        }
        return r;
    }
}
