class Solution:
def minFallingPathSum(self, matrix: List[List[int]]) -> int:
m, n = len(matrix), len(matrix[0])
dp = [[math.inf] * n for _ in range(m)]
​
# Initialize the bottom row of dp array
dp[0] = matrix[0]
​
# Fill in the dp array bottom-up
for r in range(1, m):
for c in range(n):
for prev_col in [c, c - 1, c + 1]:
if 0 <= prev_col < n:
dp[r][c] = min(dp[r][c], matrix[r][c] + dp[r - 1][prev_col])
​
# Find the minimum falling path sum in the top row of dp array
return min(dp[-1])