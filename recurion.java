//Print name n times using recursion
import java.util.Scanner;

// public class recurion {
//     // static int n = 0;

//     public static void print(int n, String name){
//         if(n==0) return;
//         System.out.println(name);
//         print(n-1, name);
//     }

//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter a number: ");
//         int n= sc.nextInt();

//         System.out.print("Enter the name to be print: ");
//         String name =sc.next();

//         print(n, name);
//     }
// }

//Print n to 1 number using recursion

// public class recurion {
//     // static int n = 0;

//     public static void print(int n){
//         if (n==0) return;
//         System.out.println(n);
//         print(n-1);
//     }

//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter a number: ");
//         int n= sc.nextInt();

//         print(n);
//     }
// }

//Print 1 to n number using recursion

// public class recurion {
//     // static int n = 0;

//     public static void print(int n){
//         if (n<=0) return;
//         print(n-1);
//         System.out.println(n); 
//     }

//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter a number: ");
//         int n= sc.nextInt();
        
//         print(n);
//     }
// }

//Print first n numbers(paramterized way)

// public class recurion {

//     public static void print(int n, int sum){
//         if (n<0){
//             System.out.println(sum);
//             return;
//         }     
//         print(n-1, sum+ n); 
//     }

//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter a number: ");
//         int n= sc.nextInt();
        
//         print(n, 0);
//     }
// }

//Print first n numbers(Functional way)

// public class recurion {

//     public static int print(int n){
//         if (n == 0){
//             return 0;
//         }

//         return n + print(n-1); 
    
//     }

//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter a number: ");
//         int n= sc.nextInt();
        
//         System.out.println("Sum = " + print(n));
//     }
// }

//Reverse an array using recursion

// public class recurion {

//     public static void print(int i, int arr[], int n){
//         if (i >= n / 2) {
//             return;
//         }

//         int temp = arr[i];
//         arr[i] = arr[n-i-1];
//         arr[n-i-1] = temp;
//         print(i+1, arr, n);
//     }

//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter array size: ");
//         int n = sc.nextInt();

//         int[] arr = new int[n];
//         System.out.println("Enter array elements:");
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         print(0, arr, n);

//         System.out.println("Reversed array:");
//         for (int i = 0; i < n; i++) {
//             System.out.print(arr[i] + " ");
//         }
//     }
// }

//Check a string is palindrome or not using recursion

// public class recurion {

//     public static boolean print(int i, String s){
//         if (i >= s.length() / 2) {
//             return true;
//         }
//         if(s.charAt(i) != s.charAt(s.length() - i - 1)){
//             return false;
//         }

//         return print(i+1, s);
        
//     }

//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter a string: ");
//         String s =sc.next();

//         System.out.println(print(0,s));

//     }
// }


//Fibonnaci number

public class recurion {

    public static int print(int n){
        if (n<=1){
            return n;
        }
        int last=(n-1);
        int slast= (n-2);
        // int fibo = last + slast;
        return last + slast;  
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n= sc.nextInt();

        System.out.println(print(n));
        
    }
}