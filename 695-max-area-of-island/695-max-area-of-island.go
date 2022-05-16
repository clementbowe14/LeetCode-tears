func maxAreaOfIsland(grid [][]int) int {
    ans := 0
    visited := make([][]bool, len(grid))
    for i := 0; i < len(grid); i++ {
        visited[i] = make([]bool, len(grid[0]))
       
    }
    
    for i := 0; i < len(grid); i++ {
        for j := 0; j < len(grid[0]); j++ {
            if grid[i][j] == 1 && !visited[i][j] {
                island := dfs(i, j, grid, visited)
                if island > ans {
                    ans = island
                }
            }
        }
    }
    
    return ans
}

func dfs(r int, c int, grid [][]int, visited [][]bool) int {
    if r < 0 || r >= len(grid) || c < 0 || c >= len(grid[0]) || grid[r][c] == 0 || visited[r][c] {
        return 0
    }
        
    visited[r][c] = true
    
    up := dfs(r+1, c, grid, visited)
    down := dfs(r-1, c, grid, visited)
    left := dfs(r, c-1, grid, visited)
    right := dfs(r, c+1, grid, visited)
    
    ans := up + down + left + right
    
    return 1 + ans
}

func max(x int, y int) int {
    if(x > y) {
        return x
    }
    
    return y
}
