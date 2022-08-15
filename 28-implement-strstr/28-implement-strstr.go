func strStr(haystack string, needle string) int {
    if len(needle) == 0 {
        return 0
    }
    
    newNeedle := []rune(needle)
    newHaystack := []rune(haystack)
    for i := range(newHaystack) {
        if newHaystack[i] == newNeedle[0] {
            j := 0
            k := i
            found := true
            for k < len(newHaystack) && j < len(newNeedle) {
                if(newHaystack[k] != newNeedle[j]){
                    found = false
                }
                k++
                j++
            }
            if j != len(newNeedle) {
                found = false
            }
            if found {
                return i
            }
        }
    }
    return -1
}