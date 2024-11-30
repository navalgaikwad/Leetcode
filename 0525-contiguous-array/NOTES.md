class Solution {
public int findMaxLength(int[] nums) {
Map<Integer, Integer> map = new HashMap<>();
map.put(0, -1);
int sum = 0;
int result =0;
for(int i=0; i<nums.length; i++) {
sum = sum + (nums[i] == 1?1:-1);//bracket important
if(map.containsKey(sum)) {
result= Math.max(result, i - map.get(sum));
}else {
map.put(sum , i);
}
}
return result;
}
}
// public int findMaxLength(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, -1);
//        int maxlen = 0, count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            count = count + (nums[i] == 1 ? 1 : -1);
//            if (map.containsKey(count)) {
//                maxlen = Math.max(maxlen, i - map.get(count));
//            } else {