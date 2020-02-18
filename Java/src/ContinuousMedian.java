//Explanation: https://www.youtube.com/watch?v=1CxyVdA_654
// https://www.youtube.com/watch?v=VmogG01IjYc&t=408s
class ContinuousMedian{

 // Todo: Setup max priority queue
 PriorityQueue<Integer> max = new PriorityQueue<>();
 PriorityQueue<Integer> min = new PriorityQueue<>();
 public void add(int val){
  if(max.size() == 0){
   max.add(val);
  }
  
  if(val > max.peek() ){
   min.add(val);
  }else{
   max.add(val);
  }
  adjust();
 }
 
 public void adjust(){
  if(Math.abs(max.size() -min.size()) >=2){
    if(max.size() > min.size()){
     min.add(max.remove());
    }else{
     max.add(min.remove());
    }
  }else{
   return;
  }
 }
 
 public double getMedian(){
  if(max.size() == min.size()){
   return  (max.peek() + min.peek())/2;
  }else{
   return max.size()>min.size()? max.peek():min.peek();
  }
 }
}
