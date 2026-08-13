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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number(n): ");
        int n = sc.nextInt();

        System.out.print("Enter a number(m): ");
        int m = sc.nextInt();
        
        // //Q1.Call to Find square root of a number
        // System.out.println("Square root of " + n + " = " + findSquareRoot(n));

        //Q2.Call to Find Nth root of a number
        System.out.println("Nth root = " + NthRoot(n, m));
    }
}
