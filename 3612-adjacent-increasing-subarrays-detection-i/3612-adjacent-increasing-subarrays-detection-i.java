class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int count=1,max=0;
        for(int i=0;i<nums.size()-k-1;i++){
            if((nums.get(i+1)>nums.get(i)) && nums.get(k+i+1)>nums.get(k+i)){
                count++;
            }else{
                if(count>=k){
                    return true;
                }
                count=1;
            }
            
        }
        if(count>=k){
            return true;
        }
        return false;
    }
}