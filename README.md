Graph-API
=========

### Table of Content

1. Introduction
2. Documentation
3. Practical examples
4. Like it / Hate it!
4. References

### Introduction
      
   "Graph-API" is a standard API that provides methods for Graphs.  This package represents a general unlabeled graph whose vertices are denoted by positive integers.  A graph may be directed or undirected.  For an undirected graph, outgoing and incoming edges are the same. Graphs may have self edges, but no multi-edges (edges with the same end points). Edges in a Graph are ordered by the sequence in which they were added.
   
   "Graph-API" is has very practical functionallity, it is very easy to use and in different applications. Examples of utilization of this library can be seen in Topographic-Maps program (https://github.com/MicBrain/Topographic-Maps). In this package we triend to combine all essential ideas of Graph Theory so all the users can easily implement their applications using this API. This software is under GNU GENERAL PUBLIC LICENSE. In order to use this package click on "Download ZIP" and unpack it.

### Documentation

      GENERALLY USEFUL METHODS AND CLASSES

##### METHODS
   
   1. vertexSize() - Returns the number of vertices in me.
   2. maxVertex()  - Returns my maximum vertex number, or 0 if I am empty.
   3. edgeSize()   - Returns the number of edges in me.
   4. isDirected() - Returns true iff I am a directed graph.
   5. outDegree(int v) - Returns the number of outgoing edges incident to V, or 0 if V is not one of my vertices.
   6. inDegree(int v) - Returns the number of incoming edges incident to V, or 0 if V is not one of my vertices.
   7. degree(int v) - Returns outDegree(V). This is simply a synonym, intended for use in undirected graphs.
   8. contains(int u) - Returns true iff U is one of my vertices.
   9. contains(int u, int v) - Returns true iff U and V are my vertices and I have an edge (U, V).
   10. add() - Returns a new vertex and adds it to me with no incident edges. The vertex number is always the smallest                     integer >= 1 that is not currently one of my vertex numbers. 
   11. add(int u, int v) - Add an edge incident on U and V. If I am directed, the edge is directed (leaves U and enters V).                Assumes U and V are my vertices.  Has no effect if there is already an edge from U to V.  Returns U.
   12. remove(int v) - Remove V, if present, and all adjacent edges.
   13. remove(int u, int v) - Remove edge (U, V) from me, if present.
   14. vertices() - Returns an Iteration over all vertices in numerical order.
   15. successor(int v, int k) - Return successor K of V, numbering from 0, or 0 if there is no such successor (or V is not                a vertex).
   16. predecessor(int v, int k) - Return predecessor K of V, numbering from 0, or 0 if there is no such predecessor.                      Assumes V is one of my vertices.
   17. neighbor(int v, int k) - Return neighbor K of V, numbering from 0, or 0 if there is no such neighbor.  Assumes V is                 one of my vertices. This is a synonym for successor(v, k).
   18. successors(int v) - Returns an iteration over all successors of V in the order the edges to them were added.  Empty                 if V is not my vertex.
   19. predecessors(int v) - Returns an iteration over all predecessors of V in the order the edges to them were added.                    Empty if V is not my vertex.
   20. neighbors(int v) - Returns successors(V).  This is a synonym typically used on undirected graphs.
   21. edges() - Returns an iteration over all edges in me.  Edges are returned as two-element arrays (u, v), which are                    directed if the graph is.  In fact, the same array is used for each, and modified by the next() method of the iteration.
   22. mine(int v) - Return true iff V is one of my vertices.
   23. checkMyVertex(int v) - Throw exception if V is not one of my vertices.
   24. edgeId(int u, int v) - Returns a unique positive identifier for the edge (U, V), if it is present, or 0 otherwise.                  The value of edgeId(v0, v1) does not change while the edge is present.  It is used in LabeledGraph to number                edges so that their labels are easy to retrieve and set. 
         
##### CLASSES

   1. Directed Graph - Represents a general unlabeled directed graph whose vertices are denoted by positive integers. Graphs                       may have self edges.
   2. UndirectedGraph - Represents an undirected graph.  Out edges and in edges are not distinguished.  Likewise for                              successors and predecessors.
   3. ShortestPaths - The shortest paths through an edge-weighted graph. By overrriding methods getWeight, setWeight,                             getPredecessor, and setPredecessor, the client can determine how to represent the weighting and the                         search results.  By overriding estimatedDistance, clients can search for paths to specific                                  destinations using A* search.
   4. SimpleShortestPaths - A partial implementation of ShortestPaths that contains the weights of the vertices and the                           predecessor edges. The client needs to supply only the two-argument getWeight method.
   5. Traversal - Implements a generalized traversal of a graph.  At any given time, there is a particular collection of                          untraversed vertices---the "fringe." Traversal consists of repeatedly removing an untraversed vertex                        from the fringe, visting it, and then adding its untraversed successors to the fringe.
                      Generally, the client will extend Traversal.  By overriding the visit method, the client can determine                       what happens when a node is visited. By supplying an appropriate type of Queue object to the                                constructor, the client can control the behavior of the fringe. By overriding the shouldPostVisit and                       postVisit methods, the client can arrange for post-visits of a node (as in depth-first search).  By                         overriding the reverseSuccessors and processSuccessor methods, the client can control the addition of                       neighbor vertices to the fringe when a vertex is visited. Traversals may be interrupted or restarted,                       remembering the previously marked vertices.
   6. BreadthFirstTraversal -  Implements a breadth-first traversal of a graph.  Generally, the client will extend this                           class, overriding the visit method as desired (by default, it does nothing).
   7. DepthFirstTraversal - Implements a depth-first traversal of a graph.  Generally, the client will extend this class,                         overriding the visit and postVisit methods, as desired (by default, they do nothing).

### Practical examples

a. Declaring Directed graph: UndirectedGraph ug = new UndirectedGraph();

b. Declaring Undirected graph:  DirectedGraph dg = new DirectedGraph();

c. Adding nodes to graph. (Doesn't really matter whether we take directed or Undirected Graph).
```
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ...
```
d. Adding edges to graph. In this example we will add an edge between nodes 1 and 3.









