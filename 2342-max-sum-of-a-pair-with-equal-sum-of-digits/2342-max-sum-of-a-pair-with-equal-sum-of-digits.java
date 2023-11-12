class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for(int num: nums) {
            int sumOfDigit = nohelper(num);
           if(map.containsKey(sumOfDigit)) {
               int value = map.get(sumOfDigit);
               max = Math.max(max, value + num);
               if(value < num){
                   map.put(sumOfDigit, num);
               }
           } else {
               map.put(sumOfDigit, num);
           }
        }
        return max;
        
    }
    
    int nohelper(int n){
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
//18,43,36,13,7
//9 18,36
//7 43 ,7
//4 13