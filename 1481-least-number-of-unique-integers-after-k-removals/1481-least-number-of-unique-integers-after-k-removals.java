class Solution {
    public int findLeastNumOfUniqueInts(int[] arrs, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int arr: arrs){
            map.put(arr, map.getOrDefault(arr, 0) + 1);
        }
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        pq.addAll(map.values());
        
        while(k > 0){
            k= k - pq.remove();
        }
         return k < 0 ? pq.size() + 1 : pq.size();    
    }
}

//[5,5,4]
//5 - 2
//4- 1

//[4,3,1,1,3,3,2]
//4 -1
//2- 1

