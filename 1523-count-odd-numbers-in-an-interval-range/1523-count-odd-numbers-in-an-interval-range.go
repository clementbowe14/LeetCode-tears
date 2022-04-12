
/*
 2 - 6  2, 3, 4, 5 6 low - high / 2
 3 - 7 3, 4 5, 6,7 low - high / 2 + 1
 8 - 9 8 9 low - high / 2
 21 24 21 22 23 24 low - high / 2
*/
func countOdds(low int, high int) int {
    interval := (high - low)
    if(interval % 2 == 0 && low % 2 == 0) {
        return interval / 2 
    } else if(interval % 2 == 0) {
        return interval / 2 + 1
    } else if (interval == 1) {
        return interval
    }
    
    return interval / 2 + 1
}
      