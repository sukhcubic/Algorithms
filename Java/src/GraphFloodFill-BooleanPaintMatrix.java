import java.util.*;
class GraphFloodFill-BooleanPaintMatrix{
   //Be careful ask questions in interview about edge cases. Like new color can be same color as old color. Ex. 
   //image = [[0,0,0],[0,1,1]]
   //sr = 1
   //sc = 1
   //newColor = 1
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        if(!isValid(image, sr,sc)){
            return image;
        }
        int[] pos = {sr,sc};
        int color = image[sr][sc];
        queue.add(pos);

        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        while(!queue.isEmpty()){
            int[] ps = queue.remove();
            for(int[] i : dirs) {
                int row = ps[0] + i[0];
                int col = ps[1] + i[1];
                if (isValid(image, row, col)) {
                    if(image[row][col] == color && !visited[row][col]) {
                        visited[row][col] = true;
                        image[row][col] = newColor;
                        queue.add(new int[]{row, col});
                    }
                }
            }
        }
        return image;
    }

    private boolean isValid(int[][] image, int row, int column){
        if (row < 0 || column < 0 || row >= image.length || column >= image[row].length ) return false;
        else return true;
    }
    
    public static void main(String args[]){
        GraphFloodFill-BooleanPaintMatrix maze = new GraphFloodFill-BooleanPaintMatrix();
        int [][] mz = {{1,1,0,1,1},
                       {1,1,1,1,1},
                       {1,1,1,0,1},
                       {0,0,0,0,0},
                       {1,1,1,1,1}};

        for (int[] val :maze.floodFill(mz, 0, 0 , 2)) {
            for (int v:
                 val) {
                System.out.println(v);
            }

        }
    }

}
