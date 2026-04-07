class Solution {
    public List<Integer> partitionLabels(String s) {
        // array to store index of the last occuring character 
        int[] lastIndex = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            lastIndex[index] = i;
        }

        int start = 0;
        int end = 0;
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            int lastOccurence = lastIndex[curr - 'a'];
            end = Math.max(end, lastOccurence);

            if (i == end) { // successfully reached the boundary without stretching
                int len = end - start + 1;
                results.add(len);
                start = end + 1;
            }
        }

        return results;
    }
}
