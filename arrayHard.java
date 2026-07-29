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
    //Print the entire Nth row
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

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //Q1.Pascal's Triangle I
        // //Given r and c, test the element at that place
        // System.out.print("Enter row number: ");
        // int r = sc.nextInt();
        // System.out.print("Enter column number: ");
        // int c = sc.nextInt();
        // long ans = nCr(r - 1, c - 1);
        // System.out.println("Element at (" + r + ", " + c + ") = " + ans); 

        // //Print the entire Nth row
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
        List<List<Integer>> ans = threeSum(arr, n);
        System.out.println("Triplets are:");
        for (List<Integer> list : ans) {
            System.out.println(list);
        }

    }
}
