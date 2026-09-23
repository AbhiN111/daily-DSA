import java.util.*;

public class array2D{

    //Q1.Find row with maximum 1's
    public static int rowWithMinimumOne1(int arr[][], int n, int m){
        int ind=-1;
        int max_count=-1;
        for(int i =0; i<n;i++){
            int cnt_row=0;
            for(int j=0; j<m; j++ ){
                cnt_row += arr[i][j];
            }
            if(cnt_row>max_count){
                max_count= cnt_row;
                ind=i;
            }
        }
        return ind;
    }

    //Q1. Find row with maximum 1's - function 1
    public static int lowerBound(int arr[], int n, int x) {
        int low=0, high=n - 1;
        int ans=n;
        while(low <= high) {
            int mid= (low +high) / 2;
            // maybe an answer
            if(arr[mid] >= x) {
                ans = mid;
                // look for more small index on left
                high = mid -1;
            }
            else {
                low =mid+1; // look for right
            }
        }
        return ans;
    }

    //Q1.function 2
    public static int rowWithMinimumOne2(int arr[][], int n, int m){
        int cnt_max = 0;
        int index = -1;
        for(int i = 0 ;i<n;i++) {
            int cnt_ones = m - lowerBound(arr[i], m, 1);
            if(cnt_ones >cnt_max) {
            cnt_max =cnt_ones;
            index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //Q1.Call to Find row with maximum 1's - approach 1
        System.out.println("Row with maximum number of 1s: " + rowWithMinimumOne1(arr, n, m));
        //Q1.Call to Find row with maximum 1's - approach 2
        System.out.println("Row with maximum number of 1s: " + rowWithMinimumOne2(arr, n, m));
    }
}
