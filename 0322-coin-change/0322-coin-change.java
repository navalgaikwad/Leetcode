class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer result = helper2(amount, coins, new HashMap<Integer, Integer>() );
        return result != null ? result : -1;
    }


 static Integer helper2(int target, int[] coins, HashMap<Integer, Integer> memo){
        if( memo.containsKey(target) ){
            return memo.get(target);
        }
        if( target == 0 ) return 0;
        
        if(target < 0) return -1;

        Integer result = -1;

        for(Integer coin :coins){
           Integer remainderList =  helper2(target - coin , coins, memo);
              if(remainderList != -1){
                  
                  Integer newCombination = remainderList + 1;

                  if(result ==-1 || newCombination < result){
                      result = newCombination;
            }
         }      
      }
     memo.put(target, result);
     return result;
    }
}