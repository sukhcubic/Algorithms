class StringReverse {
//https://leetcode.com/problems/reverse-string/
    public void reverseString(char[] s) {
        if(s != null && s.length > 0){
           // reverseHelper(s, 0, s.length-1);
            reverseStringTwoPointer(s);
        }
    }
    
    
    private void reverseHelper(char[] s, int left, int right){
         if(left>right){
             return;
         }
        char x = s[left];
        s[left++] = s[right];
        s[right--] = x;
        reverseHelper(s, left, right);
    }
       
    public void reverseStringTwoPointer(char[] s) {
        int left = 0, right = s.length - 1;
           while(left<right){
                 char x = s[left];
                s[left++] = s[right];
                s[right--] = x;
           }
       }

}
