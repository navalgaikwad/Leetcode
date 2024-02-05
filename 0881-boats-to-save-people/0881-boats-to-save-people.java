class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count =0;
        int left =0;
        int right =people.length-1;
       // int sum = 0;
        while(left <= right) {
           int sum = people[left] + people[right];
           
            if(sum <= limit) {
                left++;
                
            }
            right--;
            count++;
        }
        return count;
    }
}
//[3,2,2,1], limit = 3
//3 + 1 = 4 4< 3 1
//3+2 =5 1
//3+2 =5
//3+3
