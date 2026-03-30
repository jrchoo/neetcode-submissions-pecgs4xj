class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            // add without carrying
            a = a ^ b;
            b = carry;
        }
        
        return a;
    }
}
