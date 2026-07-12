import java.util.*;

//Find the largest element in an array
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

    //Find the second largest element in an array
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

    //Find the second smallest element in an array
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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        
        System.out.println("enter the elements of the array:");
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        //Call this for finding largest element in an array
        int large = arre(arr, n);
        System.out.println("Largest array in the array is: " + large);
        
        //Call this for finging second largest element in an array
        int slargest = secondLagre(arr, n);
        System.out.println("Second largest element in an array is: " + slargest);

        //Call this for finging second smallest element in an array
        int ssmalest = secondSmall(arr, n);
        System.out.println("Second smallest element in an array is: " + ssmalest);
    }
}
