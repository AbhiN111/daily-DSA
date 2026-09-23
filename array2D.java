import java.util.*;

public class array2D {

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

        //Q1.Call to Find row with maximum 1's
        System.out.println("Row with maximum number of 1s: " + rowWithMinimumOne1(arr, n, m));
    }
}
