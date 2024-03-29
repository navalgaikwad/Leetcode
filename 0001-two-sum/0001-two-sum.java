class Solution {
    public int[] twoSum(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < num.length; i++) {
            if(map.containsKey(target - num[i])) {
                int[] arr = new int[2];
                arr[0] = map.get(target - num[i]);
                arr[1] = i;
                return arr;
            }
            map.put(num[i], i);
        }
        return new int[]{};
    }
}