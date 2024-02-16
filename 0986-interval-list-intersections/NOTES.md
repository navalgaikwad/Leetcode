import java.util.*;
​
class Solution {
public int[][] intervalIntersection(int[][] A, int[][] B) {
int i = 0;
int j = 0;
​
List<int[]> result = new ArrayList<>();
while (i < A.length && j < B.length) {
int a_start = A[i][0];
int a_end = A[i][1];
int b_start = B[j][0];
int b_end = B[j][1];
​
if (a_start <= b_end && b_start <= a_end) {
result.add(new int[]{Math.max(a_start, b_start), Math.min(a_end, b_end)});
}
​
if (a_end <= b_end) {
i++;
} else {
j++;
}
}
​
return result.toArray(new int[result.size()][]);
}
}
​