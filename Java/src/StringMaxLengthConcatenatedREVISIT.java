import java.util.List;

public class StringMaxLengthConcatenatedREVISIT {
    
    //https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
//     public int maxLength(List<String> arr) {

//         return getMaxLength(arr, "", 0, 0);
//     }

//     public int getMaxLength(List<String> arr, String curr, int index, int max) {

//         for (int i=index; i<arr.size(); i++) {
//             String s = arr.get(i);
//             if (!containsDup(s) && canAdd(curr, s)) {
//                 max = Math.max(max, getMaxLength(arr, curr+s, i+1, curr.length()+s.length()));
//             }
//         }
//         return max;
//     }

//     public boolean containsDup(String s) {
//         Set<Character> set = new HashSet<>();
//         for (int i=0; i<s.length(); i++) {
//             char ch = s.charAt(i);
//             if(set.contains(ch)) return true;
//             set.add(ch);
//         }
//         return false;
//     }

//     public boolean canAdd(String curr, String s) {
//         for (int i=0; i<s.length(); i++) {
//             if(curr.indexOf(s.charAt(i)) > -1) {
//                 return false;
//             }
//         }
//         return true;
//     }

        public int maxLength(List<String> arr) {

            int[] result = new int[2];
            getMaxLength(arr, "", 0, result);

            return result[0];
        }

        void getMaxLength(List<String> arr, String str, int index, int[] result){

            if(arr.size() == index && uniqueStr(str) > result[0]){
                result[0] = str.length();
                return;
            }

            if(index == arr.size()){
                return;
            }

            getMaxLength(arr, str, index+1, result);
            getMaxLength(arr, str+arr.get(index), index+1, result);

        }

        private int uniqueStr(String str) {
            int[] count = new int[26];

            for(int i=0;i<str.length();i++) {
                if (count[str.charAt(i) - 'a']++ == 1) {
                    return -1;
                }
            }

            return str.length();
        }
}
