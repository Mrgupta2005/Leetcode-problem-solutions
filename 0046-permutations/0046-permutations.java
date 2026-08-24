import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();//ans list ki list
        backtrack(nums, new ArrayList<>(), ans);//call function
        return ans;
    }

    void backtrack(int[] nums, List<Integer> list, List<List<Integer>> ans) {//backtack function(num org, list curr,ans final)

        if (list.size() == nums.length) {//final call
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {//for each case

            if (list.contains(nums[i])) {//2nd base
                continue;
            }
//template 
            list.add(nums[i]);

            backtrack(nums, list, ans);

            list.remove(list.size() - 1);
        }
    }
}