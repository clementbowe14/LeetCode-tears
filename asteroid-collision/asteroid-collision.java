class Solution {
    public static void collide(Stack<Integer> stack,int value){
        while(true){
            if(stack.isEmpty()){
                stack.push(value);
                break;
            }
            if(stack.peek() < 0  && value < 0){
                stack.push(value);
                break;
            }
            if(stack.peek() > Math.abs(value)){
                break;
            }
            else if(stack.peek() < Math.abs(value)){
                stack.pop();
            }
            else if(stack.peek() == Math.abs(value)){
                stack.pop();
                break; 
            }
        }
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(asteroids[0]);
        for(int i = 1; i < asteroids.length; i++){
            if(stack.size() == 0){
                stack.push(asteroids[i]);
            }
            else if((stack.peek() > 0 && asteroids[i] > 0) || 
                    (stack.peek() < 0 && asteroids[i] > 0) || (stack.peek() < 0 && asteroids[i] < 0) ){
                stack.push(asteroids[i]);
            }
            else{
                collide(stack,asteroids[i]);
            }
        }
        int[] array = new int[stack.size()];
        for(int i = array.length-1; i >= 0; i--){
            array[i] = stack.pop();
        }
        return array; 
    }
}