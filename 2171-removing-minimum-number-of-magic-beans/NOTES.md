Solution 1. Sorting
Sort the original array A.
​
If we select A[i] as the number of beans in a non-empty bag, the number of removals needed is sum(A) - (N - i) * A[i].
​
Meaning of equation
For all A[j] (j < i), they are completely removed, contributing A[0] + .. + A[i-1] removals.
​
For all A[j] (j >= i), they become all A[i]s, contributing A[i] + .. + A[N-1] - (N-i) * A[i] removals.
​
Summing these two up, we get sum(A) - (N - i) * A[i].
​
Another way to think this is to remove every thing and recover (N - i) * A[i] beans that shouldn't be removed.
​
Why we should pick the number from A?
​
AssumeA = [1,5,10]. If we pick a number that is not in A, say 3, A becomes [0,3,3]. This is definitely not better than picking A[i] = 5 resulting in [0,5,5]. So, a solution picking a non-existent number is always dominated by another solution picking an existing number.
​
Example:
​
A = [1,4,5,6], sum(A) = 16
​
If we pick A[0] = 1, the result array is [1,1,1,1], # of removals is 16 - (4 - 0) * 1 = 12.
If we pick A[1] = 4, the result array is [0,4,4,4], # of removals is 16 - (4 - 1) * 4 = 4.
If we pick A[2] = 5, the result array is [0,0,5,5], # of removals is 16 - (4 - 2) * 5 = 6.
If we pick A[3] = 6, the result array is [0,0,0,6], # of removals is 16 - (4 - 3) * 6 = 10.
​
Complexity
Time complexity:O(2N)
Space complexity:O(1)