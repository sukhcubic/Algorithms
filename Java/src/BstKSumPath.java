class BstKSumPath{

   void kSumPath(Node root, int k){
   
        if(root == null){
            return;
        }

        list.add(root.key);
        kSumPath(root.left, k);
        kSumPath(root.right, k);
        int target =0;
        String wrongWay = "";
      //or use stack
        for (int j = list.size() - 1; j >= 0; j--) {
            target+= list.get(j);
            wrongWay += Integer.toString(list.get(j)) + " " ;
            if(target == k) {
            	System.out.print(" result  " + wrongWay + "\n");
            }
        }
        list.remove(list.size()-1);   
   }

}
