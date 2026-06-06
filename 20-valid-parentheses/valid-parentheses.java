class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> hashmap = new HashMap<>();
        hashmap.put('(', ')');
        hashmap.put('{', '}');
        hashmap.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (hashmap.containsKey(c)) { // if c is an opening bracket
                stack.push(c);
            }
            else { // if c is a closing bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                char prevOpening = stack.pop();
                if (hashmap.get(prevOpening) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}