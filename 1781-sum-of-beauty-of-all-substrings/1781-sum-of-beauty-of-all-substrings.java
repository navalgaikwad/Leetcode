class Solution {
    public int beautySum(String s) {
        int ans = 0;
        int len = s.length();
        
        // traversing through the array to check all the substrings
        for(int start = 0; start < len; start++){
            
            // create a new array to store the count of all the character occurrences
            int[] arr = new int[26];
            
            // start from current index to move the end pointer as we are checking the substrings
            for(int end = start; end < len; end++){
                
                // increment the value at index of current character in the array created
                arr[s.charAt(end) - 'a']++;
                
                // store the max and min value as we need to do max - min for beauty of a string
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                
                // traverse the array for checking max and min value
                for(int k = 0; k < 26; k++){
                    max = Math.max(max, arr[k]);
                    if(arr[k] != 0){ // we don't check min at 0 index because both min and max can't be present for a single indexed string
                        min = Math.min(min, arr[k]);
                    }
                }
                // add the beauty of current substring into the final answer
                ans += max - min;
            }
        }
        
        return ans;
    }
}