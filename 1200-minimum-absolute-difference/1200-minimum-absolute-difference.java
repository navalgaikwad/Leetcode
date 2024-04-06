class Solution {
     public static List<List<Integer>> minimumAbsDifference(int[] arr) {
   List<List<Integer>> result = new ArrayList<>();
   Arrays.sort(arr);
   int left = 0; 
   int right = 1;
   int min = Integer.MAX_VALUE;
   while (right < arr.length) {
       int diff = Math.abs(arr[right] - arr[left]);
       if (diff < min) {
           // If a smaller difference is found, clear the result list
           result.clear();
           min = diff;
       }
       if (diff == min) {
           // Add the pair with the minimum difference to the result list
           result.add(Arrays.asList(arr[left], arr[right]));
       }
       left++;
       right++;
   }
   return result;
}

}

/*
sort
find minimum diff
find the mindiff value


*/