//https://www.coursera.org/lecture/algorithms-part1/quick-union-ZgecU
class UnionQuickUnion{

 private int[] qu;
 public UnionQuickUnion(int size){
   qu = new int[size];
   for(int x =0; x<qu.length; x++){
    qu[x] = x;
   }
  }
 
 public int root(int element){
 
  
  
 }

 public boolean connected(int a, int b){
   return root(a) ==root(b);
 }
 
 public void union(int a, int b){
 
 }
 
public static void main(String args[]){
 UnionQuickUnion qUnion = new UnionQuickUnion(10);


}
}
