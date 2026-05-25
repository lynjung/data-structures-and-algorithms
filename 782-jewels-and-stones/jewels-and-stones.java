class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelset = new HashSet<>();

        for (char c : jewels.toCharArray()) {
            jewelset.add(c);
        }

        int ans = 0;
        for (char c : stones.toCharArray()) {
            if (jewelset.contains(c)) {
                ans++;
            }
        }

        return ans;
    }
}