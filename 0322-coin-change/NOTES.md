```
class Solution {
public int coinChange(int[] coins, int amount) {
HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();
ArrayList<Integer> result = helper2(amount, coins, memo);
System.out.print(memo);
// if(sum != amount) return -1;
return result != null ? result.size() : -1;
}
​
static ArrayList<Integer> helper2(int target, int[] coins, HashMap<Integer, ArrayList<Integer>> memo){
if( memo.containsKey(target) ){
return memo.get(target);
}
if( target == 0 ){
ArrayList<Integer> baseList = new ArrayList<>();
return baseList;
}
if(target < 0) return null;
ArrayList<Integer> result = null;
​
for(Integer coin :coins){
ArrayList<Integer> remainderList =  helper2(target - coin , coins, memo);
if(remainderList != null){
ArrayList<Integer> newCombination = new ArrayList<>();
newCombination.addAll(remainderList);
newCombination.add(coin);
int newSize =
if(result ==null || newCombination.size() < result.size()){
result = newCombination;
}
}
}
memo.put(target, result);
prev_count = memo.get(target);
new_count = min(prev_count, currCount)
return result;
}
}
```