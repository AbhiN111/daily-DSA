//Integer hashing
// import java.util.Scanner;

// public class Hashing {
    
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);

//         int[] hash = new int[10000];

//         System.out.print("Enter size of the array: ");
//         int n = sc.nextInt();

//         System.out.print("Enter array of size n: ");
//         int[] arr = new int[n];

//         for(int i=0; i<n;i++){
//             arr[i] = sc.nextInt();
//         }

//         for (int i = 0; i < n; i++) {
//             hash[arr[i]]++;
//         }

//         System.out.print("Enter number of queries: ");
//         int q = sc.nextInt();

//         while(q-->0){
//             System.out.println("Enter number to find frequency: ");
//             int number = sc.nextInt();
//             System.out.print("Size of the " + number +" is: "+ hash[number]);
//         }
//     }
// }


//Character Hashing
// import java.util.Scanner;

// public class Hashing{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter a string: ");
//         String s =sc.next();

//         int[] hash = new int[256]; //for capital or small letter, take 26, for both take 256
//         for (int i=0; i<s.length(); i++){
//             hash[s.charAt(i)]++; //for capital letter its hash[s.charAt(i) - 'A']++ and for small letter its hash[s.charAt(i) - 'a']++
//         }

//         System.out.print("Enter number of Queries: ");
//         int q = sc.nextInt();

//         while(q-->0){
//             char c= sc.next().charAt(0);

//             System.out.println("Frequency of " + c + " is: " + hash[c]);
//         }
//     }
// }


//Interger Hashing using HashMap
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Scanner;

// public class Hashing {

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter size of the array: ");
//         int n = sc.nextInt();

//         int[] arr = new int[n];

//         System.out.println("Enter " + n + " elements:");
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         // Pre-compute frequencies
//         HashMap<Integer, Integer> mpp = new HashMap<>();

//         for (int i = 0; i < n; i++) {
//             mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
//         }

//         // Print all frequencies
//         System.out.println("\nElement -> Frequency");
//         for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
//             System.out.println(entry.getKey() + " -> " + entry.getValue());
//         }

//         // Queries
//         System.out.print("\nEnter number of queries: ");
//         int q = sc.nextInt();

//         while (q-- > 0) {
//             System.out.print("Enter number: ");
//             int number = sc.nextInt();

//             System.out.println("Frequency: " + mpp.getOrDefault(number, 0));
//         }

//         sc.close();
//     }
// }


//Character hashing using HashMap
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        // Pre-compute character frequencies
        HashMap<Character, Integer> mpp = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        // Print all character frequencies
        System.out.println("\nCharacter -> Frequency");
        for (Map.Entry<Character, Integer> entry : mpp.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Queries
        System.out.print("\nEnter number of queries: ");
        int q = sc.nextInt();

        while (q-- > 0) {
            System.out.print("Enter character: ");
            char ch = sc.next().charAt(0);

            System.out.println("Frequency: " + mpp.getOrDefault(ch, 0));
        }

        sc.close();
    }
}