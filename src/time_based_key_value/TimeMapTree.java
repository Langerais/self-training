package time_based_key_value;

import java.util.*;

class TimeMap {

    private static class Entry {
        int[] times = new int[1000];
        String[] values = new String[1000];
        int size = 0;

        void add(int time, String value) {
            if (size == times.length) grow();
            times[size] = time;
            values[size++] = value;
        }

        void grow() {
            times = Arrays.copyOf(times, times.length * 2);
            values = Arrays.copyOf(values, values.length * 2);
        }

        String get(int t) {
            int left = 0, right = size - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (times[mid] <= t) left = mid + 1;
                else right = mid - 1;
            }
            return right >= 0 ? values[right] : "";
        }
    }

    private Map<String, Entry> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new Entry()).add(timestamp, value);
    }

    public String get(String key, int timestamp) {
        Entry e = map.get(key);
        return e == null ? "" : e.get(timestamp);
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
