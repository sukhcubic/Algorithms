//https://www.coursera.org/lecture/algorithms-part1/quick-union-ZgecU
class UnionQuickUnion{

 private int[] qu;
 public UnionQuickUnion(int size){
   qu = new int[size];
   for(int x =0; x<qu.length; x++){
    qu[x] = x;
   }
  }

public static void main(String args[]){
 UnionQuickUnion qUnion = new UnionQuickUnion(10);


}
}
