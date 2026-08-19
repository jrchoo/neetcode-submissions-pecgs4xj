class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        List<Integer>[] buckets = new List[n + 1];
        int[] result = new int[k];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        int resultIndex = 0;
        for (int j = n; j >= 0 ; j--) { // iterate from the back
            List<Integer> list = buckets[j];
            
            if (list != null) {
                for (int num : list) {
                    result[resultIndex] = num;
                    resultIndex++;
                    if (resultIndex == k) {
                        return result;
                    } 
                }
            }
            
        }
        return result;
    }
}
