class Solution {
//763. Partition Labels
public int jump(int[] A) {
int jumps = 0, curEnd = 0, curFarthest = 0;
for (int i = 0; i < A.length - 1; i++) {
int next = i + A[i];
curFarthest = Math.max(curFarthest, next);
if (i == curEnd) {
jumps++;
curEnd = curFarthest;
}
}
return jumps;
}
}
//nums = [2,3,1,1,4]
//fast =0;
/**
i = 3
fast = 4
slow = 4
2
​
​
*/
/*
max find kar i + nums[i]
​
*/