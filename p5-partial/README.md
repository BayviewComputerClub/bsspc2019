## Solution
- The intended solution for this subtask was to literally do what the problem said, and brute-force your way.
- Simply for each query, just do a nested loop to add the values through.
- ```java
  for(int i=1; i<=Q; i++) {
    int storeidx = in.nextInt();
    long sugarIncrease = in.nextLong();
    int left = Math.max(0, storeidx - survey[storeidx-1]-1);
    int right = Math.max(N-1, storeidx + survey[storeidx-1]-1);
    for(int j=left; j<=right; j++) {
      sugarValues[j] += sugarIncrease
    }
  }
  ```
- A thing that contestant needed to watch out was that they needed to use a 64-bit type data variable, due to overflow errors. And also to watch out for index out of bounds errors.
- This had a time complexity of **`O(N + NQ)`**, which was passable for this subtask.
