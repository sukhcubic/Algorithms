public class MoveElementsToEnd {

    public static List<Integer> move(List<Integer> array, int toMove){
        int length = array.size() -1;

        for(int i =0; i <= length; i++){

            if(array.get(i) == toMove && array.get(length) != toMove) {
                Collections.swap(array, i,length--);
//TODO remove element
//                int lastValue = array.get(length);
//                array.add(length--, toMove);
//                array.add(i, lastValue);
            } else{
                length = length-1;
                if(length > 0){
                    Collections.swap(array, i,length);
                }
            }
        }
        return array;
    }

    public static void main(String arg[]){
        List<Integer> ints = new ArrayList<>();
        ints.add(2);
        ints.add(1);
        ints.add(2);
        ints.add(2);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(2);

        for (Integer value: MoveElementsToEnd.move(ints, 2)) {
            System.out.println( value.intValue());
        }
    }
}
