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

    //Q4.Two Sum
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

    //Q5.Sort an array of 0's 1's and 2's(better)
    public static void sortArray(int arr[], int n){
        int cnt0=0;
        int cnt1=0;
        int cnt2=0;
        for(int i =0; i<n; i++){
            if(arr[i]==0){
                cnt0++;
            }else if(arr[i]==1){
                cnt1++;
            }else{
                cnt2++;
            }
        }

        for(int i=0; i<cnt0;i++){
            arr[i]=0;
        }
        for(int i=cnt0; i<cnt0+cnt1;i++){
            arr[i]=1;
        }
        for(int i=cnt0+cnt1; i<n;i++){
            arr[i]=2;
        }
    }

    //Q5.Sort an array of 0's 1's and 2'(optimal)
    public static void sortArray2(int arr[], int n){
        int low =0;
        int mid=0;
        int high=n-1;
        while(mid<=high){
            if(arr[mid]==0){
                int temp= arr[low];
                arr[low] = arr[mid];
                arr[mid]= temp;
                low++;
                mid++;
            }else if (arr[mid]==1) {
                mid++;
            }else {
                int temp= arr[mid];
                arr[mid] = arr[high];
                arr[high]= temp;
                high--;
            }
        }
    }

    //Q6.Majority Element-I(better)
    public static int majorityElement( int arr[],int n){
        HashMap<Integer,Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry: mpp.entrySet()){
            if(entry.getValue()>n/2){
                return entry.getKey();
            }
        }
        return -1;
    }

    //Q6.Majority Element-I(optimal)
    public static int majorityElement2( int arr[],int n){
        int cnt =0;
        int el=0;
        for(int i =0;i<n; i++){
            if(cnt==0){
                cnt=1;
                el=arr[i];
            }else if(arr[i]==el){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        int cnt1=0;
        for(int i =0;i<n;i++){
            if(arr[i]==el) cnt1++;
        }
        if(cnt1> n/2) {
            return el;
        }
        return -1;
    }

    //Q7.Kadane's Algorithm(Better)
    public static int maxSubArray(int[] arr, int n){
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                maxi =Math.max(maxi , sum);
            }
        }
        return maxi;
    }

    //Q7.Kadane's Algorithm(ooptimal-V1)
    public static int maxSubArray2(int[] arr, int n) {

        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxi;
    }

    //Q7.Kadane's Algorithm(ooptimal-V2)
    public static int maxSubArray3(int[] arr, int n) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < n; i++) {
            if (sum == 0) {
                start = i;
            }

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.print("Maximum Subarray: ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return maxi;
    }

    //Q8.Stock Buy and Sell
    public static int maximumPorfit(int arr[], int n){
        int mini = arr[0];
        int maxprofit=0;
        for(int i=0; i<n; i++){
            int cost = arr[i]- mini;
            maxprofit= Math.max(maxprofit, cost);
            mini =Math.min(mini, arr[i]);
        }
        return maxprofit;
    }

    //Q9.Rearrange array elements by sign(pos=neg)
    public static int[] rearrangeArray(int arr[], int n){
        int pos=0, neg=1;
        int ans[]= new int[n];
        for(int i =0; i<n; i++){
            if(arr[i]<0){
                ans[neg]=arr[i];
                neg +=2;
            }else{
                ans[pos] =arr[i];
                pos+=2;
            }
        }
        return ans;
    }

    //Q9.Rearrange array elements by sign(pos!=neg)
    public static int[] alternateNumber(int arr[],int n){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i=0; i<n;i++){
            if(arr[i]>0){
                pos.add(arr[i]);
            }else{
                neg.add(arr[i]);
            }
        }

        if (pos.size() > neg.size()) {

        for (int i = 0; i < neg.size(); i++) {
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
        }
        int index = neg.size() * 2;
        for (int i = neg.size(); i < pos.size(); i++) {
            arr[index] = pos.get(i);
            index++;
        }
        }else {
            for (int i = 0; i < pos.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(i);
                index++;
            }
        }
        return arr;
    }

    //Q10.Next Permutation
     public static void nextPermutation(int[] arr, int n){
        int ind = -1;
        for(int i=n-2; i>=0; i--){
            if(arr[i]< arr[i+1]){
                ind = i;
                break;
            }
        }
        if(ind==-1){
            reverse(arr,0,n-1);
            return;
        }

        for(int i=n-1; i> ind; i--){
            if(arr[i]>arr[ind]){
                int temp = arr[i];
                arr[i]=arr[ind];
                arr[ind]=temp;

                break;
            }
        }
        reverse(arr, ind + 1, n - 1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
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

        // //Q2.Call to Longest subarray with given sum K(positives)
        // System.out.print("Enter the value of k: ");
        // int k =sc.nextInt();
        // System.out.println("Longest subarray with given sum is: " + longestSubArrayWithSumK(arr, k, n));        
        // //Q3.Longest subarray with given sum K(positives,negatives, zeroes)
        // System.out.println("Longest subarray with given sum is: "+ longestSubarrayWithSumK2(arr, k, n));
        // //Q4.Call to two sum
        // System.out.println(twoSum(arr, n, k));

        // //Q4.Call to Sort an array of 0's 1's and 2's(better)
        // sortArray(arr, n);
        // //Q4.Call to Sort an array of 0's 1's and 2's(optimal)
        // sortArray2(arr, n);
        // System.out.println("Sorted Array:");
        // for (int i = 0; i < n; i++) {
        //     System.out.print(arr[i] + " ");
        //}


        // //Q6.Call to Majority Element-I(better)
        // System.out.println("Majority Element: " + majorityElement(arr, n));
        // //Q6.Call to Majority Element-I(optimal)
        // System.out.println("Majority Element: " + majorityElement2(arr, n));

        // //Q7.Kadane's Algorithm(Better)
        // System.out.println("Maximum Subarray Sum = " + maxSubArray(arr, n));
        // //Q7.Kadane's Algorithm(optimal-V1)
        // System.out.println("Maximum Subarray Sum = " + maxSubArray2(arr, n));
        // //Q7.Kadane's Algorithm(optimal-V2)
        // System.out.println("Maximum Subarray Sum = " + maxSubArray3(arr, n));

        // //Q8.Call to Stock Buy and Sell
        // System.out.println("Maximum Profit = " + maximumPorfit(arr, n));

        // //Q9.Rearrange array elements by sign(pos=neg)
        // int[] ans = rearrangeArray(arr, n);        
        // System.out.println("Rearranged Array:");
        // for (int i = 0; i < ans.length; i++) {
        //     System.out.print(ans[i] + " ");
        // };

        // //Q9.Rearrange array elements by sign(pos=neg)
        // int[] anss = alternateNumber(arr, n);        
        // System.out.println("Rearranged Array:");
        // for (int i = 0; i < anss.length; i++) {
        //     System.out.print(anss[i] + " ");
        // };

        //Q10.Cal to Next Permutation
        nextPermutation(arr, n);
        System.out.println("Next Permutation:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        };
    }
}
