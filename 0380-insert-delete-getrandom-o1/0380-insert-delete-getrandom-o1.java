import java.util.*;

class RandomizedSet {
   
    Map<Integer, Integer> indexMap;
    List<Integer> listOfKey;
    Random rndm;
    
    public RandomizedSet() {
        indexMap = new HashMap<>();
        listOfKey = new ArrayList<>(); // An ArrayList is usually more efficient for random access
        rndm = new Random();
    }

    public boolean insert(int val) {
        if (!indexMap.containsKey(val)) {
            indexMap.put(val, listOfKey.size());
            listOfKey.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int indexToRemove = indexMap.get(val);
        int lastElement = listOfKey.get(listOfKey.size() - 1);
        Collections.swap(listOfKey, indexToRemove, listOfKey.size() - 1);
        listOfKey.remove(listOfKey.size() - 1);
        indexMap.put(lastElement, indexToRemove);
        indexMap.remove(val);
        return true;
    }
    
    public int getRandom() {
        return listOfKey.get(rndm.nextInt(listOfKey.size()));
    }
}
