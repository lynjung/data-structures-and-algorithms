class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr != '#') {
                stack1.push(curr);
            }
            else {
                if (!stack1.empty()) {
                    stack1.pop();
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (curr != '#') {
                stack2.push(curr);
            }
            else {
                if (!stack2.empty()) {
                    stack2.pop();
                }
            }
        }

        return stack1.equals(stack2);
    }
}