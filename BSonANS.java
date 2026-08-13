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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        //Q1.Call to Find square root of a number
        System.out.println("Square root of " + n + " = " + findSquareRoot(n));
    }
}
