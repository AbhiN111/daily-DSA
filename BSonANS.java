import java.util.Scanner;

public class BSonANS {
    //Q1.Find square root of a number
    public static int findSquareRoot(int n){
        int low=1;
        int high =n;
        int ans =1;
        while(low<=high){
            int mid=(low+high)/2;
            if((mid*mid)<=n){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }


    //Q2.Find Nth root of a number
    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = func(mid, n, m);
            if (result == 1) {
                return mid;
            } 
            else if (result == 0) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
    //Q2 second function
    public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) {
                return 2;
            }
        }
        if (ans == m) {
            return 1;
        }
        return 0;
    }

    //Q3.Koko eating bananas
    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }
    //Q3 function 2
    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        for (int i = 0; i < v.length; i++) {
            totalH += Math.ceil((double) v[i] / hourly);
        }
        return totalH;
    }
    //Q3 function 3
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(piles, mid);
            if (totalH <= h) {
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    //Q4.Minimum days to make M bouquets
    public static boolean possible(int arr[], int days, int m, int k, int n){
        int cnt =0;
        int noOfB=0;
        for(int i=0; i<n;i++){
            if(arr[i]<=days){
                cnt++;
            }else{
                noOfB += (cnt/k);
                cnt=0;
            }
        }
        noOfB+=(cnt/k);
        return noOfB>=m;
    }
    //Q4 function 2
    public static int roseGarden(int arr[], int r, int b, int n){
        long val = (long) r * b;
        if(val>n) return -1;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        int low = mini;
        int high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(arr, mid, b, r,n)) {
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }
        return low;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter the elements in the array: ");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // //Q1.Call to Find square root of a number
        // System.out.println("Square root of " + n + " = " + findSquareRoot(n));

        // //Q2.Call to Find Nth root of a number
        // System.out.print("Enter a number(n): ");
        // int n = sc.nextInt();

        // System.out.print("Enter a number(m): ");
        // int m = sc.nextInt();
        // System.out.println("Nth root = " + NthRoot(n, m));

        // //Q3.Call to Koko eating bananas
        // System.out.print("Enter number of piles: ");
        // int n = sc.nextInt();
        // int[] piles = new int[n];
        // System.out.println("Enter bananas in each pile:");
        // for (int i = 0; i < n; i++) {
        //     piles[i] = sc.nextInt();
        // }
        // System.out.print("Enter maximum hours: ");
        // int h = sc.nextInt();
        // System.out.println("Minimum eating speed = " + minEatingSpeed(piles, h));

        //Q4.Call to Minimum days to make M bouquets
        System.out.print("Enter flowers per bouquet: ");
        int r = sc.nextInt();
        System.out.print("Enter number of bouquets: ");
        int b = sc.nextInt();
        int result = roseGarden(arr, r, b, n);
        System.out.println("Minimum days required = " + result);
    }
}
