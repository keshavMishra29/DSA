import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions: North, East, South, West
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int dir = 0; // start facing North
        
        int x = 0, y = 0;
        int maxDist = 0;
        
        // Store obstacles in HashSet
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + "," + obs[1]);
        }
        
        for (int cmd : commands) {
            if (cmd == -1) {
                // turn right
                dir = (dir + 1) % 4;
            } else if (cmd == -2) {
                // turn left
                dir = (dir + 3) % 4;
            } else {
                // move forward step by step
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];
                    
                    if (set.contains(nx + "," + ny)) {
                        break; // obstacle found
                    }
                    
                    x = nx;
                    y = ny;
                    
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }
        
        return maxDist;
    }
}