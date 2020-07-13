import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://medium.com/@codingfreak/maze-problems-in-data-structures-8530af4d6c8

public class MazeProblem {


    //Assume start is 0,0 otherswise has to pass start index
    private void findPath(int[][] maze) {
        int row = 0, col = 0;
        Map<String, Boolean> path = new HashMap();
        boolean haspath = helper(maze, row, col, path);
        System.out.println( "Has path = " + haspath);
        //return path;
    }

    private boolean helper(int[][] maze, int row, int column, Map<String, Boolean> path){
        System.out.println(" row = "+ row + " col "+ column);

        if(row == 3 && column == 3 ){
            System.out.println( "Has path = " );

            return true;
        }

        if(hasPath(maze,row, column)) {
            System.out.println(" row = result "+ row + " col "+ column);
            //visited
            maze[row][column] = 0;

            //Down
            if(helper(maze, row + 1, column, path)){
                return true;
            };

            //Right
            if(helper(maze, row, column + 1, path)){
                return true;
            };

            //Up
            if(helper(maze, row - 1, column, path)){
                return true;
            };

            //Left
            if(helper(maze, row, column - 1, path)){
                return true;
            };

        }

        return false;
    }
    
        //BFS LeetCode 490
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()){

            int[] point = queue.remove();

            if (point[0] == destination[0] && point[1] == destination[1])
                return true;

            for(int[] dir: dirs){
                int row = point[0]+dir[0];
                int col = point[1]+dir[1];
               if(hasPath(maze, row, col)){
                   queue.add(new int[] {row, col});
                   maze[row][col] = 0;
               }
            }
        }

        return false;
    }

    private boolean hasPath(int[][] maze, int row, int column){
        if (row < 0 || column < 0 || row >= maze.length || column >= maze[row].length || maze[row][column] == 0) return false;
        else return true;
    }

    public static void main(String args[]){
        MazeProblem maze = new MazeProblem();
        int [][] mz = {{1,0,1,0},
                       {1,1,1,0},
                       {0,0,1,0},
                       {0,0,1,1}};
        maze.findPath(mz);
//        Iterable<String> path = maze.findPath(mz);
//        for (String p: path) {
//            System.out.println( p + " ");
//        }
    }
}
