class Solution {
//https://leetcode.com/problems/course-schedule-ii/
//https://www.youtube.com/watch?v=_LuIvEi_kZk. based on Kahn's algorithm
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        int[] sort = new int[numCourses];
         
        int[] degree = new int[numCourses];
        
        
        // create adjecy list and all the cources to it
        
        for(int i = 0; i <prerequisites.length; i++){
            
            int src = prerequisites[i][0];
                        
            int dest = prerequisites[i][1];
            
            List<Integer> list = adj.getOrDefault(src, new ArrayList<Integer>());
            
            list.add(dest);
            
            adj.put(src, list);
            
            //also since we have src available add indegee here as well
            
            degree[src] += 1;     
            
        }
        
        // now loop through the array and get elemt with in degree 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i <numCourses; i++){
            if(degree[i] == 0){
                queue.add(i);
            } 
        }
        int i = 0;
        while(!queue.isEmpty()){
            
            int node = queue.remove();
            
            sort[i++] = node;
            
            // Now visit all the children of removed element
               if (adj.containsKey(node)) {
            for(int x : adj.get(node)){
                //reduce the degree of child by 1
                degree[x]--;
                if(degree[x] == 0){
                    queue.add(x);
                }
            
            }
               }
            
        }
        
            // Check to see if sort sort is possible or not.

        if(i == numCourses){
            return sort;
        }
        
        //otherwise return empty;
        return new int[0];
        
    }
}
