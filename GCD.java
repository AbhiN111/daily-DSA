import java.util.Scanner;

public class GCD {
    public static void greatestFactor(int a, int b){
        while(a>0 && b>0){
            if(a>b){
                a = a%b;
            }
            else{
                b=b%a;
            }

            if(a==0){
                System.out.println(b);
            } 
            else{
                System.out.println(a);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter the value of first number: ");
        int a= sc.nextInt();

        System.out.print("enter the value of second number: ");
        int b= sc.nextInt();

        System.out.print("GCD of two numbes is: ");
        greatestFactor(a, b);
    }
    
}
