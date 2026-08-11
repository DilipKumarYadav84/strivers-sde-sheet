import java.util.*;

class unique_path {
    
    public int f(int i, int j, int[][] dp) {
        
        // Base case
        if (i == 0 && j == 0) {
            return 1;
        }
        
        // Out of bounds
        if (i < 0 || j < 0) {
            return 0;
        }
        
        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        // Move up
        int up = f(i - 1, j, dp);
        
        // Move left
        int left = f(i, j - 1, dp);
        
        // Store and return answer
        dp[i][j] = up + left;
        
        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        
        // Fill DP array with -1
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return f(m - 1, n - 1, dp);
    }
    public static void main(String [] args) {
        unique_path obj = new unique_path();
        int m = 3;
        int n = 7;
        int result = obj.uniquePaths(m, n);
        System.out.println("Number of unique paths: " + result);
    }
}