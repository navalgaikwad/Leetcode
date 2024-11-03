}
if(target < 0) {
return null;//less than 0 asel tar null
}
if(memo.containsKey(target)) {
return memo.get(target);
}
Integer min = null;
for(int coin : coins) {
int remainder = target - coin;
Integer coount = helper(coins, remainder, memo);
if(coount != null) {
int newCount = coount + 1;
if(min == null || newCount < min) {
min = newCount;
}
}
}
memo.put(target, min);
return min;
}
}
​
class Solution {
public int coinChange(int[] coins, int amount) {
Integer value = dp(coins, amount, new HashMap<>());
return value == null? -1 : value;
}
Integer dp(int[] coins, int target, Map<Integer, Integer> memo) {
if(memo.containsKey(target)) {
return memo.get(target);
}
if(target == 0) {
return 0;
}
if(target < 0) {
return null;
}
Integer maxCount = null;
for(int coin : coins) {
int remainder = target - coin;
Integer count = dp(coins, remainder, memo);
if(count!= null) {
int newCount = count + 1;
if(maxCount == null || newCount <  maxCount) {
maxCount = newCount;
}
}
}
memo.put(target, maxCount);
return maxCount;
}
}