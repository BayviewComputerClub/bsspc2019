## Solution
- This problem was purely a torture implementation problem, that even the problem creator couldn't solve, which he had to beg magicalsoup to do the work for him.
- The solution is literally to check each piece, so the bishops, knights, pawns, queens, rooks, king. The contestants also had to take in consideration of the 2-pawn move and the queening, which was annoying.
- In reality, the solution is not hard to implement, just torture to debug. Due to some insights:
  - The queens, rooks, can reach any square in less than or equal to 2 moves, unless its on the same row for rooks, or same diagonal/row for queens, which they can reach the square in one move.
  - Bishops can reach the square in less than or equal to 2 moves, if the square is the same colour that the bishops were on.
  - The king needed to be recursioned, similar to p4, and to see if he can reach the square.
  - The knight needed a grid-bfs, which is Shown here: [Grid BFS](https://github.com/BayviewComputerClub/CP-Algorithms/tree/master/Graph%20Theory/Breadth%20First%20Search/Grid%20BFS). just change the `moves[][]` array into the moveset for a knight: `{{1,2},{1,-2},{-1,2},{-1,-2},{2,-1},{2,1},{-2,1},{-2,-1}}`
  - Pawns can only move foward, and when they queen, just check if the queen from the queening square can reach the square, with less moves of course.
  - The 2 pawn move just needed to be checked if the pawn is on the 7th or 2nd rank, which means one less move to reach the queening square or the desired square.
  - For the queening part, all you needed to do is first try to move the pawn to the desried square, it not, try to queen the pawn and then reach the desired square.
- The only hard part now is implementing it, which screwed up alot of contestants that attempted it.
- There were other solution, but this one is the most straighforward one.
