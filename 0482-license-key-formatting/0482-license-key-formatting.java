class Solution {
    public String licenseKeyFormatting(String s, int k) {
        char[] ch = s.toCharArray();
        int n = s.length();
        char[] result = new char[2*n-1];
        int j = k;
        int a = 2*n-2;
        for(int i = n-1; i >=0; i--){
            
            char elem = ch[i];
            
            if(elem == '-'){
                continue;
            }
            int value = (int)elem;
            if(value >= 97 && value <= 122){
                elem = (char)(value - 32);
            }
            if(j == 0){
                result[a] = '-';
                a--;
                j= k;
            }
            if(j > 0){
                result[a] = elem;
                j--;
                a--;
            }
        }
        return String.copyValueOf(result, a+1, (2*n-2)-a);
    }
}