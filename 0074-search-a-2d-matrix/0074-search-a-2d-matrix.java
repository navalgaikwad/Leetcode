class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix[0].length;
        int[] column = new int[len];
        for(int i=0; i<len; i++) {
            column[i] = i;
        }
        List<Integer> list = new ArrayList<>();
        //int[] nums = new int[matrix.length*matrix.length+2];
        int j =0;
        for(int i=0; i<matrix.length; i++) {
            for(int col : column) {
                list.add(matrix[i][col]);
            }
            Collections.reverse(Arrays.asList(column)); 
        }
      
          System.out.print(list);  
      
        return binarySearch(list, target);
    }
    
    boolean binarySearch(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums.get(mid) == target){
                return true;
            }
            if(nums.get(left) <= nums.get(mid)) {// normal sorted//starting and middle
               if(nums.get(left)  <= target && nums.get(mid) > target ) { // normal condition
                    right = mid - 1;
                }else {
                    left = mid + 1;
                } 
            } else {
            if(nums.get(right) >= nums.get(mid)) {// right side normal sorted last and miidle
               if(nums.get(right) >= target && nums.get(mid) < target ) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                } 
              }
            }
            
        }
        return false;
    }
}