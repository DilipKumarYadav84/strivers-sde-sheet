 // Count Inversion in an array
 // brute force approach
//  public class countInversion{

//     // Brute force
//     public static int countInversions(int[] a){
//         int n = a.length;
//         int count =0;
//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 if(a[i] > a[j]){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }

//     public static void main(String[] args) {
//         int[] a = {5, 3, 2, 4, 1};
//         System.out.println(countInversions(a));
//     }
//  }


// optimal approach using merge sort

import java.util.*;
public class countInversion{
    public static long getInversions(long arr[], int n){
        return mergeSort(arr, 0, n - 1);
    }
    private static long mergeSort(long arr[], int low, int high){
        long count =0;
        if(low >= high){
            return count;
        }
        int mid = low +(high -low)/2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }
    private static long merge(long arr[], int low, int mid, int high){
        ArrayList<Long> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        long count =0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
                count += mid - left + 1;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low; i<=high; i++){
            arr[i] = temp.get(i - low);
        }
        return count;
    }
    public static void main(String[] args) {
        long[] a = {5, 3, 2, 4, 1};
        System.out.println(getInversions(a, a.length));
    }
}