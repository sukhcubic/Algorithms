class GraphFloodFill-BooleanPaintMatrix{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        if(!isValid(image, sr,sc)){
            return image;
        }
        int[] pos = {sr,sc};
        int color = image[sr][sc];
        queue.add(pos);

        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        while(!queue.isEmpty()){
            int[] ps = queue.remove();
            for(int[] i : dirs) {
                int row = ps[0] + i[0];
                int col = ps[1] + i[1];
                if (isValid(image, row, col)) {
                    if(image[row][col] == 1) {
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
  //      maze.findPath(mz);
//        Iterable<String> path = maze.findPath(mz);
//        for (String p: path) {
//            System.out.println( p + " ");


        for (int[] val :maze.floodFill(mz, 0, 0 , 2)) {
            for (int v:
                 val) {
                System.out.println(v);
            }

        }
    }

}
