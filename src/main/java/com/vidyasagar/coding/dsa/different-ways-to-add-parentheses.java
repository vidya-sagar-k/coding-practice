// https://leetcode.com/problems/different-ways-to-add-parentheses/
class Solution {
    public List<Integer> diffWaysToCompute(String expr) {
        boolean isNumber = true;
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i<expr.length(); i++) {
            if (Character.isDigit(expr.charAt(i))) {
                continue;
            }
            isNumber = false;
            List<Integer> left = diffWaysToCompute(expr.substring(0, i));

            List<Integer> right = diffWaysToCompute(expr.substring(i+1));

            for (Integer x : left) {
                for (Integer y : right) {
                    int val = perform(x,y,expr.charAt(i));
                    results.add(val);
                }
            }
        }
        if (isNumber) results.add(Integer.valueOf(expr));

        return results;
    }

    private int perform(int x, int y, char op) {
        if (op == '+') return x + y;
        else if (op == '-') return x - y;
        else if (op == '*') return x * y;
        return x / y;
    }
}
