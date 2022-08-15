func romanToInt(s string) int {
    roman := []rune(s)
    ans := 0
    i:= 0
    mp := map[rune]int{'I':1,'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500,'M':1000}
    for i < len(roman) {
        if i < len(roman)-1 {
            if roman[i] == 'C' && roman[i+1] == 'M' {
                ans += (mp[roman[i+1]] - mp[roman[i]])
                i++
            } else if roman[i] == 'C' && roman[i+1] == 'D' {
                ans += (mp[roman[i+1]] - mp[roman[i]])
                i++               
            } else if roman[i] == 'X' && roman[i+1] == 'C' {
                ans += (mp[roman[i+1]] - mp[roman[i]])
                i++ 
                
            } else if roman[i] == 'X' && roman[i+1] == 'L' {
                ans += (mp[roman[i+1]] - mp[roman[i]])
                i++ 
                
            } else if roman[i] == 'I' && roman[i+1] == 'V' {
                ans += (mp[roman[i+1]] - mp[roman[i]])
                i++                
            } else if roman[i] == 'I' && roman[i+1] == 'X' {
                ans += (mp[roman[i+1]] - mp[roman[i]])
                i++
                
            } else {
                ans += mp[roman[i]]
            }
        } else {
            ans += mp[roman[i]]
        }
        i++
        fmt.Println(ans)
    }
    return ans
}