class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        long exponent = Math.abs((long) n);
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= x;
            }

            x *= x;
            exponent /= 2;
        }

        return n > 0 ? result : 1 / result;
    }
}
