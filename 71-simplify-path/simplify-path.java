class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");

        for (String directory : directories) {
            if (directory.equals(".") || directory.equals("")) {
                continue;
            }
            else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(directory);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (String s : stack) {
            ans.append("/");
            ans.append(s);
        }

        return ans.length() == 0 ? "/" : ans.toString();
    }
}