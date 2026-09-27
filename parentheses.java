import java.util.*;

public class parentheses {
    //Q1.Remove Outermost Parentheses
    public static String removeOuterParenthesis(String s){
        int cnt =0;
        StringBuilder ans =new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                cnt--;
            }
            if(cnt!=0){
                ans.append(s.charAt(i));
            }
            if(s.charAt(i)=='('){
                cnt++;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter parentheses string: ");
        String s = sc.nextLine();

        //Q1.Call to Remove Outermost Parentheses
        System.out.println("Result: " + removeOuterParenthesis(s));
    }

}
