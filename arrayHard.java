import java.util.*;

public class arrayHard {
    //Q1.Pascal's Triangle I
    //Given r and c, test the element at that place
    public static long nCr( int n, int r){
        long res=1;
        for(int i=0; i<r;i++){
            res= res*(n-i);
            res= res/(i+1);
        }
        return res;
    }

    //Q1.Pascal's Triangle I
    //Print the entire Nth row
    public static void printRow(int n) {
        int ans = 1;
        System.out.print(ans + " ");

        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
    }

    //Q1.Pascal's Triangle I
    //Print the complete Pascal Triangle up to N rows
    public static int nCr2(int n, int r) {
        int ans = 1;
        for (int i = 0; i < r; i++) {
            ans = ans * (n - i);
            ans = ans / (i + 1);
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> pascalTriangle(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int col = 1; col <= row; col++) {
                temp.add(nCr2(row - 1, col - 1));
            }
            ans.add(temp);
        }
        return ans;
    }

    //Q2.Majority Element-II(better)
    public static List<Integer> majorityElement( int arr[], int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int min=(n/3)+1;

        for(int i =0;i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            
            if (map.get(arr[i]) == min) {
                ans.add(arr[i]);
            }

            if(ans.size()==2) break;
        }
        Collections.sort(ans);
        return ans;
    }

