class Solution {
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            // extract the last digit
            int digit = x % 10;

            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            // add the digit to the reversed number
            reversed = (reversed * 10) + digit;
            // remove the digit from the original number
            x = x / 10;
        }

        return reversed;
    }
}
