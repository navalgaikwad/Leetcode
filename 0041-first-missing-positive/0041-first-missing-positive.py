class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        nums.append(0)
        n = len(nums)
        for i in range(len(nums)):  # delete those useless elements
            if nums[i] < 0 or nums[i] >= n:
                nums[i] = 0

        for i in range(len(nums)):  # use the index as the hash to record the frequency of each number
            nums[nums[i] % n] += n

        for i in range(1, len(nums)):
            if nums[i] // n == 0:
                return i

        return n
