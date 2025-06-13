package randomized_set;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> vals;


    public RandomizedSet() {
        this.map = new HashMap<>();
        this.vals = new ArrayList<>();
    }

    public boolean insert(int val) {

        if(!this.map.containsKey(val)){
            vals.add(val);
            map.put(val, vals.size()-1);
            return true;
        }
        return false;

    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int lastElement = vals.get(vals.size() - 1);

            // Move the last element to the place of the element to delete
            vals.set(index, lastElement);
            map.put(lastElement, index);

            // Remove the last element
            vals.remove(vals.size() - 1);
            map.remove(val);

            return true;
        }
        return false;
    }

    public int getRandom() {
        return vals.get(ThreadLocalRandom.current().nextInt(vals.size()));
    }




}
