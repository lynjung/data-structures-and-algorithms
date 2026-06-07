class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.append(c);
            }
            else if (stack.length() > 0) {
                stack.deleteCharAt(stack.length() - 1);
            }
        }
        return stack.toString();
    }
}