    //Q2.Majority Element-II(optimal)
     public static List<Integer> majorityElement2(int[] nums, int n) {
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && nums[i] != ele2) {
                cnt1 = 1;
                ele1 = nums[i];
            }
            else if (cnt2 == 0 && nums[i] != ele1) {
                cnt2 = 1;
                ele2 = nums[i];
            }
            else if (nums[i] == ele1) {
                cnt1++;
            }
            else if (nums[i] == ele2) {
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == ele1)
                cnt1++;
            else if (nums[i] == ele2)
                cnt2++;
        }
        List<Integer> ans = new ArrayList<>();
        int min = (n / 3) + 1;

        if (cnt1 >= min)
            ans.add(ele1);
        if (cnt2 >= min)
            ans.add(ele2);
        return ans;
    }


    //Q3.3 sum(better)
    public static List<List<Integer>> threeSum(int arr[], int n){
        Set<List<Integer>> st= new HashSet<>();
        for(int i =0;i<n;i++){
            HashSet<Integer> hashSet = new HashSet<>();
            for(int j =i+1;j<n;j++){
                int third = -(arr[i]+arr[j]);
                if(hashSet.contains(third)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    st.add(temp);
                }
                hashSet.add(arr[j]);
            }
        }
        return new ArrayList<>(st);
    }

    //Q3.3 sum(optimal)
    public static List<List<Integer>> threeSum2(int arr[], int n){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i<n ;i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = arr[i] +arr[j]+arr[k];

                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);

                    ans.add(temp);
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j - 1])
                        j++;

                    while (j < k && arr[k] == arr[k + 1])
                        k--;
                }
            }
        }
        return ans;
    }

    //Q4 4 Sum(Better)
    public static List<List<Integer>> fourSum(int arr[], int n, int target) {
        Set<List<Integer>> st = new HashSet<>();
        for(int i =0; i<n ;i++){
            for(int j= i+1;j<n;j++){
                HashSet<Long> hashSet= new HashSet<>();
                for(int k =j+1;k<n;k++){
                    long sum = arr[i]+ arr[j] +arr[k];
                    long fourth = target - sum;

                    if(hashSet.contains(fourth)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add((int)fourth);

                        Collections.sort(temp);
                        st.add(temp);
                    }
                    hashSet.add((long) arr[k]);
                }
            }
        }
        return new ArrayList<>(st);
    }

    //Q4. 4 Sum(optimal)
    public static List<List<Integer>> fourSum2(int arr[], int n, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for(int i=0; i<n;i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            for(int j =i+1; j<n;j++){
                if(j>i+1 && arr[j] == arr[j-1]) continue;
                
                int k = j+1;
                int l = n-1;

                while(k<l){
                    long sum =0;
                    sum+=arr[i];
                    sum+=arr[j];
                    sum+=arr[k];
                    sum+=arr[l];

                    if(sum == target){
                        ans.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k - 1])
                            k++;
                        while (k < l && arr[l] == arr[l + 1])
                            l--;
                    }else if (sum <target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return ans;
    }


    //Q6.Largest Subarray with Sum 0
    public static int maxLen(int arr[], int n){
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int maxi =0;
        int sum=0;
        for(int i =0; i<n; i++){
            sum += arr[i];
            if(sum== 0){
                maxi=i+1;
            }
            else{
                if(mpp.get(sum)!= null){
                    maxi=Math.max(maxi, i - mpp.get(sum));
                }
                else{
                    mpp.put(sum,i);
                }
            }
        }
        return maxi;
    }

    

    //Q5.Count subarrays with given xor K(optimal)
    public static int  subarraysWithXorK(int arr[], int n, int k){
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int xr=0;
        int cnt =0;
        mpp.put(0,1);
        for(int i =0;i<n; i++){
            xr = xr ^arr[i];
            int x = xr^k;
            cnt += mpp.getOrDefault(x,0 );
            mpp.put(xr, mpp.getOrDefault(xr, 0) + 1);
        }
        return cnt;
    }

    //Q6.Count subarrays with given xor K(better)
    public static int maxSubArray(int arr[], int n, int k){
        int cnt=0;
        for(int i=0; i<n;i++){
            int xor =0;
            for(int j =i; j<n; j++){
                xor = xor ^ arr[j];
                if(xor == k) cnt++;
            }
        }
        return cnt;
    }

    //Q7.Merge Overlapping Subintervals(brute)
    public static List<List<Integer>> mergeIntervals(int[][] arr) {
        int n = arr.length;

        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1))
                continue;   

            for (int j = i + 1; j < n; j++) {

                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }

    //Q7.Merge Overlapping Subintervals(optimal)
    public static int[][] mergeIntervals2(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(new int[]{arr[i][0], arr[i][1]});
            } else {
                ans.get(ans.size() - 1)[1] =
                        Math.max(ans.get(ans.size() - 1)[1], arr[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    //Q8.Merge two sorted arrays without extra space(better)
    public static void merge(long[] arr1, long[] arr2){
        int n = arr1.length;
        int m= arr2.length;
        int left =n-1;
        int right=0;
        while(left>=0 && right<m){
            if(arr1[left] >  arr2[right]){
                long temp = arr1[left];
                arr1[left] =arr2[right];
                arr2[right] =temp;
                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);      
    }

    //Q8.Merge two sorted arrays without extra space(optimal)
    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2){
        if (arr1[ind1] > arr2[ind2]){
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public static void merge2(long[] arr1, long[] arr2, int n, int m){
        int len = (n+m);
        int gap =(len/2) + (len%2);
        while(gap>0){
            int left =0;
            int right = left + gap;
            while(right<len){
                if(left<n && right>=n){
                    swapIfGreater(arr1, arr2, left, right - n);
                }else if(left>=n){
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }else{
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap=(gap/2) + (gap%2);
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        // System.out.print("Enter size of array: ");
        // int n = sc.nextInt();

        // int[] arr = new int[n];

        // System.out.println("Enter array elements:");
        // for (int i = 0; i < n; i++) {
        //     arr[i] = sc.nextInt();
        // }

        //Q1.Pascal's Triangle I
        // //Given r and c, test the element at that place
        // System.out.print("Enter row number: ");
        // int r = sc.nextInt();
        // System.out.print("Enter column number: ");
        // int c = sc.nextInt();
        // long ans = nCr(r - 1, c - 1);
        // System.out.println("Element at (" + r + ", " + c + ") = " + ans); 

        // // //Print the entire Nth row
        // System.out.print("Enter row number: ");
        // int n = sc.nextInt();
        // printRow(n);

        // //Print the complete Pascal Triangle up to N rows
        // System.out.print("Enter number of rows: ");
        // int n = sc.nextInt();
        // ArrayList<ArrayList<Integer>> ans = pascalTriangle(n);
        // for (ArrayList<Integer> row : ans) {
        //     for (int num : row) {
        //         System.out.print(num + " ");
        //     }
        //     System.out.println();
        // }

        // //Q2.Call to Majority Element-II(better)
        // List<Integer> ans1 = majorityElement(arr, n);
        // System.out.println("Majority Elements (> n/3 times): " + ans1);
        // //Q2.Call to Majority Element-II(optimal)
        // List<Integer> ans2 = majorityElement(arr, n);
        // System.out.println("Majority Elements (> n/3 times): " + ans2);

        //Q3.Call to 3 sum(better)
        // List<List<Integer>> ans1 = threeSum(arr, n);
        // System.out.println("Triplets are:");
        // for (List<Integer> list : ans1) {
        //     System.out.println(list);
        // }
        // //Q3.Call to 3 sum(optimal)
        // List<List<Integer>> ans2 = threeSum(arr, n);
        // System.out.println("Triplets are:");
        // for (List<Integer> list : ans2) {
        //     System.out.println(list);
        // }

        // //Q4.4 sum(better)
        // System.out.print("Enter target: ");
        // int target = sc.nextInt();
        // List<List<Integer>> ans = fourSum(arr,n, target);
        // System.out.println("Quadruplets are:");
        // for (List<Integer> list : ans) {
        //     System.out.println(list);
        // }
        // //Q4.4 sum(optimal)
        // System.out.print("Enter target: ");
        // int target = sc.nextInt();
        // List<List<Integer>> ans = fourSum2(arr, n, target);
        // System.out.println("Quadruplets are:");
        // if (ans.isEmpty()) {
        //     System.out.println("No quadruplets found.");
        // } else {
        //     for (List<Integer> list : ans) {
        //         System.out.println(list);
        //     }
        // }

        // //Q5.Call to Largest Subarray with Sum 0
        // System.out.println("Length of longest subarray with sum 0 = " + maxLen(arr, n));

        // //Q6.Call to Count subarrays with given xor K(better)
        // System.out.print("Enter value of K: ");
        // int k = sc.nextInt();
        // System.out.println("Number of subarrays with XOR " + k + " = " + maxSubArray(arr, n, k));
        // //Q5.Count subarrays with given xor K(optimal)
        // System.out.println("Number of subarrays with XOR " + k + " = " + subarraysWithXorK(arr, n, k));

        // //Q7.Call to Merge Overlapping Subintervals(brute)
        // System.out.print("Enter number of intervals: ");
        // int n = sc.nextInt();
        // int[][] arr = new int[n][2];
        // System.out.println("Enter intervals:");
        // for (int i = 0; i < n; i++) {
        //     arr[i][0] = sc.nextInt();
        //     arr[i][1] = sc.nextInt();
        // }
        // List<List<Integer>> ans = mergeIntervals(arr);
        // System.out.println("Merged Intervals:");
        // for (List<Integer> interval : ans) {
        //     System.out.println(interval);
        // }
        // //Q7.Call to Merge Overlapping Subintervals(optimal)
        // int[][] ans1 = mergeIntervals2(arr);
        // System.out.println("Merged Intervals:");
        // for (int[] interval : ans1) {
        //     System.out.println(Arrays.toString(interval));
        // }

        //Q8.Call to Merge two sorted arrays without extra space(better)
        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();
        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();
        long[] arr1 = new long[n];
        long[] arr2 = new long[m];
        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        merge(arr1, arr2);
        System.out.println("First Array after merge:");
        System.out.println(Arrays.toString(arr1));
        System.out.println("Second Array after merge:");
        System.out.println(Arrays.toString(arr2));
        //Q8.Call to Merge two sorted arrays without extra space(optimal)
        merge2(arr1, arr2,n,m);
        System.out.println("First Array:");
        System.out.println(Arrays.toString(arr1));
        System.out.println("Second Array:");
        System.out.println(Arrays.toString(arr2));
    }
}

