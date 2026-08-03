import java.util.*;
//brute force solution using merge sort
// public class duplicateNumber {
//     public int findDuplicate(int[] nums){
//         Arrays.sort(nums);
//         for(int i = 0; i < nums.length - 1; i++){
//             if(nums[i] == nums[i + 1])
//                 return nums[i];
//         }
//         return -1;
//     }
//     public static void main(String[] args) {
//         duplicateNumber obj = new duplicateNumber();
//         int[] nums = {1,3,4,2,2};
//         System.out.println(obj.findDuplicate(nums));
//     }
    
// }


// using hasmap
public class duplicateNumber {
    public int findDuplicate(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return nums[i];
            }
            map.put(nums[i], 1);
        }
        return -1;
    }
    public static void main(String[] args) {
        duplicateNumber obj = new duplicateNumber();
        int[] nums = {1,3,4,2,2};
        System.out.println(obj.findDuplicate(nums));
    }
    
}




// optimal solution
// public class duplicateNumber {
//     public int findDuplicate(int[] nums){
//         int slow = nums[0];
//         int fast = nums[0];
//         do{
//             slow = nums[slow];
//             fast = nums[nums[fast]];
//         }while(slow != fast);
//         fast = nums[0];
//         while(slow != fast){
//             slow = nums[slow];
//             fast = nums[fast];
//         }
//         return slow;
//     }
//     public static void main(String[] args) {
//         duplicateNumber obj = new duplicateNumber();
//         int[] nums = {1,3,4,2,2};
//         System.out.println(obj.findDuplicate(nums));
//     }
    
// }
