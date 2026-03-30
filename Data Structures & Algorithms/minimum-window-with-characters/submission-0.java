class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        // base case, no possible substring
        if (m < n) {
            return "";
        }

        int min = Integer.MAX_VALUE;
        // initialise a map with chars in t and their frequencies
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // need is the number of keys in the map
        int requirement = map.size();
        int matched = 0;
        int left = 0;
        int minLeft = 0;
        for (int right = 0; right < m; right++) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                int freq = map.get(rightChar);
                if ((freq - 1) == 0) {
                    map.put(rightChar, 0);
                    matched++;
                } else {
                    map.put(rightChar, freq - 1);
                }
            } 
            while (matched == requirement) {
                int len = right - left + 1;
                if (len < min) {
                    min = len;
                    minLeft = left;
                }
                
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        matched--;
                    }
                }
                left++;
            }
            // breaks out of the loop when the current window does not meet the requirement
        }
        // using last known minLeft index to create substring
        return min == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + min);
    }
}
