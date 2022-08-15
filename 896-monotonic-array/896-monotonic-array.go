func isMonotonic(nums []int) bool {
    dec := true
    asc := true
    left := nums[0]
    for i := 1; i < len(nums); i++{
        if nums[i] > left {
            dec = false
            left = nums[i]
        } else if nums[i] < left {
            asc = false
            left = nums[i]
        }
    }
        return dec || asc
}