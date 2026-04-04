class TimeMap {

    private class Data {
        String value;
        int timeStamp;

        public Data(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }

    private HashMap<String, ArrayList<Data>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        // retrieve the list of data
        List<Data> list = map.get(key);
        // perform binary search on the list
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int mid = left + (right - left + 1)  / 2; // right leaning
            int time = list.get(mid).timeStamp;
            if (time <= timestamp) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        if (list.get(left).timeStamp <= timestamp) {
            return list.get(left).value;
        }
        
        return "";
    }
}
