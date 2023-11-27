package Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandom {
        private HashMap<Integer, Integer> valueToIndex;
        private ArrayList<Integer> values;
        Random random;

        public InsertDeleteGetRandom() {
            valueToIndex = new HashMap<>();
            values = new ArrayList<>();
            random = new Random();

        }

        public boolean insert(int val) {
            if(valueToIndex.containsKey(val)){
                return false;
            }
            valueToIndex.put(val, values.size());
            values.add(val);
            return true;
        }

        public boolean remove(int val) {
            if(!valueToIndex.containsKey(val)){
                return false;
            }
            int lastIndex = values.size() - 1;
            int lastElement = values.get(lastIndex);
            int indexToRemove = valueToIndex.get(val);

            values.set(indexToRemove, lastElement);
            valueToIndex.put(lastElement,indexToRemove );

            values.remove(lastIndex);
            valueToIndex.remove(val);
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(values.size());
            return values.get(index);
        }
    }
