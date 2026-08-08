import java.util.*;

public class BSon1D {

    //Q1.Search X in sorted array(iterative code)
    public static int search(int arr[], int n, int target){
        int low=0, high= n-1;
        while(low<=high){
            int mid =(low+high)/2;
            if(arr[mid]==target){
                return mid;
            }else if(target>arr[mid]){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

    //Q1.Search X in sorted array(recursive code)
     public static int bs(int[] arr, int low, int high, int target) {

        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == target)
            return mid;
        else if (target > arr[mid])
            return bs(arr, mid + 1, high, target);

        return bs(arr, low, high - 1, target);
    }

    public static int search1(int[] arr, int n, int target) {
        return bs(arr, 0, n - 1, target);
    }

    //Q2.Lower Bound
    public static int lowerBound(int arr[], int n, int target){
        int low=0;
        int high =n-1;
        int ans =n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=target){
                ans= mid;
                high = mid-1;
            }else{
                low= mid+1;
            }
        }
        return ans;
    }

    //Q3.Upper Bound
    public static int upperBound(int arr[], int n, int target){
        int low=0;
        int high =n-1;
        int ans =n;
        while(low<=high){
            int mid=(low+high)/2;
            //just comparison operator difference
            if(arr[mid]>target){
                ans= mid;
                high = mid-1;
            }else{
                low= mid+1;
            }
        }
        return ans;
    }

    //Q4.Search insert position(same as lower bound)
    public static int insertPosition(int arr[], int n, int target){
        int low=0;
        int high =n-1;
        int ans =n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=target){
                ans= mid;
                high = mid-1;
            }else{
                low= mid+1;
            }
        }
        return ans;
    }

    //Q5.Floor and Ceil in Sorted Array
    // Floor: Greatest element <= target
    public static int floor(int arr[], int n, int target){
        int low=0;
        int high =n-1;
        int ans =-1;
        while(low<=high){
            int mid=(low+high)/2;
            //just minor change in lower bound comparison operator
            if(arr[mid]<=target){
                ans= mid;
                low= mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    // Ceil: Smallest element >= target(lower bound)
    public static int ceil(int arr[], int n, int target) {
        int low = 0, high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    //Q6.First and last occurrence(code 1)
    public static int[] firstLast(int arr[], int n, int target){
        int first =-1;
        int last=-1;
        for(int i =0; i<n; i++){
            if(arr[i]==target){
                if(first==-1){
                    first = i;
                }
                last =i;
            }
        }
        return new int[]{first,last};
    }
    
    //Q6.First and last occurrence(code 2)
    public static int[] firstLast2(int arr[], int n, int target){
        //give call to Q2(lowerBound function) and Q3(upperBound function)
        int lb = lowerBound(arr, n, target);
        if(lb==n || arr[lb] != target){
            return new int[]{-1,-1};
        } 
        return new int[] {lb, upperBound(arr, n, target)-1};
    }

    //Q6.First and last occurrence(code 3)
    public static int firstOccurance(int arr[], int n, int target){
        int low=0;
        int high = n-1;
        int first =-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                first =mid;
                high = mid-1;
            }else if(arr[mid]<target){
                low= mid+1;
            }else{
                high=mid-1;
            }
        }
        return first;
    }
    public static int lastOccurance(int arr[], int n, int target){
        int low=0;
        int high = n-1;
        int last =-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                last =mid;
                low = mid+1;
            }else if(arr[mid]<target){
                low= mid+1;
            }else{
                high=mid-1;
            }
        }
        return last;
    }
    public static int[] firstLast3(int arr[], int n, int target){
        int first = firstOccurance(arr, n, target);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last= lastOccurance(arr, n, target);
        return new int[]{first,last};
    }

    //Q7.Count Occurrences in a Sorted Array
    public static int countOccurance(int arr[], int n, int target){
        int[] ans = firstLast(arr, n, target);

        if (ans[0] == -1)
            return 0;

        return ans[1] - ans[0] + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target element: ");
        int target= sc.nextInt();

        // //Q1.Call to Search X in sorted array(iterative code)
        // int result = search(arr, n, target);
        // if (result != -1) {
        //     System.out.println("Element found at index: " + result);
        // } else {
        //     System.out.println("Element not found.");
        // }
        // //Q1.Call to Search X in sorted array(recursive code)
        // int ans = search1(arr, n, target);
        // if (ans == -1){
        //     System.out.println("Element not found.");
        // }else{
        //     System.out.println("Element found at index: " + ans);
        // }

        // //Q2.Call to Lower Bound
        // int ans = lowerBound(arr, n, target);
        // if (ans == n) {
        //     System.out.println("Lower Bound does not exist.");
        // } else {
        //     System.out.println("Lower Bound Index: " + ans);
        //     System.out.println("Lower Bound Element: " + arr[ans]);
        // }

        // //Q3.Call to Lower Bound
        // int ans = upperBound(arr, n, target);
        // if (ans == n) {
        //     System.out.println("Upper Bound does not exist.");
        // } else {
        //     System.out.println("Upper Bound Index: " + ans);
        //     System.out.println("Upper Bound Element: " + arr[ans]);
        // }

        // //Q4.Search insert position(same as lower bound)
        // System.out.println("Insert Position: " +insertPosition(arr, n, target));

        // //Q5.Call to Floor and Ceil in Sorted Array
        // //Floor
        // int floorIndex = floor(arr, n, target);
        // if (floorIndex == -1)
        //     System.out.println("Floor does not exist.");
        // else {
        //     System.out.println("Floor Index: " + floorIndex);
        //     System.out.println("Floor Element: " + arr[floorIndex]);
        // }
        // //Ceil
        // int ceilIndex = ceil(arr, n, target);
        // if (ceilIndex == -1)
        //     System.out.println("Ceil does not exist.");
        // else {
        //     System.out.println("Ceil Index: " + ceilIndex);
        //     System.out.println("Ceil Element: " + arr[ceilIndex]);
        // }

        // //Q6.Call to First and last occurrence(code 1)
        // int[] result = firstLast(arr, n, target);
        // System.out.println("First occurrence: " + result[0]);
        // System.out.println("Last occurrence: " + result[1]);
        // //Q6.Call to First and last occurrence(code 2)
        // int[] result1 = firstLast2(arr, n, target);
        // System.out.println("First occurrence: " + result1[0]);
        // System.out.println("Last occurrence: " + result1[1]);
        // //Q6.Call to First and last occurrence(code 2)
        // int[] result2 = firstLast3(arr, n, target);
        // System.out.println("First occurrence: " + result2[0]);
        // System.out.println("Last occurrence: " + result2[1]);


        //Q7.Call to Count Occurrences in a Sorted Array
        int result1 = countOccurance(arr, n, target);
        System.out.println("Count of " + target + " = " + result1);
    }
}
