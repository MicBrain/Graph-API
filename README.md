Graph-API
=========

A standard API that provides methods for Graphs.

### Documentation

   This package represents a general unlabeled graph whose vertices are denoted by positive integers.  A graph may be directed or undirected.  For an undirected graph, outgoing and incoming edges are the same. Graphs may have self edges, but no multi-edges (edges with the same end points). Edges in a Graph are ordered by the sequence in which they were added.
   
   1. vertexSize() - Returns the number of vertices in me.
   2. maxVertex()  - Returns my maximum vertex number, or 0 if I am empty.
   3. edgeSize()   - Returns the number of edges in me.
   4. isDirected() - Returns true iff I am a directed graph.
   5. outDegree(int v) - Returns the number of outgoing edges incident to V, or 0 if V is not one of my vertices.
   6. inDegree(int v) - Returns the number of incoming edges incident to V, or 0 if V is not one of my vertices.
   7. degree(int v) - Returns outDegree(V). This is simply a synonym, intended for use in undirected graphs.
   
   
