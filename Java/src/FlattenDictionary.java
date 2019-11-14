import java.util.HashMap;
import java.util.Map;

//Given a nested dictionary, flatten the dictionary, where nested dictionary keys can be represented through dot notation.
//
//Example:
//Input: {
//  'a': 1,
//  'b': {
//    'c': 2,
//    'd': {
//      'e': 3
//    }
//  }
//}
//Output: {
//  'a': 1,
//  'b.c': 2,
//  'b.d.e': 3
//}
//You can assume there will be no arrays, and all keys will be strings.
//
//Here's some starter code:
//
//def flatten_dictionary(d):
//  # Fill this in.
//
//d = {
//    'a': 1,
//    'b': {
//        'c': 2,
//        'd': {
//            'e': 3
//        }
//    }
//}
//print(flatten_dictionary(d))
//# {'a': 1, 'b.c': 2, 'b.d.e': 3}
public class FlattenDictionary {

    public Map<String, String> flatten() {
    	Map<String, String> value = new HashMap();
    	
		return value;
    }
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 20, 6, 4, 5};
//		for (int i : a) {
//			System.out.println(i);
//		}
	}
}
