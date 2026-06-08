class Solution {
    public String longestCommonPrefix(String[] strs) {
        // base case
        if (strs == null || strs.length == 0) {
            return "";
        }
        // vertical scanning, using first string as reference
        for (int i = 0; i < strs[0].length(); i++) {
            char c1 = strs[0].charAt(i);
            // compare the corresponding characters of each string
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c1 != strs[j].charAt(i)) { // second string is shorter or found a mismatch
                    return strs[0].substring(0, i);
                }
                // otherwise, increment the index and continue iterating
            }
        }
        // successfully looped through all strings, all characters match
        return strs[0];
    }
}