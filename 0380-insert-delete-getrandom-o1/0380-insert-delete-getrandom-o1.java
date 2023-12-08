class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> idxMap;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        idxMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (idxMap.containsKey(val)) {
            return false;
        }

        idxMap.put(val, nums.size()); //val and list of the list where index is saved
        nums.add(val);//and save in the list
        return true;
    }

    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) {
            return false;
        }
        // if both are not matching 
        int idx = idxMap.get(val);
        int lastIdx = nums.size() - 1; 
        if (idx != lastIdx) {
            int lastVal = nums.get(lastIdx);// get the last value
            nums.set(idx, lastVal);//update the last index
            idxMap.put(lastVal, idx);// update map
        }
        nums.remove(lastIdx);// if both are same  remove from the the map and and list
        idxMap.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}