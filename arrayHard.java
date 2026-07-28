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


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

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

        //
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> ans = pascalTriangle(n);
        for (ArrayList<Integer> row : ans) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
