class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int len1 = nums1.length;
        for(int i=0; i<len1; i++){
            map.put(nums1[i], i);
        }
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for(int i = 0; i<nums2.length; i++){
            if(!map.containsKey(nums2[i])){
                continue;
            }else{
                for(int j = i + 1; j< nums2.length; j++){
                    if(nums2[j] > nums2[i]){
                        int id = map.get(nums2[i]);
                        result[id] = nums2[j];
                        break;
                    }
                }
            }
        }
        return result;
    }
}