class Solution {
public int minEatingSpeed(int[] piles, int h) {
int left =1;
int right = 0;
for(int pile:piles) {
right = Math.max(right, pile);
}
while(left <= right) {
int mid = left + (right - left)/2;
if(heleper(piles, mid) <= h){
right = mid - 1;
}else {
left = mid + 1;
}
}
return left;
}
//time to reach capital same alike
int heleper(int[] piles, int k) {
int count =0;
for(int i =0; i<piles.length; i++) {
count += Math.ceil((double) piles[i] / k);
}
return count;
}
}