class RandomizedSet {
    Set<Integer> hs = new HashSet<>();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        return hs.add(val);
    }
    
    public boolean remove(int val) {
        return hs.remove(val);
    }
    
    public int getRandom() {
        Integer[] arrayNumbers = hs.toArray(new Integer[hs.size()]); 
  
        // generate a random number 
        Random rndm = new Random(); 
  
        // this will generate a random number between 0 and 
        // HashSet.size - 1 
        int rndmNumber = rndm.nextInt(hs.size()); 
        return arrayNumbers[rndmNumber];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */