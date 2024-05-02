class Solution {
    public int numSubarraysWithSum(int[] A, int goal) {
       return atMost(A, goal) - atMost(A, goal - 1);
    }
    int atMost(int[] nums, int goal) {
         int n = nums.length;
        int i=0;
        int j=0;
        int cnt = 0;
        int ans =0;
        while(j < n) {
            cnt+=nums[j++];
            while(  i< j && cnt > goal) {
                cnt-=nums[i];
                i++;
            }
            ans+=j-i;
        }
        return ans;
    }
}

// class Solution {
//     int atMost(vector<int> A, int goal) {
//         int N = A.size(), i = 0, j = 0, cnt = 0, ans = 0;
//         while (j < N) {
//             cnt += A[j++];
//             while (i < j && cnt > goal) cnt -= A[i++];
//             ans += j - i;
//         }
//         return ans;
//     }
// public:
//     int numSubarraysWithSum(vector<int>& A, int goal) {
//         return atMost(A, goal) - atMost(A, goal - 1);
//     }
// };