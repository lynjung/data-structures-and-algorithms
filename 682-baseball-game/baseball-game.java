class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer> stack = new Stack<>();

        for (String s : operations) {
            if (s.equals("+")) {
                int top = stack.pop();
                int second = stack.peek();
                stack.push(top);
                stack.push(top + second);
            }

            else if (s.equals("D")) {
                int prev = stack.peek();
                stack.push(2 * prev);
            }

            else if (s.equals("C")) {
                stack.pop();
            }

            else {
                stack.push(Integer.parseInt(s));
            }
        }

        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        return sum;
    }
}