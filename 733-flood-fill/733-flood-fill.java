class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor == image[sr][sc]) {
            return image;
        }
        
        dfs(image, sr, sc, image[sr][sc], image.length, image[0].length, newColor);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int originalColor, int m, int n, int newColor){
        if(sr >= m || sc >= n || sr < 0 || sc < 0 || image[sr][sc] != originalColor){
            return;
        }
        
        image[sr][sc] = newColor;
        
        dfs(image, sr+1, sc, originalColor, m, n, newColor);
        dfs(image, sr-1, sc, originalColor, m, n, newColor);
        dfs(image, sr, sc+1, originalColor, m, n, newColor);
        dfs(image, sr, sc-1, originalColor, m, n, newColor);
    }
}