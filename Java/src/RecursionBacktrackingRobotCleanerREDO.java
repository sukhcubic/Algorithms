public class RecursionBacktrackingRobotCleanerREDO {
    //https://leetcode.com/problems/robot-room-cleaner/
      interface Robot {
     // Returns true if the cell in front is open and robot moves into the cell.
              // Returns false if the cell in front is blocked and robot stays in the current cell.
              public boolean move();

             // Robot will stay in the same cell after calling turnLeft/turnRight.
              // Each turn will be 90 degrees.
              public void turnLeft();
      public void turnRight();

        // Clean the current cell.
           public void clean();
     }


        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Set<Pair<Integer, Integer>> visited = new HashSet();
        Robot robot;

        public void goBack() {
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }

        public void backtrack(int row, int col, int d) {
            visited.add(new Pair(row, col));
            robot.clean();
            // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
            for (int i = 0; i < 4; ++i) {
                int newD = (d + i) % 4;
                int newRow = row + directions[newD][0];
                int newCol = col + directions[newD][1];

                if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
                    backtrack(newRow, newCol, newD);
                    goBack();
                }
                // turn the robot following chosen direction : clockwise
                robot.turnRight();
            }
        }

        public void cleanRoom(Robot robot) {
            this.robot = robot;
            backtrack(0, 0, 0);
        }

    static void helper(int[][] matrix, int row, int column, int d){
        // Base case
        if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[row].length || matrix[row][column] == 0) {
            return;
        }
        // Already visited
        if(matrix[row][column] != 0) {
            matrix[row][column] = 0;
            System.out.println(" d  "+ d);
            helper(matrix, row, column + 1, (d+0)%4);
            helper(matrix, row, column - 1, (d+1)%4);
            helper(matrix, row + 1, column, (d+2)%4);
            helper(matrix, row - 1, column, (d+3)%4);
            matrix[row][column] = 1;
        }
    }

    public static  void main(String arg[]){
          int[][] room = {{1, 1, 1, 1, 1, 0, 1, 1},
                  {1, 1, 1, 1, 1, 0, 1, 1},
                  {1, 0, 1, 1, 1, 1, 1, 1},
                  {0, 0, 0, 1, 0, 0, 0, 0},
                  {1, 1, 1, 1, 1, 1, 1, 3}};
          int row = 1;
          int col = 3;

          helper(room, row, col, 0);
        for (int i=0; i<room.length; i++) {

            for(int j = 0; j<room[0].length; j++){
               // System.out.println(room[i][j]);
            }
        }
    }

}
