class Solution {
    public int heightChecker(int[] heights) {
        int[] heightToFreq = new int[101];
        
        for (int height : heights) {
            heightToFreq[height]++;
        }
        
        int result = 0;
        int curHeight = 0;
        //[1,1,4,2,1,3]
        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight] == 0) {//
                curHeight++;//3
            }
            
            if (curHeight != heights[i]) {//1
                result++;//1
            }
            heightToFreq[curHeight]--;//
        }
        
        return result;
    }
}
/*
1. tkae freq of no
2. if heigth[currHeighr] == 0 thrn increament it
3. if currHeigth != height[i] icreamnet result
4. no mater what happen decremant freq

*/
