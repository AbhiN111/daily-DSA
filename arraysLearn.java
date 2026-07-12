import java.util.*;

//1.Find the largest element in an array
public class arraysLearn {
    public static int arre(int arr[], int n){
        int large = arr[0];

        for (int i =0; i<n; i++){
            if(arr[i]>large){
                large=arr[i];
            }
        }
        return large;
    }

    //2.Find the second largest element in an array
    public static int secondLagre(int arr[], int n){
        int largest = arr[0];
        int slargest = -1;
        
        for(int i = 1; i < n; i++){
            if(arr[i] > largest){
                slargest = largest;
                largest = arr[i];
            }
            else if (arr[i] < largest && arr[i]> slargest){
                slargest = arr[i];
            }
        }
        return slargest;
    } 

    //3.Find the second smallest element in an array
    public static int secondSmall(int arr[], int n){
        int smallest = arr[0];
        int ssmalest = Integer.MAX_VALUE;

        for(int i = 1; i < n ;i++){
            if(arr[i] < smallest){
                ssmalest = smallest;
                smallest = arr[i];
            }
            else if (arr[i] != smallest && arr[i] < ssmalest){
                ssmalest = arr[i];
            }
        }
        return ssmalest;
    }

    //Check if given array is sorted or not
    public static boolean isSorted(int arr[], int n){
        for(int i = 1; i<n; i++){
            if(arr[i]>= arr[i-1]){
                
            }
            else{
                return false;
            }
        }
        return true;
    }

    //5.Remove duplicates from Sorted array
    public static int removeDuplicate(int arr[], int n){
        int i =0;
        for(int j =1; j<n; j++){
            if(arr[i] != arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        //1.Call this for finding largest element in an array
        int large = arre(arr, n);
        System.out.println("Largest array in the array is: " + large);
        
        //2.Call this for finging second largest element in an array
        int slargest = secondLagre(arr, n);
        System.out.println("Second largest element in the array is: " + slargest);

        //3.Call this for finging second smallest element in an array
        int ssmalest = secondSmall(arr, n);
        System.out.println("Second smallest element in the array is: " + ssmalest);

        //4.Call to the function, is array sorted or not
        if (isSorted(arr, n)) {
            System.out.println("Array is Sorted");
        } else {
            System.out.println("Array is Not Sorted");
        }

        //5.Remove duplicates from Sorted array 
        int len = removeDuplicate(arr, n);  
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }    
    }
}
