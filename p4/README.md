## Solution
- This problem was poorly tested, which we needed to fix in-contest. We apologize for all the troubles.
- The intended solution was to use recursion, and recurse your way to the top. For each square, go in a 4 directions, and for each of those 4 squares, do the same, and see if you can reach the end.
- The catch for this problem was that the coordinate 0 started on the left **bottom** corner, not the **top** corner, so you had to convert it during your input inorder to get full points.
  - To convert, simply just to `100-y` in your code, and you should be good.
- A thing with python and java users was the stack overflow error, which python just had to increase the recursion limit, and java was a bit wonky, but a good idea was to just try and submit it on the judge.
- Anothing thing is that most of the problem statement was pretty much useless, which encouraged contestants to read the whole thing (hopefully).
