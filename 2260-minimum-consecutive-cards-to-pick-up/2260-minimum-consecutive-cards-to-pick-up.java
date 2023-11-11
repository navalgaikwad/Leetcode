class Solution {
    public int minimumCardPickup(int[] cards) {
        int left = 0;
       // int right = 0;
        int len = cards.length;
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        
        for(int right = 0; right < len; right++){
            // if there is duplicate window size will increase and map size is will be same
            map.put(cards[right], map.getOrDefault(cards[right], 0)+ 1);  
            
            while(map.size() < right -left + 1) {
                min = Math.min(min, right - left + 1);
                
                int value = map.get(cards[left]);
                map.put(cards[left], value - 1);
                
                if(map.get(cards[left]) == 0){
                    map.remove(cards[left]);
                }
                left++;
            }
           
        }
        
        return min!=Integer.MAX_VALUE? min : -1;
    }
}