return result;
}
}
```
​
​
int a = Integer.MAX_VALUE;
a += 1;
System.out.println(a);  // whenever
class Solution {
public int coinChange(int[] coins, int amount) {
Integer value =  helper(coins, amount, new HashMap<>());
return value == null? -1 : value;
}
Integer helper(int[] coins, int target, HashMap<Integer, Integer> memo) {
if( target == 0) {
return 0;//zero
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