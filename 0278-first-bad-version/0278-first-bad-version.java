/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
       
        
        while(left < right) {
            int mid = left + (right - left)/2;
            //search untill we find first bad version search it on left side after that
            //all will be bad version, because we need to find first badversion
            if(isBadVersion(mid)){
               // firstBadVersion = mid;
                right = mid;
            }else {
                //search untill we find first bad version on right side
                left = mid + 1;
            }
        }
        return left;
    }
}