class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        if(len<n){
            return new int[]{};
        }
        int mid = len/2;
        //mid=mid+1;
        int[] ans=new int[len];
        //int i=0; 
        boolean flag=true;
        int j=0;
        for(int i=0; i<len && mid<len ; i++){
           if(flag){
                ans[i]=nums[j];
                j++;
           }else{
               ans[i]=nums[mid];
               mid++;
           }
         flag=!flag;
        }
        return ans;
    }
}