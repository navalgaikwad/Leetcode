count = 1
map = {30: 2, 20: 1}
4th element (t = 100):
remainder = 100 % 60 = 40
complement = (60 - 40) % 60 = 20
Complement found in the map for remainder = 40.
Increment count by the value associated with the complement in the map (i.e., 1).
count = 2
map = {30: 2, 20: 1, 40: 1}
5th element (t = 40):
remainder = 40 % 60 = 40
complement = (60 - 40) % 60 = 20
Complement found in the map for remainder = 40.
Increment count by the value associated with the complement in the map (i.e., 1).
count = 3
map = {30: 2, 20: 1, 40: 2}
Final Result:
​
count = 3
The final count of pairs whose sum is divisible by 60 in the provided time array is 3.
​
class Solution {
public int numPairsDivisibleBy60(int[] time) {
int n = time.length, ans = 0;
HashMap<Integer, Integer> len = new HashMap<>();
for(int i  = 0; i < n; i++){
int rem = time[i] % 60;
int target = 60 - (rem);
if(len.containsKey(target))
ans += len.get(target);
if(rem != 0)
len.put(rem, len.getOrDefault(rem, 0) + 1);
else
len.put(60, len.getOrDefault(60, 0) + 1);
}
return ans;
}
}