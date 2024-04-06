class Solution {
    public void sortColors(int[] nums) {
        int[] frequnecy = new int[3];
        for(int num : nums) {
            frequnecy[num]++;
        }
        int j =0;
        for(int i =0; i<frequnecy.length; i++) {
            int value = frequnecy[i];//2
            while(value > 0) {
                nums[j++] =  i;//0,
                value--;//0
            }
            //i = j;
        }
    }
}
//[0, 0, ]
/*
nums = [2,0,2,1,1,0]
0 - 2
1 - 2
2 - 2



*/