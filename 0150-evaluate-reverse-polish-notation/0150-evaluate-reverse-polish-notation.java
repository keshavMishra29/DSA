class Solution {
    private int index;

    public int evalRPN(String[] tokens) {
        this.index = tokens.length - 1;
        return backtrack(tokens);
    }

    private int backtrack(String[] tokens) {
        String token = tokens[index--];

        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            int b = backtrack(tokens); 
            int a = backtrack(tokens); 

            switch (token) {
                case "+"-> {
                    return a + b;
                }
                case "-"-> {
                    return a - b;
                }
                case "*"-> {
                    return a * b;
                }
                case "/"-> {
                    return a / b;
                }
            }
        }
        return Integer.parseInt(token);
    }
}