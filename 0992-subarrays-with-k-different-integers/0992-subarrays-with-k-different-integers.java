class Solution {
     public int atmost(int[]nums,int n ,int k){
        HashMap<Integer,Integer>map=new HashMap<>();
        int count=0;
        int i=0;
        int j=0;
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j], 0)+1);
            while(map.size()>k){
                map.put(nums[i],map.get(nums[i])-1);
               
                if(map.get(nums[i])==0)map.remove(nums[i]);
                 i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
         int n=nums.length;
        return atmost(nums,n,k)-atmost(nums,n,k-1);
    }
}