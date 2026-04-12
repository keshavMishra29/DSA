class Solution {
    private int id;
    private boolean isStart;
    private int callTime;

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] timesById = new int[n];
        int[] stackOfIds = new int[logs.size()];
        int top = 0;
        int prevTime = 0;

        for (int i = 1; i < logs.size(); i++) {
            parseLog(logs.get(i).toCharArray());

            if (isStart) {
                if (top >= 0) { // stack not empty
                    timesById[stackOfIds[top]] += callTime - prevTime;
                }
                stackOfIds[++top] = id;
                prevTime = callTime;
            } else {
                timesById[stackOfIds[top--]] += callTime - prevTime + 1;
                prevTime = callTime + 1;
            }
        }
        return timesById;
    }

    private void parseLog(char[] log) {
        int i = 0;
        // parse id
        id = 0;
        while (log[i] != ':') {
            id = id * 10 + (log[i++] - '0');
        }
        i++; // skip ':'

        // parse type
        isStart = log[i] == 's';
        i += isStart ? 6 : 4; // skip "start:" or "end:"

        // parse timestamp
        callTime = 0;
        while (i < log.length) {
            callTime = callTime * 10 + (log[i++] - '0');
        }
    }
}