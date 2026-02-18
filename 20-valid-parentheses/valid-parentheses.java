class Solution {
    public boolean isValid(String s) {
        
        HashMap<Character, Character> hashmap = new HashMap<>();

        hashmap.put('(', ')');
        hashmap.put('{', '}');
        hashmap.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (hashmap.containsKey(c)) {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (hashmap.get(top) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}