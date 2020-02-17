//https://www.coursera.org/lecture/algorithms-part1/quick-union-ZgecU
// Weighted sum and path compression
//https://www.coursera.org/lecture/algorithms-part1/quick-union-improvements-RZW72
class UnionQuickUnion{

 private int[] qu;
 public UnionQuickUnion(int size){
   qu = new int[size];
   for(int x =0; x<qu.length; x++){
    qu[x] = x;
   }
  }
 
 public int root(int element){
 
    while(element != qu[element]){
         element = qu[element];
    }
  
  return element;
  
 }
 
 // Path Compression
  public int root1(int element){
 
    while(element != qu[element]){
         element = qu[element];
    }
  
  return element;
  
 }

 public boolean connected(int a, int b){
   return root(a) ==root(b);
 }
 
 public void union(int a, int b){
  
  int rootA = root(a);
  int rootB = root(b); 
  uf[rootA] = rootB;
 }
 
 // Weighted quick union
  public boolean union(int a, int b){
  int rootA = root(a);
  int rootB = root(b); 
   if(rootA == rootB){
    return false;
   }
   // let say we hay array that keep track of size of each tree.
   // 
   if(sz[rootA] > sz[rootB]){
    qu[rootB] = rootA;
    sz[rootA] += sz[rootB]
   }else{
    qu[rootA] = rootB;
    sz[rootB] += sz[rootA]
   }
   uf[rootA] = rootB;
   return true;
 }
 
public static void main(String args[]){
 UnionQuickUnion qUnion = new UnionQuickUnion(10);
}
}
