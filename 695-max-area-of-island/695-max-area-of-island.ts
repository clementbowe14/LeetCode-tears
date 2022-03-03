function maxAreaOfIsland(grid: number[][]): number {
    let ans = 0;
    let dimensions = [grid.length, grid[0].length];
    
    for(let i = 0; i < dimensions[0]; i++) {
        for(let j = 0; j < dimensions[1]; j++) {
            if(grid[i][j] == 1){
               let res = dfs(i, j, grid, dimensions[0], dimensions[1]);
                ans = Math.max(ans, res);
            }
        }
    }
    return ans;
};

function dfs(row :number, col:number, grid: number[][], m: number, n : number) {
    if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] === 0) {
        return 0;
    }
    
    grid[row][col] = 0;
    
    return 1 + dfs(row+1, col, grid, m, n) + dfs(row-1, col, grid, m, n) + dfs(row, col+1, grid, m, n) + dfs(row, col-1, grid, m, n);
}