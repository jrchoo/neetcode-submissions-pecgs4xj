class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // naive approach: for each string in the array, compare it with another string
        // and check if they are anagrams. if so, add them to a list. however, the issue
        // arises when an anagram has to be added to an existing list, cost of merging is
        // O(n^2 * m), where n is the number of strings and m is the length of the string
        
        // optimised approach: use a shared signature combined with a hashup to enable
        // fast lookups and comparisons

        // map to store shared signatures and the strings associated with them
        HashMap<String, List<String>> anagramGroups = new HashMap<>();
        // iterate through the strings
        for (String str : strs) {
            // store the frequency of each character inside the string
            int[] freq = new int[26];

            for (char c : str.toCharArray()) {
                int index = c - 'a'; // all strings are made up of lowercase letters
                freq[index]++;
            }
            // convert the frequency array into a string to be used as a key
            String signature = Arrays.toString(freq);
            // check if the map already contains this shared signature
            if (!anagramGroups.containsKey(signature)) {
                anagramGroups.put(signature, new ArrayList<>());
            }
            // if so, add the current string to the existing list
            anagramGroups.get(signature).add(str);
        }

        // convert the values (list of strings) into a final list
        return new ArrayList<>(anagramGroups.values());
    }
}
