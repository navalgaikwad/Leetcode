class RandomizedSet {
   
    Map<Integer, Integer> indexMap = new HashMap<>();
    public RandomizedSet() {
        
    }
    int index =0;
    public boolean insert(int val) {
         if(!indexMap.containsKey(val)) {
            
             indexMap.put(val, val);
        
             return true;
         }
        return false;
        
    }
    
    public boolean remove(int val) {
           Integer ind = indexMap.remove(val);
           if(ind!=null) {
            
               return true;
           }
        return false;
    }
    
    public int getRandom() {
      //  Integer[] arrayNumbers = hs.toArray(new Integer[hs.size()]); 
  
        // generate a random number 
        Random rndm = new Random(); 
  
        // this will generate a random number between 0 and 
        // HashSet.size - 1 
        int rndmNumber = rndm.nextInt(indexMap.size());
        // Get the key at the random index
        Integer randomKey = new ArrayList<>(indexMap.keySet()).get(rndmNumber);
        
        return randomKey;
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */