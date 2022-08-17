class Solution {
    public int evalRPN(String[] tokens) {
        char ADD = '+';
        char SUB = '-';
        char MULT = '*';
        char DIV = '/';
        Stack<String> stack = new Stack<>();
        for(String token: tokens){
            char letter = token.charAt(0);
            if(letter == ADD) {
                int x = Integer.parseInt(stack.pop());
                int y = Integer.parseInt(stack.pop());
                stack.push(String.format("%d", x+y));
            } else if(letter == SUB && token.length() == 1) {
                int x = Integer.parseInt(stack.pop());
                int y = Integer.parseInt(stack.pop());
                stack.push(String.format("%d", y-x));
            } else if(letter == MULT){
                int x = Integer.parseInt(stack.pop());
                int y = Integer.parseInt(stack.pop());
                stack.push(String.format("%d", y*x));
            } else if(letter == DIV){
                int x = Integer.parseInt(stack.pop());
                int y = Integer.parseInt(stack.pop());
                stack.push(String.format("%d", y/x));
            } else {
                stack.push(token);
            }
            System.out.println(stack.size());
        }
        
        return Integer.parseInt(stack.pop());
    }
}