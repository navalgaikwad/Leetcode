class Solution {
public int findMinArrowShots(int[][] points) {
Arrays.sort(points, (a,b)->Integer.compare(a[1],b[1]));
int[] interval = points[0];
int count =points.length;
for(int i = 1; i<points.length; i++) {
if(points[i][0] <= interval[1]) {
count--;
}else {
interval = points[i];
}
}
return count;
}
}
// [[10,16],[2,8],[1,6],[7,12]]
//  [[1,6],[2,8],[7,12][10,16]]
// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         Arrays.sort(points, (a,b)->Integer.compare(a[1],b[1]));
//         int[] prev = new int[points.length];
//         prev = points[0];
//         int count =points.length;
//         for(int i=1; i<points.length; i++) {
//             int[] interval = points[i];
//             if(interval[0] <= prev[1]) {
//                 count--;
//             }else {
//                 prev = interval;
//             }
//         }
//         return count;
//     }
// }
​