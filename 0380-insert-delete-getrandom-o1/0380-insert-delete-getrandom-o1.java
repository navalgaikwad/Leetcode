import java.util.Collections;
class RandomizedSet {
    Set<Integer> set;
    public RandomizedSet() {
       set = new HashSet<>(); 
    }
    
    public boolean insert(int val) {
        return set.add(val);
    }
    
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    public int getRandom() {
       // if(set.size()>1) {
           List<Integer> list = new ArrayList<>(set);
            Collections.shuffle(list);
            int randomNumber = list.get(0); 
            return randomNumber;
       // }
       // return 0;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */