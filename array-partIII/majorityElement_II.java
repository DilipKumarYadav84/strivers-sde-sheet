// brute force approach
import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        int count1 = 0;
        int count2 = 0;

        int el1 = 0;
        int el2 = 0;

        // Step 1: Find two candidates
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == el1) {
                count1++;
            }
            else if (nums[i] == el2) {
                count2++;
            }
            else if (count1 == 0) {
                el1 = nums[i];
                count1 = 1;
            }
            else if (count2 == 0) {
                el2 = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == el1) {
                count1++;
            }
            else if (num == el2) {
                count2++;
            }
        }

        int n = nums.length;

        if (count1 > n / 3) {
            ans.add(el1);
        }

        if (count2 > n / 3) {
            ans.add(el2);
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {2, 2,3,3, 1, 2, 2};
        System.out.println(obj.majorityElement(nums));
    }
}