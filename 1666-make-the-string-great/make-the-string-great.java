class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // in ascii, lowercase & uppercase versions of the same english letter differ by 32
            if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : stack) {
            ans.append(c);
        }

        return ans.toString();
    }
}