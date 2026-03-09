---

**LeetCode Post-Mortem: Remove Element**

**Key Observations**

1. Looking at it naively, walking through the array from beginning to end and removing instances of `val` while incrementing a counter seems straightforward. However, the catch is that deletions need to be in-place. A true in-place deletion is relatively expensive — it requires shifting every element after the deleted one up by one position. The question is whether there's a simpler, less costly way to achieve the same effect.
2. The fact that we don't need to worry about the last `k` elements of the array is a telling clue. If real deletions were expected, the problem would require the array to shrink by `k`. This suggests a simpler approach is intended.

**Key Observations About the Constraints**

Nothing of note — the array size is small and values are bounded between 0 and 100, so there's no need to worry about edge cases around scale or overflow.

---

**Approach: Two Pointers**

Starting with one pointer, we can identify every instance of `val` — but then what do we replace them with? A single pointer doesn't give us enough information.

With two pointers the picture becomes clearer. Iterate from the beginning of the array: when an occurrence of `val` is found, pause a *write pointer* at that position while a *read pointer* advances ahead to find the next non-`val` value to replace it with. The write pointer only advances when a valid replacement has been written, effectively compacting all the non-`val` elements to the front of the array without ever doing a true deletion.
