package mergeSortedArray2

func merge(nums1 []int, m int, nums2 []int, n int)  {
    /*
        So... how can we do this without a placeholder? 

        I think all we need to do is maintain 3 pointers:
            1. To the element of nums1 we will compare
            2. To the element of nums2 we will compare
            3. To the element of nums1 we will replace

        Let's declare those:
    */
    idx1 := m-1
    idx2 := n-1
    for insrt := m+n-1; insrt >= 0; insrt-- {
        if (idx1 < 0) {
            // nums1 does not have a value to compare
            nums1[insrt] = nums2[idx2]
            idx2--
        } else if (idx2 < 0) {
            // nums2 does not have a value to compare
            nums1[insrt] = nums1[idx1]
            idx1--
        } else {
            // both have a value to compare
            if (nums2[idx2] > nums1[idx1]) {
                nums1[insrt] = nums2[idx2]
                idx2--
            } else {
                nums1[insrt] = nums1[idx1]
                idx1--
            }
        }
    }
}

