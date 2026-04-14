class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: if either number is "0", the result is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        // The maximum possible length of the product is m + n
        int[] result = new int[m + n];

        // Start from the rightmost digits and work leftwards
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Convert char to integer
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int product = digit1 * digit2;

                // Determine the positions in the result array
                int p1 = i + j;
                int p2 = i + j + 1;

                // Add the product to whatever is currently in the rightmost position
                int sum = product + result[p2];

                // The right position gets the remainder (e.g., 14 -> 4)
                result[p2] = sum % 10;
                // The left position gets the carry added to it (e.g., 14 -> +1)
                result[p1] += sum / 10;
            }
        }

        // Convert the integer array back into a string
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            // Skip any leading zeros at the front of the array
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }

        return sb.toString();
    }
}