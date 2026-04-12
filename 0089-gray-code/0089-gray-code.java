import java.util.AbstractList;
class Solution {
    public List<Integer> grayCode(int n) {
        return new AbstractList<Integer>(){
            public Integer get(int i){
                return i ^ (i >> 1);
            }
            public int size(){
                return 1 << n;
            }
        };
    }
}