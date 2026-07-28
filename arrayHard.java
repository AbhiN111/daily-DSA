import java.util.*;

public class arrayHard {
    public static long nCr( int n, int r){
        long res=1;
        for(int i=0; i<r;i++){
            res= res*(n-i);
            res= res/(i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        //Q1.Pascal's Triangle I
        //Given r and c, test the element at that place

        System.out.print("Enter row number: ");
        int r = sc.nextInt();

        System.out.print("Enter column number: ");
        int c = sc.nextInt();

        long ans = nCr(r - 1, c - 1);

        System.out.println("Element at (" + r + ", " + c + ") = " + ans);

        
    }
}
