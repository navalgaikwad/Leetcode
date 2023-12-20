class Solution {
    public int maxArea(int[] height) {
        int left =0;
        int right =height.length - 1;
        int result = Integer.MIN_VALUE;
        while(left<right) {
            int min = Math.min(height[right], height[left]);
            result = Math.max(result, min* (right-left));
            if(height[right] < height[left]) {
                right--;
            }else {
                left++;
            }
        }
        return result;
    }
}
// class Solution {
//     public int maxArea(int[] height) {
//         int left = 0;
//         int right = height.length - 1;
//         int result = Integer.MIN_VALUE;
//         while (left < right) { // change condition to left < right
//             int min = Math.min(height[right], height[left]);
//             result = Math.max(result, min * (right - left)); // change the formula for area
//             if (height[right] < height[left]) {
//                 right--;
//             } else {
//                 left++;
//             }
//         }
//         return result;
//     }
// }
