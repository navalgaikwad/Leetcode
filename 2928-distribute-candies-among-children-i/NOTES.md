class Solution {
public int waysToDistributeCandies(int remainingCandies, int candyLimit, int remainingChildren) {
// Base case: If there are no candies left, return 1 way (valid distribution)
if (remainingCandies == 0) {
return 1;
}
​
// Base case: If there are no children left or the limit is exceeded, return 0 ways
if (remainingChildren == 0 || candyLimit == 0) {
return 0;
}
​
int ways = 0;
​
// Try distributing candies to the current child within the limit
for (int i = 0; i <= Math.min(candyLimit, remainingCandies); ++i) {
ways += waysToDistributeCandies(remainingCandies - i, candyLimit, remainingChildren - 1);
}
​
return ways;
}
​
public int distributeCandies(int totalCandies, int candyDistributionLimit) {
return waysToDistributeCandies(totalCandies, candyDistributionLimit, 3);
}
}