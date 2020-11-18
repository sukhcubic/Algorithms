import javax.print.DocFlavor;
import java.util.*;

public class GraphCourseSched1REVISIT {

    //This is based on Kahn algorithm
    // https://leetcode.com/problems/course-schedule/

    // Note: Graph can have cycle
    // https://leetcode.com/problems/course-schedule/discuss/937428/Detailed-BFS-in-degree-solution-with-Code
    //https://www.youtube.com/watch?v=DB2lyC9BiHI&feature=emb_logo

    // Note: Graph can have cycle

   //  if there is cycle then numCourses will never be equal to removedEdges. Because indegree will never be
    // zero with cycle.
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<Integer>());
        }

       // [0,1]  == 1 -> 0 1 is src 0 is dest. we will increase  indegree of dest
        int[] degree = new int[numCourses];
        for(int  i = 0; i < prerequisites.length; i++){
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            degree[prerequisites[i][1]]++;
        }

        Queue<Integer> queue= new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(degree[i] == 0){
                queue.add(i);
            }
        }

        int removedEdges = 0;
        while(!queue.isEmpty()){
            int x = queue.remove();
            for(int c : map.get(x)) {
                degree[c]--;
                if(degree[c] == 0)
                    queue.add(c);
            }
            removedEdges+=1;
        }
        return removedEdges == numCourses;
    }

    static void print(int[] a){
        for (int x:a) {
            System.out.println(x);
        }
    }

    public static void main(String arg[]){
        int num = 5;
        int [][] req = {{1, 0}, {2, 0}, {3, 2}, {4, 3},{1,4}};
        int [][] reqCycle = {{2,0}, {1,0}, {3,1}, {4,3},{4, 2}, {0,4}};

        System.out.println(canFinish(num, req));
    }
}
