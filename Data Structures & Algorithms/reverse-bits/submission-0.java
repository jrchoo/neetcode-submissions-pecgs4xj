class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1; // grab the LSB
            result <<= 1;
            result = result | bit;
            n >>>= 1;
        }
        return result;
    }
}
