import java.util.Scanner;

public class basicMath {
    public static void countDigit(int n){
    
        int count=0;
        while(n>0){
            // int lastDigit=n%10;
            count +=1;
            n=n/10;
        }
        System.out.println(count);
    }

    public static void reverse(int n){
        int revnum =0;
        while(n>0){
            int lastdigit = n%10;
            n= n/10;
            revnum= (revnum *10)+ lastdigit;
        }
        System.out.println(revnum);
    }

    public static void palindrome(int n){
        int dup = n;
        int revnum =0;
        while(n>0){
            int lastdigit = n%10;
            n= n/10;
            revnum= (revnum *10)+ lastdigit;
        }
    if(revnum==dup){
        System.out.println("true");
    }
    else{
        System.out.println("false");
    }      
    }

    public static void armstrong(int n){
        int dup = n;
        int sum = 0;
        while(n>0){
            int lastDigit = n%10;
            n= n/10;
            sum = sum + (lastDigit*lastDigit*lastDigit);
        }
        if(dup==sum){
            System.out.println(" The number is armstrong");
        }
        else{
            System.out.println("It is not a armstrong");
        }
    }

    public static void divisor1(int n){
        System.out.print("Divisors of the number are: ");
        for(int i=1; i<=n; i++){
            if(n%i==0){
            System.out.print(i + " ");               
            }
        }
    }

    public static void divisor2(int n){
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i==0){
                System.out.print(i + " ");
                if((n/i) != i){
                    System.out.print(n/i + " ");
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the some number: ");
        int n =sc.nextInt();
        // countDigit(n);
        // reverse(n);
        // palindrome(n);
        // armstrong(n);
        // divisor1(n); //method 1
        divisor2(n); //method 2
    }
}
