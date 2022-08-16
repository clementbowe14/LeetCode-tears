func firstUniqChar(s string) int {
    freq := make(map[rune]int)
    letters := []rune(s)
    for i := range(letters) {
        freq[letters[i]]++
    }
    for i := range(letters){
        if freq[letters[i]] == 1 {
            return i
        }
    }
    return -1
}