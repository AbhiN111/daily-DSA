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

    //Q2.Search in a 2D Matrix(better)
    public static boolean findTarget1(int n, int m, int arr[][], int target){
        int i=0;
        int j=m-1;
        while(i<n && j>=0){
            if(arr[i][j] == target){
                return true;
            }
            if(arr[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

    //Q2.Search in a 2D Matrix(optimal)
    public static boolean findTarget2(int n, int m, int arr[][], int target){
        if(arr.length == 0) return false;

        int low =0;
        int high = n*m -1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid/m][mid%m]==target){
                return true;
            }
            if(arr[mid/m][mid%m]<target){
                low= mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }

    //Q3.Search in 2D matrix - II
    public static int[] findTargetPart2(int n, int m, int arr[][], int target){
        int row =0;
        int col = m-1;

        while(row<n && col>=0){
            if(arr[row][col] == target){
                return new int[] {row, col};
            }
            if(arr[row][col]<target){
                row++;
            }else{
                col--;
            }
        }
        return new int[] {-1,-1};
    }

    //Q4.Find Peak Element - II
    public static int findMaxIndex(int arr[][], int n, int m, int col){
        int maxVal=-1;
        int index=-1;
        for(int i=0; i<n;i++){
            if(arr[i][col]>maxVal){
                maxVal=arr[i][col];
                index=i;
            }
        }
        return index;
    }

    //Q4. function 2
    public static int[] findPeakGrid(int arr[][], int n, int m){
        int low =0;
        int high = m-1;
        while(low<=high){
            int mid= (low+high)/2;
            int maxRowIndex=findMaxIndex(arr, n, m, mid);
            int left =mid-1>=0 ? arr[maxRowIndex] [mid -1]: -1;
            int right = mid + 1 < m ? arr[maxRowIndex][mid + 1]: -1;
            if(arr[maxRowIndex][mid] >left && arr[maxRowIndex][mid] > right){
                return new int[] {maxRowIndex, mid};
            }else if (arr[maxRowIndex][mid] < left) {
                high =mid -1;
            }else {
                low =mid+ 1;
            }
        }
        return new int[] {-1, -1};
    }

    //Q5.Matrix Median
    public static int findMedian(int arr[][], int n, int m){
        ArrayList<Integer> ls= new ArrayList<>();
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                ls.add(arr[i][j]);
            }
        }
        Collections.sort(ls);
        return ls.get((m * n) / 2);
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

        // //Q1.Call to Find row with maximum 1's - approach 1
        // System.out.println("Row with maximum number of 1s: " + rowWithMinimumOne1(arr, n, m));
        // //Q1.Call to Find row with maximum 1's - approach 2
        // System.out.println("Row with maximum number of 1s: " + rowWithMinimumOne2(arr, n, m));
        
        // System.out.print("Enter target: ");
        // int target = sc.nextInt();
        // //Q2.Cal to Search in a 2D Matrix(better)
        // System.out.println("Target found: " + findTarget1(n, m, arr, target));
        // //Q2.Call to Search in a 2D Matrix(optimal)(use different matrix)
        // System.out.println("Target found: " + findTarget2(n, m, arr, target));

        // //Q3. Call to Search in 2D matrix - II
        // System.out.println("Target found: " +  Arrays.toString(findTargetPart2(n, m, arr, target)));

        // //Q4.Call to Find Peak Element - II
        // int ans[] = findPeakGrid(arr, n, m);
        // System.out.println("Peak element position: ["+ ans[0] + ", " + ans[1] + "]");
        // System.out.println("Peak element: " + arr[ans[0]][ans[1]]);

        //Q5.Call to Matrix Median(approach 1)
        System.out.println("Median: " + findMedian(arr, n, m));
    }
}
