class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        String letters = s.toLowerCase();

        while(left < right) {
            char front = letters.charAt(left);
            char back = letters.charAt(right);
            while (left < right && !Character.isLetterOrDigit(front)) {
                left++;
                front = letters.charAt(left);
            }
            while (left < right && !Character.isLetterOrDigit(back)) {
                right--;
                back = letters.charAt(right);
            }
            if (front != back) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
