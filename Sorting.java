import java.util.Scanner;

class Sorting{

    public static void selection(int arr[], int n){
        //outer loop: start from first element(index 0) of array, append it in mini, continue this unit end of array(n-1)
        for(int i=0; i<=n-1; i++){
            int mini=i;
            //inner loop: start from index 1, and search for number which is smaller than mini, if smaller update mini by its index, continue until all elements get compared
            for(int j=i+1; j<=n; j++){
                if(arr[j]<arr[mini]){
                    mini = j;
                }
            }
            //take another variable temp for swapping elements, if number in sorted part in less than mini, swap the two numbers
            int temp = arr[mini];
            arr[mini]=arr[i];
            arr[i]=temp;
        }
    }

    public static void bubble(int arr[], int n){
        //Outer loop: moves from the end of array towards beginning
        //After each pass, the largest unsorted element "bubbles" to its correct position
        //i represents the boundary of unsorted array (shrinks with each iteration)
        for(int i=n-1; i>=0; i--){
            //Inner loop: compares adjacent elements from start to current boundary (i)
            //j iterates through unsorted portion and compares arr[j] with arr[j+1]
            for(int j=0; j<=i-1; j++){
                //If current element is greater than next element, swap them
                //This ensures larger elements move towards the end
                if(arr[j]>arr[j+1]){
                    //Swap arr[j] and arr[j+1] using temp variable
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void insertion(int arr[], int n){
        //Outer loop: iterates through each element starting from index 1
        //Element at index 0 is considered already sorted
        //i marks the current element to be inserted into the sorted portion
        for(int i=0; i<=n-1; i++){
            int j=i;
            //Inner while loop: compares current element with previous sorted elements
            //Shifts larger elements one position to the right until correct position is found
            //Condition: j>0 ensures we don't go before array start
            //arr[j-1] > arr[j] ensures we only shift if previous element is greater
            while(j>0 && arr[j-1] > arr[j]){
                //Swap current element with previous element (shifting right)
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                //Move pointer backwards to check with previous element
                j--;
            }
            //When while loop exits, element at position i is inserted in correct position
            //All elements from 0 to i are now sorted
        }
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        //take size of array
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        //take input of the array
        System.out.print("Enter the unsorted array: ");
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        //give call to the array
        // selection(arr, n);
        // bubble(arr, n);
        insertion(arr,n);

        // display the array
        System.out.print("Sorted array: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }

    }
        
}