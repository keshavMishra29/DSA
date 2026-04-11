class Solution {
    public boolean judgeCircle(String moves) {
        int vertical = 0, horizontal = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') vertical++;
            else if (move == 'D') vertical--;
            else if (move == 'R') horizontal++;
            else if (move == 'L') horizontal--;
        }

        return vertical == 0 && horizontal == 0;
    }
}