from typing import List

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        i = 0
        j = 0
        
        # Move 0s to front
        while i < len(nums):
            if nums[i] == 0:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1
            i += 1
        
        # Move 1s after 0s
        i = j
        while i < len(nums):
            if nums[i] == 1:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1
            i += 1
# Example usage:
nums = [2, 0, 2, 1, 1, 0]
solution = Solution()
solution.sortColors(nums)
print(nums)
   