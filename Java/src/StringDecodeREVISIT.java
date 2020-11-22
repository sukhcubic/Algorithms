class StringDecodeREVISIT{
//https://leetcode.com/problems/decode-string/

/ https://leetcode.com/problems/decode-string/


    static String decoder(String s){
        Stack<String> string = new Stack<>();
        Stack<Integer> count = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        String soFar = "";
        for (char ch : s.toCharArray()) {
            // we need to convert char to digit and also digit can be more than one.i.e 3 or 33 or 333
            if(Character.isDigit(ch)){
                //if ch is more than one it will append to it and will reset to 0 in next step
                k = k*10 + ch - '0';
                // is '['
            }else if(ch == '['){
                // This is the main working horse. 1.add K to stack 2.reset k 3. reset sofar string becasue
                // this will not repeat but next one will and that will go on top of stak and will be popped
                string.push(soFar);
                soFar = "";

                count.push(k);
                k = 0;

                // is ']'
            }else if(ch == ']'){
                // Take string that is build soFar in else and append to String builder

                //NOTE: String builder is better that String when appending large Strings coz string is immutable.
                int x = count.pop();
                 String sx = string.pop();
                 boolean sss  = string.isEmpty();
                StringBuilder ss = new StringBuilder();
                for(int i = 0; i<x; i++){
                    ss.append(soFar);
                }
                sb.append(ss.toString());
            }else{
                soFar += ch;
            }
        }

        return sb.toString();

    }
//
//    static String helper(String s, int index){
//
//        String ss = "";
//
//        while ()
//
//
//        return s;
//    }
    public static void main(String arg[]){
        //String s = "a3[b2[c]]";
        //String s = "a3[b]";

        String s = "3[a]2[bc]";
        System.out.println(decoder(s));
    }

}
