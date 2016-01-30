# Solutions to Recursion and Dynamic Programming

### Recursive vs. Iterative Solutions

Recursive algorithm can be very space inefficient. Each recursive call adds a new layer to the stack, which means that if your algorithm recursive to a depth of n, it uses at least o(n) memory.

For this reason, it's often better to implement a recursive algorithm iteratively. All recursive algorithm can be implemented iteratively, although sometimes the code to do so is much more complex. Before diving into recursive code, ask yourself how hard it would be to implemented it iteratively, and discuss  the tradeoffs with your interviewer.