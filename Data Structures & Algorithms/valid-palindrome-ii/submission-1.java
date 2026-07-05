class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) { // found a mismatch
                boolean deleteLeft = isPalindrome(s, left + 1, right); // if the character at left is deleted
                boolean deleteRight = isPalindrome(s, left, right - 1); // if the character at right is deleted

                return deleteLeft || deleteRight;
            }

            left++;
            right--;
        }

        return true;
    }

    // helper function
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            char front = s.charAt(left);
            char back = s.charAt(right);
            if (front != back) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}