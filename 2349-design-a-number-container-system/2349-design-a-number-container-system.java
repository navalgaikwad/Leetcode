class NumberContainers {
    HashMap<Integer, Integer> indexNum = new HashMap<>();
    HashMap<Integer, TreeSet<Integer>> find = new HashMap<>();

    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        // check if index was previously added
        if (indexNum.containsKey(index)) {
            // get the old number of index
            int oldNumber = indexNum.get(index);

            // remove index of old number from tree set
            find.get(oldNumber).remove(index);

            // if set is empty then remove key
            if (find.get(oldNumber).isEmpty()) find.remove(oldNumber);
        }
        // Add in both the maps
        find.computeIfAbsent(number, k -> new TreeSet<>((a, b) -> a - b)).add(index);
        indexNum.put(index, number);
    
    }
    
    public int find(int number) {

        return find.get(number) == null ? -1 : find.get(number).first();
    }
}