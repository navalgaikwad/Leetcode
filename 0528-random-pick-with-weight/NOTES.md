```
```
Use accumulated freq array to get idx.
w[] = {2,5,3,4} => wsum[] = {2,7,10,14}
then get random val random.nextInt(14)+1, idx is in range [1,14]
​
idx in [1,2] return 0
idx in [3,7] return 1
idx in [8,10] return 2
idx in [11,14] return 3
then become LeetCode 35. Search Insert Position
Time: O(n) to init, O(logn) for one pick
Space: O(n)
```
```