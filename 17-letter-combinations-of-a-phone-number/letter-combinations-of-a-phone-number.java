class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] map = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(new StringBuilder(), 0, digits, map, ans);
        return ans;
    }

    public void backtrack(StringBuilder curr, int i, String digits, String[] map, List<String> ans) {
        if (i == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        int digit = digits.charAt(i) - '0';
        String letters = map[digit];

        for (char letter : letters.toCharArray()) {
            curr.append(letter);
            backtrack(curr, i + 1, digits, map, ans);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}