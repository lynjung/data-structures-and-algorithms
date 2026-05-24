class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // status -> index
        map.put(0, -1);

        int maxlength = 0;
        int status = 0;

        for (int i = 0; i < nums.length; i++) {
            status = status + (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(status)) {
                maxlength = Math.max(maxlength, i - map.get(status));
            }
            else { // store the status only if it's new- if we've seen the status before, we should only store the very first one
                map.put(status, i);
            }
        }
        return maxlength;
    }
}