import java.util.*;

public class arrayMedium {
    
    //Q1.Find the number that appears once, and other numbers twice.
    public static int getSingleElement(int arr[], int n){
        int xor =0;
        for(int i =0; i<n;i++){
            xor = xor ^ arr[i];
        }
        return xor;
    }

    //Q2.Longest subarray with given sum K(positives)
    public static int longestSubArrayWithSumK(int arr[], long k, int n){
        int left = 0, right =0;
        long sum = arr[0];
        int maxLen= 0;
        while(right<n){
            while(left<=right && sum>k){
                sum-=arr[left];
                left++;
            }
            if(sum==k){
                maxLen=Math.max(maxLen, right -left+1);
            }
            right++;
            if(right<n)
            sum+=arr[right];
        }
        return maxLen;
    }

    //Q3.Longest subarray with given sum K(positives,negatives, zeroes)
    public static int longestSubarrayWithSumK2(int[] arr, int k, int n) {
        HashMap<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            long rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }

    //Q3.Two Sum
    public static String twoSum(int arr[], int n, int k){
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i =0; i<n; i++){
            int a = arr[i];
            int more = k -a;
            if(mpp.containsKey(more)){
                return "YES";
            }
            mpp.put(a,i);
        }
        return "NO";
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        // //Q1.Call to number that appears once, and other numbers twice.
        // System.out.println("Number that appears once is: " + getSingleElement(arr, n));

        //Q2.Call to Longest subarray with given sum K(positives)
        System.out.print("Enter the value of k: ");
        int k =sc.nextInt();
        System.out.println("Longest subarray with given sum is: " + longestSubArrayWithSumK(arr, k, n));        
        //Q3.Longest subarray with given sum K(positives,negatives, zeroes)
        System.out.println("Longest subarray with given sum is: "+ longestSubarrayWithSumK2(arr, k, n));
        //Call to two sum
        System.out.println(twoSum(arr, n, k));
    }
}
