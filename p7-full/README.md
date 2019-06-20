## Solution
- If you used LIS until this point, it seemed there was no other way, except, the LIS can be further optimized, by using binary search to find the most optimal letter to choose. it is explained here: [LIS](https://github.com/BayviewComputerClub/CP-Algorithms/tree/master/Dynamic%20Programming/Longest%20Increasing%20Subsequence)
- OR, if you don't like dp, you could've used a simple brute-force method. A key point is there is only 26 letters in the alphabet, and the captialization doesn't matter, so all you had to do was loop through the string for each letter, which had a final time complexity of O(N x 26), which was really easy to implement.
- Some people even used trees, but binary search + LIS was the intended solution.
