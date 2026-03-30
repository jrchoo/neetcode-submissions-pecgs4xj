class Solution {

    public String encode(List<String> strs) {
        StringBuilder finalString = new StringBuilder();
        // calculate the length of each string
        for (int i = 0; i < strs.size(); i++) {
            String current = strs.get(i);
            int len = current.length();
            // append the length, delimiter and the string itself
            finalString.append(len).append('#').append(current);
        }
        // return the final string
        return finalString.toString();
    }

    public List<String> decode(String str) {
        List<String> finalList = new ArrayList<>();
        int n = str.length();
        int i = 0;
        while (i < n) {
            // find the delimiter from the current position i
            int delimiter = str.indexOf('#', i);
            // grab the length of the string
            int len = Integer.parseInt(str.substring(i, delimiter));
            // extract the substring based on the length
            String substring = str.substring(delimiter + 1, delimiter + 1 + len);
            // add to a final list
            finalList.add(substring);
            i = delimiter + 1 + len;
        }
        return finalList;
    }
}
