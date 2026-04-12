class Solution {
    public List<String> removeAnagrams(String[] words) {
        String old = "";
        List<String> lst = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            char[] ch = words[i].toCharArray();
            Arrays.sort(ch);
            String neww = String.valueOf(ch);

            if(!old.equals(neww)){
                lst.add(words[i]);
                old = neww;
            }
        }
        return lst;
    }
}