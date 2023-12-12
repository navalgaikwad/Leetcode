```
ow, let's calculate the sum of a subarray from index i = 2 to j = 4. The subarray is [4, 1, 5].
​
Using direct calculation from nums: The sum is 4 + 1 + 5 = 10.
​
Using the prefix sum array:
​
prefix[j] is prefix[4], which is 14. It is the sum of elements from nums[0] to nums[4] (i.e., 3 + 1 + 4 + 1 + 5).
prefix[i] is prefix[2], which is 8. It is the sum of elements from nums[0] to nums[2] (i.e., 3 + 1 + 4).
The calculation is: prefix[j] - prefix[i] + nums[i] = 14 - 8 + 4 = 10.
Thus, whether we sum the subarray elements directly from nums or use the prefix sum array with the formula prefix[j] - prefix[i] + nums[i], we get the same result: the sum of the subarray [4, 1, 5] is 10. This illustrates how the prefix sum array can be used to efficiently calculate subarray sums.
```