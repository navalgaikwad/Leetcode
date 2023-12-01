class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map =new HashMap<>();
       // int i =0;
        int len = nums2.length;
        
        for(int i =0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }
        
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        int j =0;
        
        for(int num : nums1){
            int index = map.get(num);
            for(int i =index; i<len; i++){
                if(nums2[i] > num){
                    result[j] = nums2[i];
                    break;
                }
            }
            j++;
        }
        return result;
    }
}
// nums1 = [4,1,2], nums2 = [1,3,4,2]
//[4, 1,  ]
//[]