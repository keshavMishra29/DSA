class Solution {
    public String smallestSubsequence(String s) {
        char[] stk = new char[26];
        int top = -1;
        int[] lastIndex = new int[26];
        boolean[] seen = new boolean[26];

        final int size = s.length();
        char[] str = s.toCharArray();
        for(int i=0;i<size;i++){
            lastIndex[str[i]-'a'] = i;
        }

        for(int i=0;i<size;i++){
            if(!seen[str[i]-'a']){
                while(top>=0 && stk[top]>str[i] && lastIndex[stk[top]-'a']>i){
                    seen[stk[top--]-'a'] = false;
                }
                seen[str[i]-'a'] = true;
                stk[++top] = (str[i]);
            }
        }
        return new String(stk,0,top+1);
    }
}