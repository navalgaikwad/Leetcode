class Solution {
     List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);nums.add(2); nums.add(3);nums.add(4);nums.add(5);
        nums.add(6);nums.add(7); nums.add(8);nums.add(9);
        helper(nums, k , 0, new ArrayList<>(), n);
        return result;
    }
    
    void helper(List<Integer> numbers, int k, int index, List<Integer> runningList, int target) {
        if(runningList.size() == k) {
            if(target == 0) {
                result.add(new ArrayList<>(runningList));
                return;
            }
            return;
        }
        for(int i= index; i< numbers.size(); i++) {
            runningList.add(numbers.get(i));
            helper(numbers, k, i  + 1, runningList, target - numbers.get(i));
            runningList.remove(runningList.size() - 1);
        }
    }
}