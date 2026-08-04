
// // Better solution
// public class repeated_missingNum {
//     public static int[] findMissingAndRepeated(int[] a){
//         int n = a.length;
//         int[] hash = new int[n + 1];

//         for(int i=0; i<n; i++){
//             hash[a[i]]++;
//         }
//         int repeated = -1;
//         int missing = -1;

//         for(int i=1; i<=n; i++){
//             if(hash[i] == 0){
//                 missing = i;
//             }
//             if(hash[i] == 2){
//                 repeated = i;
//             }
//         }
//         return new int[]{repeated, missing};
//     }
//     public static void main(String[] args) {
//         int[] a = {1,3,4,2,2};
//         int[] ans = findMissingAndRepeated(a);
//         System.out.println(ans[0] + " " + ans[1]);
//     }
// }

// optimal solution using mathimatical approach

public class repeated_missingNum{
    public static int[] findMissingRepeatingNumbers(int[] a) {
        int n = a.length;

        // S = x - y
        long SN = (long) n * (n + 1) / 2;

        // S2 = x² - y²
        long S2N = (long) n * (n + 1) * (2L * n + 1) / 6;

        long S = 0;
        long S2 = 0;

        // Calculate actual sum and sum of squares
        for (int i = 0; i < n; i++) {
            S += a[i];
            S2 += (long) a[i] * a[i];
        }

        // val1 = x - y
        long val1 = S - SN;

        // val2 = x² - y² = (x - y)(x + y)
        long val2 = S2 - S2N;

        // x + y
        val2 = val2 / val1;

        // x = (x - y + x + y) / 2
        long x = (val1 + val2) / 2;

        // y = x - (x - y)
        long y = x - val1;

        return new int[] { (int) x, (int) y };
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,2,2};
        int[] ans = findMissingRepeatingNumbers(a);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
