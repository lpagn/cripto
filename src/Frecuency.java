import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Frecuency {
    public static void frecuencies(String str){

        HashMap<Character,Double> hash = new HashMap<>();

        for(char c : str.toCharArray()){
            if(hash.containsKey(c)){
                hash.put(c,hash.get(c)+1);
            }
            else{
                hash.put(c,1.0);
            }
        }

        hash.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue() / str.length());
        });

    }
}
