import java.util.HashMap;
import java.util.Map;

public class StringPanagram {
    //Panagram contains every letter of the alphabet.
    static boolean isPanagram(String s){
        if(s.length()<26){
            return false;
        }
        char[] chars = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (char ch:chars) {
            map.put(ch, ch);
        }
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (char c: alphabet) {
            Character upper = Character.toUpperCase(c);
            if(!map.containsKey(c) && !map.containsKey(upper)){
                return false;
            }
        }
        return true;
    }

    //Generate panagram string from text
    static String pangrams(String s) {


        return " ";
    }
    public static void main(String args[]){
        String s1 = "The quick brown fox jumps over the lazy dog";
        System.out.println(isPanagram(s1));
    }
}
