class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // create a map of size 26 to store the order
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            int index = order.charAt(i) - 'a';
            map[index] = i;
        }

        // compare each word with the one right after
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            boolean isDifferent = false;
            // only compare the shorter of the two lengths
            int len = Math.min(word1.length(), word2.length());

            for (int j = 0; j < len; j++) {
                char char1 = word1.charAt(j);
                char char2 = word2.charAt(j);

                // if characters are not equal:
                // (1) check if they comply with the order, if not, return false
                if (char1 != char2) {
                    int index1 = char1 - 'a';
                    int index2 = char2 - 'a';

                    if (map[index1] > map[index2]) { // not in sorted order
                        return false;
                    }
                    // (2) if compliant, move to the next word
                    isDifferent = true;
                    break;
                }
                // if characters are equal, skip over
            }
            
            // if the characters do not differ, the shorter word has to appear first
            if (!isDifferent && word1.length() > word2.length()) {
                return false;
            }
        }
        
        return true;
    }
}