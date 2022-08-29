from typing import List, Dict


class Solution:

    
    def minPathSum(self, grid: List[List[int]]) -> int:
        memo = {}
        if len(grid) < 2 and len(grid[0]) < 2:
            return grid[0][0]
        
        return self.helper(grid, 0, 0, memo)

    def helper(self, grid: List[List[int]], row: int, col: int, memo:Dict[str, int] ) -> int:
        
        #base case sets memo[m-1][n-1] = grid[m-1][n-1] and returns it
        if len(grid) - 1 == row and len(grid[0]) - 1 == col:
            memo[f"({row}, {col})"] = grid[row][col]
            return memo[f"({row}, {col})"]
        
        #base case last row is set 
        elif len(grid) - 1 == row:
            if f"({row}, {col + 1})" not in memo:
                memo[f"({row}, {col + 1})"] = self.helper(grid, row, col + 1, memo)
            memo[f"({row}, {col})"] = grid[row][col] + memo[f"({row}, {col + 1})"]
            return memo[f"({row}, {col})"]

        elif len(grid[0]) - 1 == col:
            if f"({row + 1}, {col})" not in memo:
                memo[f"({row + 1}, {col})"] = self.helper(grid, row + 1, col, memo)
            memo[f"({row}, {col})"] = grid[row][col] + memo[f"({row+1}, {col})"]
            return  memo[f"({row}, {col})"]

        else:
            if f"({row}, {col + 1})" not in memo:
                memo[f"({row}, {col + 1})"] = self.helper(grid, row, col + 1, memo)
            if f"({row + 1}, {col})" not in memo:
                memo[f"({row + 1}, {col})"] = self.helper(grid, row + 1, col, memo)
                
            memo[f"({row}, {col})"] = grid[row][col] + min(memo[f"({row + 1}, {col})"], memo[f"({row}, {col + 1})"])
            return memo[f"({row}, {col})"]