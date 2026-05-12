class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1; 

        while (left < right) {
            char letter1 = s[left];
            char letter2 = s[right];

            s[left] = letter2;
            s[right] = letter1;

            left++;
            right--;
        }
        return;
    }
}