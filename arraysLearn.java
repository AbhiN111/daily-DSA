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

    //6.Left Rotate Array by One
    public static int[] rotate(int[] arr, int n){
        int temp= arr[0];
        for(int i =1; i<n; i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] =temp;
        return arr;
    }

    //Left Rotate Array by K Places
    public static void rotateK(int[] arr, int n, int k){
        k=k%n;
        int[] temp= new int[k];
        for(int i =0; i<k; i++){
            temp[i] = arr[i];
        }

        for(int i = k; i <n ; i++){
            arr[i-k]=arr[i];
        }

        for(int i = n-k; i<n; i++){
            arr[i]= temp[i-(n-k)];
        } 
    }
    
    //7.Call to left Rotate Array by K Places(Optimal)
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void leftRotate(int[] arr, int n, int k) {
        k = k % n;

        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
    }

    //8.Move Zeros to End(Brute)
    public static int[] moveZeros(int arr[], int n){
        ArrayList<Integer> temp = new ArrayList<>();
         for(int i =0; i<n;i++){
            if(arr[i]!=0){
                temp.add(arr[i]);
            }
         }

        int nz = temp.size();
        for(int i = 0; i<nz; i++){
            arr[i]= temp.get(i);
        }

        for(int i=nz; i<n; i++){
            arr[i] =0;
        }
        return arr;
    }

    //8.Move Zeros to End(Optimal)
    public static int[] moveZeros2(int arr[], int n){
        int j = -1;
        for(int i = 0; i<n; i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }

        if(j==-1) return arr;

        for(int i = j+1; i<n;i++){
            if(arr[i] != 0){
                int temp= arr[i];
                arr[i] = arr[j];
                arr[j]= temp;
            }
        }

        return arr;
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

        System.out.println("Enter the number of rotatiion: ");
        int k =sc.nextInt();

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

        //5.Call to remove duplicates from Sorted array 
        int len = removeDuplicate(arr, n);  
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        } 
        System.out.println(); 
        
        //6.call to left Rotate Array by One
        rotate(arr, n);
        System.out.print("Array after left rotation: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //7.Call to left Rotate Array by K Places(Brute)
        rotateK(arr, n, k);
        System.out.print("Array after left rotation: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " "); 
        } 
        System.out.println();

        //7.Call to left Rotate Array by K Places(Optimal)
        leftRotate(arr, n, k);
        System.out.println("Array after left rotation:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        //8.Call to Move Zeros to End(Brute)
        moveZeros(arr, n);
        System.out.println("Array after moving all zeros to the end: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        //8.Call toMove Zeros to End(Optimal)
        moveZeros2(arr, n);
        System.out.println("Array after moving all zeros to the end: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
