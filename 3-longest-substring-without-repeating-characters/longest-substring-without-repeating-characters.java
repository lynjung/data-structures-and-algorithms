class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c) && map.get(c) >= left) { // if we've seen char before but in the current window,
                left = map.get(c) + 1; // shift the left pointer to index + 1 (getting rid of it)
            }

            ans = Math.max(ans, right - left + 1);
            map.put(c, right);
        }
        return ans;
    }
}