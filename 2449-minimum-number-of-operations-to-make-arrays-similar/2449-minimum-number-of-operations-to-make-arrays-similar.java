class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        //find odd and even numbers 
        //and place them into different arrays
        int odd = 0, even = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] % 2 == 0) even++;

        odd = nums.length - even;
        int[] oddNums = new int[odd], evenNums = new int[even];
        int countOdd = 0, countEven = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) evenNums[countEven++] = nums[i];
            else oddNums[countOdd++] = nums[i];
        }
        int[] oddT = new int[odd], evenT = new int[even];
        countOdd = 0;
        countEven = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[i] % 2 == 0) evenT[countEven++] = target[i];
            else oddT[countOdd++] = target[i];
        }
        //sort all arrays so that odd numbers will correspond 
        //to target odd numbers. The same to even numbers
        Arrays.sort(oddNums);
        Arrays.sort(evenNums);
        Arrays.sort(oddT);
        Arrays.sort(evenT);
        long countUp = 0;

        //count difference in and find when we increment by 2
        //since we definitely have solution and number of 
        //increments and decrements are equal
        //we just need number of increments

        for (int i = 0; i < oddNums.length; i++) {
            int diff = oddT[i] - oddNums[i];
            if (diff == 0) continue;
            if (diff > 0) countUp += diff / 2;
        }
        for (int i = 0; i < evenNums.length; i++) {
            int diff = evenT[i] - evenNums[i];
            if (diff == 0) continue;
            if (diff > 0) countUp += diff / 2;
        }
        return countUp;
    }
}