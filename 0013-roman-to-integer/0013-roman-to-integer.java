class Solution {
    public int romanToInt(String s) {

        int total = 0;

        for (int i = 0; i < s.length(); i++) {

            int valorAtual = getValor(s.charAt(i));

            if (i < s.length() - 1) {
                int proximoValor = getValor(s.charAt(i + 1));

                if (valorAtual < proximoValor) {
                    total -= valorAtual;
                } else {
                    total += valorAtual;
                }
            } else {
                total += valorAtual;
            }
        }

        return total;
    }

    public int getValor(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}