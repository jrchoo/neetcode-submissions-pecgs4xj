/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // the target takes on values from 1 <= n
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result < 0) { // higher than target
                high = mid - 1;
            } else { // lower than target
                low = mid + 1;
            }
        }
        
        // this line should not be reached
        return -1;
    }
}