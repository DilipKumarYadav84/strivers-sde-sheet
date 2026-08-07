// brute force

// class search2DMatrix {
//     public boolean searchMatrix(int[][] matrix, int target){
//         int n = matrix.length;
//         int m = matrix[0].length;
//         for(int i=0; i<n; i++){
//             for(int j=0; j<m; j++){
//                 if(matrix[i][j] == target){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

// search in row wise and column wise sorted matrix
// class search2DMatrix{
//     public boolean searchMatrix(int[][] matrix, int target){
//         int n = matrix.length;
//         int m = matrix[0].length;
//         for(int i=0; i<n; i++){
//             if(target >= matrix[i][0] && target <= matrix[i][m-1]){
//                 for(int j=0; j<m; j++){
//                     if(matrix[i][j] == target){
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;
//     }
//     public static void main(String[] args) {
//         search2DMatrix obj = new search2DMatrix();
//         int[][] matrix = {
//             {1, 3, 5, 7},
//             {10, 11, 16, 20},       
//             {23, 30, 34, 60}
//         };
//         int target = 3;
//         boolean result = obj.searchMatrix(matrix, target);
//         System.out.println(result); // Output: true
//     }

// }

// optimized approach
class search2DMatrix{
    public boolean searchMatrix(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int low =0;
        int high = n*m-1;
        while(low <= high){
            int mid = low +(high- low)/2;
            if(matrix[mid/m][mid%m] == target){
                return true;
            }
            else if(matrix[mid/m][mid%m] < target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return false;

    }
}