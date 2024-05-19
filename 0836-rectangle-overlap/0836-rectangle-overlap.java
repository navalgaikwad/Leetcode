// For overlapping questions:

// Interval A = [leftA, rightA]
// Interval B = [leftB, rightB]
// Overlapping region:  [max(leftA, leftB) , min(rightA, rightB)]                 
// which means if(max(leftA, leftB) < min(rightA, rightB)), there is an overlap.
// So the code of this problem is to check whether x is overlapped && y is overlapped.

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Interval overlapping: Max(left1, left2) < Min(right1, right2)
        // x has overlapping && y has overlapping
        
        int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
        int x3 = rec2[0], y3 = rec2[1], x4 = rec2[2], y4 = rec2[3];
        boolean overlapX = false;
        boolean overlapY = false;
        if(Math.max(x1, x3) < Math.min(x2, x4))
            overlapX = true;
        if(Math.max(y1, y3) < Math.min(y2, y4))
            overlapY = true;
        return overlapX && overlapY;
    }
}