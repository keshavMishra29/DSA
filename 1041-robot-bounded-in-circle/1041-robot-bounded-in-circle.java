class Solution {
    public boolean isRobotBounded(String instructions) {
        // Direction: N, E, S, W
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int x = 0, y = 0;
        int dir = 0; // start facing North

        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                x += dirs[dir][0];
                y += dirs[dir][1];
            } else if (c == 'L') {
                dir = (dir + 3) % 4; // turn left
            } else { // 'R'
                dir = (dir + 1) % 4; // turn right
            }
        }

        // bounded if back to origin OR direction changed
        return (x == 0 && y == 0) || dir != 0;
    }
}