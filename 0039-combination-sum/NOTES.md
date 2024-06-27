for(int i = index; i<nums.length; i++){
if(sum<= target){
ans.add(nums[i]);
dfs(nums, target, sum + nums[i], ans, i);
ans.remove(ans.size() - 1);
}
}
Using an indexed for loop (for(int i = start; i < nums.length; i++)):
This loop starts from a given index (start) and thus ensures that for each recursive call, we only consider numbers at or after the start index. This is a fundamental approach in combination problems to avoid duplicates and to consider each combination only once. This indexed approach maintains the order of elements and prevents going back to use elements that have already been considered, hence allowing us to generate unique combinations without revisiting the same numbers for the current specific recursive path.
Using a for-each loop (for(int num : nums)):
This loop does not keep track of the index of the current number being used in the array. This means every recursive call can use all numbers from the nums array without regard to the sequence or position, which will result in duplicates and potentially missing combinations because the order is not preserved. This approach doesn't prevent revisiting the same number that has already been considered in the current recursive path, leading to combinations being counted multiple times.
​
Using an indexed for loop (for(int i = start; i < nums.length; i++)):
This loop starts from a given index (start) and thus ensures that for each recursive call, we only consider numbers at or after the start index. This is a fundamental approach in combination problems to avoid duplicates and to consider each combination only once. This indexed approach maintains the order of elements and prevents going back to use elements that have already been considered, hence allowing us to generate unique combinations without revisiting the same numbers for the current specific recursive path.
​
In the context of the combination sum problem where the same number can be chosen multiple times, it is essential to use the index-based approach. When you use dfs(nums, target, i, sum + nums[i], ans);, you pass i as the start index for the next recursion, ensuring that the next recursive call will not go back to elements before i, thus avoiding permutations of the same combination.
​
Here's a clearer explanation with an example:
​
Assume nums = [2, 3, 6, 7] and target = 7.
We start with 2, and our path is [2].
In the next recursive call, we still start from 2 because we can use 2 multiple times.
Once we return from the recursion that started with [2, 2], we move on to [2, 3]. If we didn't have the index, we might end up considering [3, 2] in a later call, which is the same combination as [2, 3] just in a different order.
By using the indexed loop and starting from the current index, we make sure each combination is considered only once, thus effectively handling the uniqueness constraint.
class Solution {
public List<List<Integer>> combinationSum(int[] candidates, int target) {
return dp(candidates, target, new HashMap<>());
}
List<List<Integer>> dp(int[] candidates, int target, HashMap<Integer, List<List<Integer>>> memo) {
if(memo.containsKey(target)) {
return memo.get(target);