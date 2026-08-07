// brute force approach
// public class majorityElement {
//     public int majorityElements(int[] nums){
//         int count =0;
//         int n = nums.length;
//         for(int i=0; i<n; i++){
//             count=0;
//             for(int j=0; j<n; j++){
//                 if(nums[i]== nums[j]){
//                     count++;
//                 }
//             }
//             if(count > n/2){
//                 return nums[i];
//             }
//         }
//         return -1;
//     }
// }


// better approach using HashMap
// import java.util.*;

// public class majorityElementI{
//     public int majorityElement(int[] nums){
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i=0; i<nums.length; i++){
//             if(map.containsKey(nums[i])){
//                 map.put(nums[i], map.get(nums[i])+1);
//             }else{
//                 map.put(nums[i], 1);
//             }
//         }
//         for(int i=0; i<nums.length; i++){
//             if(map.get(nums[i]) > nums.length/2){
//                 return nums[i];
//             }
//         }
//         return -1;
//     }

// }
// optimized approach using Moore's Voting Algorithm
public class majorityElementI{ 
    public int majorityElement(int[] nums){
        int count =0;
        int n= nums.length;
        int el=0;
        for(int i=0; i<n; i++){
            if(count == 0){
                count = 1;
                el = nums[i];
            }
            else if(nums[i] == el){
                count++;
            }else{
                count--;
            }
            int count1 =0;
            for(int j=0; j<n; j++){
                if(nums[j] == el){
                    count1++;
                }
            }
            if(count1 > n/2){
                return el;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {2, 2,3,3, 1, 2, 2};
        System.out.println(obj.majorityElement(nums));
    }
}
