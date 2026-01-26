class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashmap = new HashMap<>();

        hashmap.put('(', ')');
        hashmap.put('{', '}');
        hashmap.put('[', ']');

        for (char c : s.toCharArray()) {
            if (hashmap.containsKey(c)) {
                stack.push(c);
            }

            else {
                if (stack.empty()) {
                    return false;
                }
                char recent = stack.pop();
                if (hashmap.get(recent) != c) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}