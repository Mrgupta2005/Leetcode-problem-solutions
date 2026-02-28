# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from add2num import ListNode
from typing import Optional
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        v=[]
        i=head
        while i:
            v.append(i.val)
            i=i.next
        return v==v[::-1]