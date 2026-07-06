class Solution {
    public String mergeAlternately(String word1, String word2) {
        // StringBuilder object to hold the final string
        StringBuilder sb = new StringBuilder();
        // using a single variable for the loop
        int i = 0;

        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) { // end of word has not been reached
                sb.append(word1.charAt(i));
            }

            if (i < word2.length()) { // end of word has not been reached
                sb.append(word2.charAt(i));
            }

            i++;
        }

        return sb.toString();
    }
}