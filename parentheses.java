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

    //Q2.Maximum Nesting Depth of the Parentheses
    public static int maxDepth(String s){
        int max=0;
        int cnt=0;
        for(int i =0;i<s.length();i++){
            
            if(cnt > max){
                max=cnt;
            }

            if(s.charAt(i)=='('){
                cnt++;
            }
            
            if(s.charAt(i)==')'){
                cnt--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        // //Q1.Call to Remove Outermost Parentheses
        // System.out.print("Enter parentheses string: ");
        // String s = sc.nextLine();
        // System.out.println("Result: " + removeOuterParenthesis(s));

        //Q2.Call to Maximum Nesting Depth of the Parentheses
        System.out.print("Enter string: ");
        String s = sc.nextLine();
        int result = maxDepth(s);
        System.out.println("Maximum Depth: " + result);
    }

}
