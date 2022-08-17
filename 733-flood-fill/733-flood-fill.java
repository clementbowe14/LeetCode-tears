class Solution {
    
    int[][] coord = {{0,1},{0,-1},{-1,0},{1,0}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }
    
    public void fill(int [][] image, int row, int col, int startColor, int newColor) {
        if(row < 0 || row > image.length-1 || col < 0 || col > image[0].length-1 ||  image[row][col] != startColor){
            return;
        }
        
        image[row][col] = newColor;
        
        for(int i = 0; i < coord.length; i++){
            int newRow = coord[i][0] + row;
            int newCol = coord[i][1] + col;
            fill(image, newRow, newCol, startColor, newColor);
        }
    }
}