## Solution
- This was a classical disjktras problem, the algorithm is shown here: [DIJKSTRAS](https://github.com/BayviewComputerClub/CP-Algorithms/tree/master/Graph%20Theory/Dijkstras/Dijkstra%20Optimized)
- Except, if you just brute-forced dijkstras, it most-likely TLE. 
- A key insight was that for each city, one of them is guranteed to be a tourist attraction, and the attractions were given to you. So all you had to do was disjktras from the tourist attraction to your start point, and from the tourist attraction to your end point. Which was way faster as there was at most 200 attractions.
- This gave it a time-complexity of: O(200 x (E + log(V)).
