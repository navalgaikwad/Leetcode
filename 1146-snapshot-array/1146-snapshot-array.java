class SnapshotArray {
    TreeMap<Integer, Integer> map[];
    int snap_id = 0;
    public SnapshotArray(int length) {
        map = new TreeMap[length];
        for(int i=0; i<length; i++) {
            map[i] = new TreeMap<>();
            map[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
       map[index].put(snap_id, val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
         return map[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
