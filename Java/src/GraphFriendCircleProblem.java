
import java.util.LinkedList;
import java.util.Queue;
//Explanation: https://leetcode.com/problems/friend-circles/solution/
public class GraphFriendCircleProblem {

    //BFS
    public int numberOfFriendsCircle(int[][] sz){
        boolean[] visited = new boolean[sz.length];
        int num = 0;
        Queue< Integer > queue = new LinkedList< >();
        // length of matrix
        for (int i = 0; i< sz.length ; i++){
            if(visited[i] == false){
                queue.add(i);
                while (!queue.isEmpty()){
                    int element = queue.remove();
                    visited[element] = true;
                    for (int j = 0; j< sz.length ; j++) {
                        if (sz[element][j] != 0 && visited[j] == false) {
                            queue.add(j);
                        }
                    }
                }
                num++;
            }
        }
        return num;
    }

     int friendsDFS(int[][] matrix){
        boolean[] visited = new boolean[matrix.length];
        int num = 0;
        for (int i = 0; i <matrix.length; i++){
            if(visited[i] == false){
                dfsHelper(matrix, visited, i);
                num++;
            }
        }
        return num;
    }

     void dfsHelper(int[][] matrix, boolean[] viisited, int node){
        for (int i = 0; i<matrix.length; i++) {
            if (matrix[node][i]== 1 && viisited[i] == false) {
                viisited[i] = true;
                dfsHelper(matrix,viisited,i);
            }
        }
    }

    public static void main(String args[]){

        GraphFriendCircleProblem circleProblem = new GraphFriendCircleProblem();


        int [][] mz = {{0,1,0,0},
                       {1,0,1,0},
                       {0,0,0,0},
                       {0,1,1,0}};

        System.out.println(circleProblem.numberOfFriendsCircle(mz));

        System.out.println(circleProblem.friendsDFS(mz));

    }

}
