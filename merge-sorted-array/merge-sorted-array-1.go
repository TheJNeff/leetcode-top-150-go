package mergeSortedArray1

func merge(nums1 []int, m int, nums2 []int, n int)  {
    // first, let's declare our placeholder array (or, rather, slice)
    result := make([]int, m + n)

    // now, we need an iterator for nums1 and nums2
    idx1 := 0
    idx2 := 0

    // next, we will populate result by comparing the elements of nums1 and nums2
    // we will need to ensure the element exists in nums2 and that it is not a placeholder in nums1
    for i := 0; i < (m + n); i++ {
        if (idx1 == m) {
            // nums1 does not have a value to compare
            result[i] = nums2[idx2]
            idx2++
        } else if (idx2 == n) {
            // nums2 does not have a value to compare
            result[i] = nums1[idx1]
            idx1++
        } else {
            // both have a value to compare
            if (nums2[idx2] < nums1[idx1]) {
                result[i] = nums2[idx2]
                idx2++
            } else {
                result[i] = nums1[idx1]
                idx1++
            }
        }
    }

    // finally, copy the result to nums1
    copy(nums1, result)
}

