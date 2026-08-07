// brute force
// public class pow {
//     public int myPow(int x, int n) {
//         if(n == 0){
//             return 1;
//         }
//         if(n < 0){
//             x = 1/x;
//             n = -n;
//         }
//         int ans = 1;
//         for(int i=0; i<n; i++){
//             ans *= x;
//         }
//         return ans;
//     }
//     public static void main(String[] args) {
//         pow obj = new pow();
//         System.out.println(obj.myPow(2, 3));
//     }
// }


// optimized approach
public class pow {
    public double myPow(double x, int n){
        double ans= 1.0;
        long nn = n;
        if(nn < 0){
            nn = -1*nn;
        }
        while(nn > 0){
            if(nn % 2 == 1){
                ans = ans*x;
            }
            x = x*x;
            nn = nn/2;
        }
        if(n < 0){
            ans = 1/ans;
        }
        return ans;
    }
}