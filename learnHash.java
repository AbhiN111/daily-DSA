import java.util.*;

public class learnHash {

    public static void main(String[] args){
        int arr[] = new int[10];

        HashMap<String, Integer> map= new HashMap<>();

        map.put("china",180);
        System.out.println(map);

        for(Map.Entry<String, Integer> e : map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }
    


}
