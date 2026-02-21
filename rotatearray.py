from typing import List
def rotate( nums: List[int], k: int) -> None:
    n=len(nums)
    k=k%n
    nums[:]=nums[n-k:]+nums[:n-k]
# Example usage:
nums = [1, 2, 3, 4, 5, 6, 7]
k = 3
rotate(nums, k)
print(nums) 
