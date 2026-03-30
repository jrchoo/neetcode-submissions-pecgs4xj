class Solution {
    public boolean isHappy(int n) {
        int slow = getNext(n);
        int fast = getNext(slow);
        // if slow and fast pointers meet, there is a cycle
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    // to calculate the next number
    public int getNext(int n) {
        // Dividend = (Quotient * Divisor) + Remainder
        int totalSum = 0;
        int quotient = n;
        while (quotient > 0) {
            int remainder = quotient % 10; // grab the last digit
            quotient /= 10;
            totalSum += remainder * remainder; 
        }
        return totalSum;
    }
}
