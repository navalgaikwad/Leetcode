class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for(int i=0; i<len; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(map.values());
        
        //[5,5,4], k = 1
        while(!pq.isEmpty() && k > 0){
            int freq  = pq.remove();
            k = k -freq;
        }
        return k == 0 ? pq.size() : (pq.size() + 1);
    }
}


//[2,1,1,3,3,3]
//3