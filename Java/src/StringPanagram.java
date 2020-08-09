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


    static String pangrams(String s) {

        // It can be a text file or just one string. If one string do not use below regex code.
        String s1[] = s.split("\\?|\\.|\\!");
        String found = "";
        for (String s2: s1) {
            if(isPanagram(s2)){
                found = s2;
                break;
            }
        }
        return found;
    }
    public static void main(String args[]){
        String s1 = "Bkakakakakkakakakkas sksaksa;sads. The quick brown fox jumps over the lazy dog. skks ksksk ksksk ksksk ksksksdk ksdfsdklfklsdvksn. askdkasfnldsafsdlkfsdkfksdfnkklkdsk ";
       // System.out.println(isPanagram(s1));
        System.out.println(pangrams(s1));
    }
}

