import java.util.*;

public class Sorting2 {

    // public static void merge(int arr[], int low , int mid, int high){
    //     ArrayList<Integer> temp = new ArrayList<>();

    //     int left =low;
    //     int right = mid +1;
    //     while(left<=mid && right<=high){
    //         if(arr[left]<=arr[right]){
    //             temp.add(arr[left]);
    //             left++;
    //         }
    //         else{
    //             temp.add(arr[right]);
    //             right++;
    //         }
    //     }

    //     while(left<=mid){
    //         temp.add(arr[left]);
    //         left++;
    //     }

    //     while(right<=high){
    //        temp.add(arr[right]);
    //         right++; 
    //     }

    //     for(int i= low; i<= high;i++){
    //         arr[i] = temp.get(i-low);
    //     }
    // }

    // public static void mS(int arr[], int low , int high){
    //     if(low>=high) return;
    //     int mid = (low+high)/2;

    //     mS(arr, low,  mid);
    //     mS(arr, mid+1, high);
    //     merge(arr, low, mid, high);
    // }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i] <= pivot && i <= high - 1){
                i++;
            }
            while(arr[j] >= pivot && j >= low + 1){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    public static void qs(int arr[], int low, int high){
        if(low<high){
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high );
        }
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

        qs(arr, 0, arr.length-1);
        // mS(arr, 0, n - 1);

        System.out.println("Sorted Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
