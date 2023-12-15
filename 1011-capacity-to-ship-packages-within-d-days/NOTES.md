right = mid - 1; // Try to find a smaller capacity that still works.
} else {
left = mid + 1; // If not possible, we need a larger capacity.
}
}
return ans; // Return the least weight capacity found.
}
// Helper method to check if the current capacity allows shipping within the given days.
boolean checkCapacity(int[] weights, int days, int mid) {
int capacity = 1; // Start with the first day.
int sum = 0; // This will accumulate the weight of packages for the current day.
​
for(int weight : weights) {
sum += weight; // Add package weight to the current day's load.
// If the current day's load exceeds the capacity, we need to use an additional day.
if(sum > mid) {
capacity++; // Increment the day count.
sum = weight; // Start the next day with the current package.
}
}
// Return true if the number of days needed is less than or equal to the allowed days.
return capacity <= days;
}
}
​
```
[Template](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/discuss/2327257/Template-or-One-code-works-for-all-Problems)