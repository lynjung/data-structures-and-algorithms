class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char dum = s[left];
            s[left] = s[right];
            s[right] = dum;
            left++;
            right--;
        }
    }
}