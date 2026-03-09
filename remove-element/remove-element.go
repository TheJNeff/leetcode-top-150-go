package removeElement

func removeElement(nums []int, val int) int {    
    writePtr := 0
    for readPtr := 0; readPtr < len(nums); readPtr++ {
        if (nums[readPtr] != val) {
            // write from reader
            nums[writePtr] = nums[readPtr]
            // only increment write pointer reading a non-val
            writePtr++
        }
        // always increment read pointer
    }
    
    return writePtr
}
