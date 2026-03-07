**Problem** 
Link: https://leetcode.com/problems/merge-sorted-array/
Difficulty: Easy

**LeetCode Post-Mortem: Merge Sorted Array**

**Key Observations**

Looking at the problem, two things stood out immediately:
1. Both arrays are sorted — a property that usually signals an optimization opportunity.
2. The goal is to mutate `nums1` rather than return a new array. This is unusual — a standard version of this problem would just return the merged result. Since this wrinkle doesn't seem to exist purely as an added challenge (you could always just create a new array and copy it back into `nums1`), it felt like it might also be enabling an optimization — specifically, the possibility of solving this without a temporary array at all.

**Key Observations About the Constraints**

1. `m` or `n` may be 0 — either input array could be empty.
2. Both `m` and `n` may be non-zero simultaneously.
3. `nums1.length == m + n` — the array is already exactly the right size to hold the final merged result.

Based on constraint #3, it seemed plausible to populate `nums1` in descending order from the back. Filling left-to-right would clobber existing entries, but filling right-to-left avoids that — no non-placeholder entry would ever need to move left of its current position. That said, this felt like a risky assumption to lean on before verifying the basic logic, so the plan was to implement the simple placeholder approach first, validate correctness, and then attempt to optimize it away.

---

**Approach 1: With a Placeholder Array**

Allocate a temporary `result` slice of size `m + n` and merge `nums1` and `nums2` into it, then copy the result back into `nums1`. Two pointers — `idx1` at position `0` in `nums1` and `idx2` at position `0` in `nums2` — advance in tandem, inserting the smaller element at each step. When one array is exhausted, the remaining elements of the other are inserted directly.

- **File:** merge-sorted-array-1.go
- **Tests:** 100%
- **Time:** 0ms — Beats 100.00%
- **Space:** 4.26MB — Beats 33.94%
- **Time Complexity:** O(n+m)

The memory ranking confirmed the hunch: the temporary array was worth trying to eliminate.

---

**Approach 2: Without a Placeholder Array**

Three pointers: `idx1` at `m-1`, `idx2` at `n-1`, and `insrt` at `m+n-1`, all working backwards. At each step, the larger of the two current elements is placed at `insrt` and its pointer is decremented. If either pointer drops below zero, elements are pulled exclusively from the remaining array.

- **File:** merge-sorted-array-2.go
- **Tests:** 100%
- **Time:** 0ms — Beats 100.00%
- **Space:** 4.16MB — Beats 80.05%
- **Time Complexity:** O(n+m)

The hunch held. Filling from the right is safe because the placeholder zeros at the back of `nums1` are always overwritten first, so no real element is ever clobbered before it's been read.
