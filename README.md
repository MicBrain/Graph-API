![alt tag](https://cloud.githubusercontent.com/assets/5885065/5607654/4f45939a-9418-11e4-9004-1be0fbb6aa53.png)
    
### Table of Content
<img src="https://cloud.githubusercontent.com/assets/5885065/5607397/476f3472-940f-11e4-9615-08cb044d8aef.png"
 alt="Graph-API Logo" title="Graph" align="right" />

1. Introduction
2. Full Documentation
3. Practical examples with Methods       
4. Practical examples with Classes
5. Like it / Hate it!
6. Projects that used this API
7. References

### Introduction
      
   **"[Graph API] [website]"** is a standard Java library that provides various methods and classes that help users to implement graphs. In this package we cover the basics of [Graph Theory] [website1] by providing useful helper functions and important algorithms. Keep reading this guide to learn more about the different operations that can be performed using the API. "Graph API" has a very practical functionallity and it is very easy to use it in different applications. Clients can use the "Graph API" to program diverse tools with strong performance. In this library we tried to combine all essential ideas of Graph Theory so all the users can easily implement their applications using this API. 
   
   This package represents a general [unlabeled graph] [website2] whose vertices are denoted by positive integers.  A graph may be directed or undirected.  For an undirected graph, outgoing and incoming edges are the same. Graphs may have self edges, but no multi-edges (edges with the same end points). Edges in a Graph are ordered by the sequence in which they were added. If you are not familiar with Graph Theory, we strongly recommend to run through an introductory tutorial before using this package. You can find detailed information about this in "Full Documentation" section. 
 
   "Graph API" " is free and unencumbered software released into the public domain. This libary is under GNU GENERAL PUBLIC LICENSE. *In order to use this package click on "Download ZIP" and unpack it.*

### Full Documentation

   We devided this section into two subparts. 
   
##### METHODS
   
   1. *vertexSize()* - Returns the number of vertices in me.
   2. *maxVertex()*  - Returns my maximum vertex number, or 0 if I am empty.
   3. *edgeSize()*   - Returns the number of edges in me.
   4. *isDirected()* - Returns true iff I am a directed graph.
   5. *outDegree(int v)* - Returns the number of outgoing edges incident to V, or 0 if V is not one of my vertices.
   6. *inDegree(int v)* - Returns the number of incoming edges incident to V, or 0 if V is not one of my vertices.
   7. *degree(int v)* - Returns outDegree(V). This is simply a synonym, intended for use in undirected graphs.
   8. *contains(int u)* - Returns true iff U is one of my vertices.
   9. *contains(int u, int v)* - Returns true iff U and V are my vertices and I have an edge (U, V).
   10. *add()* - Returns a new vertex and adds it to me with no incident edges. The vertex number is always the smallest                     integer >= 1 that is not currently one of my vertex numbers. 
   11. *add(int u, int v)* - Add an edge incident on U and V. If I am directed, the edge is directed (leaves U and enters                  V). Assumes U and V are my vertices.  Has no effect if there is already an edge from U to V.  Returns U.
   12. *remove(int v)* - Remove V, if present, and all adjacent edges.
   13. *remove(int u, int v)* - Remove edge (U, V) from me, if present.
   14. *vertices()* - Returns an Iteration over all vertices in numerical order.
   15. *successor(int v, int k)* - Return successor K of V, numbering from 0, or 0 if there is no such successor (or V is                   not a vertex).
   16. *predecessor(int v, int k)* - Return predecessor K of V, numbering from 0, or 0 if there is no such predecessor.                      Assumes V is one of my vertices.
   17. *neighbor(int v, int k)* - Return neighbor K of V, numbering from 0, or 0 if there is no such neighbor.  Assumes V                    is one of my vertices. This is a synonym for successor(v, k).
   18. *successors(int v)* - Returns an iteration over all successors of V in the order the edges to them were added.                        Empty if V is not my vertex.
   19. *predecessors(int v)* - Returns an iteration over all predecessors of V in the order the edges to them were added.                    Empty if V is not my vertex.
   20. *neighbors(int v)* - Returns successors(V).  This is a synonym typically used on undirected graphs.
   21. *edges()* - Returns an iteration over all edges in me.  Edges are returned as two-element arrays (u, v), which are                    directed if the graph is.  In fact, the same array is used for each, and modified by the next() method of the iteration.
   22. *mine(int v)* - Return true iff V is one of my vertices.
   23. *checkMyVertex(int v)* - Throw exception if V is not one of my vertices.
   24. *edgeId(int u, int v)* - Returns a unique positive identifier for the edge (U, V), if it is present, or 0 otherwise.                  The value of edgeId(v0, v1) does not change while the edge is present.  It is used in LabeledGraph to number                edges so that their labels are easy to retrieve and set. 
         
##### CLASSES

   1. *DirectedGraph* - Represents a general unlabeled directed graph whose vertices are denoted by positive integers. Graphs                       may have self edges.
   2. *UndirectedGraph* - Represents an undirected graph.  Out edges and in edges are not distinguished.  Likewise for                              successors and predecessors.
   3. *ShortestPaths* - The shortest paths through an edge-weighted graph. By overrriding methods getWeight, setWeight,                             getPredecessor, and setPredecessor, the client can determine how to represent the weighting and the                         search results.  By overriding estimatedDistance, clients can search for paths to specific                                  destinations using A* search.
   4. *SimpleShortestPaths* - A partial implementation of ShortestPaths that contains the weights of the vertices and the                           predecessor edges. The client needs to supply only the two-argument getWeight method.
   5. *Traversal* - Implements a generalized traversal of a graph.  At any given time, there is a particular collection of                          untraversed vertices---the "fringe." Traversal consists of repeatedly removing an untraversed vertex                        from the fringe, visting it, and then adding its untraversed successors to the fringe.
                      Generally, the client will extend Traversal.  By overriding the visit method, the client can determine                       what happens when a node is visited. By supplying an appropriate type of Queue object to the                                constructor, the client can control the behavior of the fringe. By overriding the shouldPostVisit and                       postVisit methods, the client can arrange for post-visits of a node (as in depth-first search).  By                         overriding the reverseSuccessors and processSuccessor methods, the client can control the addition of                       neighbor vertices to the fringe when a vertex is visited. Traversals may be interrupted or restarted,                       remembering the previously marked vertices.
   6. *BreadthFirstTraversal* -  Implements a breadth-first traversal of a graph.  Generally, the client will extend this                           class, overriding the visit method as desired (by default, it does nothing).
   7. *DepthFirstTraversal* - Implements a depth-first traversal of a graph.  Generally, the client will extend this class,                         overriding the visit and postVisit methods, as desired (by default, they do nothing).

### Practical examples with Methods

a. Declaring Directed graph: UndirectedGraph ug = new UndirectedGraph();

b. Declaring Undirected graph:  DirectedGraph dg = new DirectedGraph();

c. Adding vertices to graph. (Doesn't really matter whether we take directed or Undirected Graph).
```
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ...
```
d. Adding edges to graph. In this example we will add an edge between vertices 1 and 3.
```
        DirectedGraph dg = new DirectedGraph();
        dg.add();
        dg.add();
        dg.add();
        dg.add(1, 3);
        ...
```
e. Removing a vertex from a graph. (Same works for DirectedGraphs too).
```
      UndirectedGraph ug = new UndirectedGraph();
      ug.add();
      ug.add();
      ug.add();
      ug.remove(1);
      ug.remove(3);
```
f. Removing an edge from two vertices. In this example we will remove an edge from vertices 1 and 3.
```
        DirectedGraph dg = new DirectedGraph();
        dg.add();
        dg.add();
        dg.add();
        dg.add(1, 3);
        dg.remove(1, 3);
```
g. A JUnit test samples that tests successors of the graph.
```
    @Test
    public void dtestSuccessor() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add(1, 3);
        ug.add(1, 4);
        ug.add(3, 4);
        assertEquals(2, ug.successor(1, 0));
        assertEquals(3, ug.successor(1, 1));
        assertEquals(4, ug.successor(1, 2));
        assertEquals(0, ug.successor(1, 3));
        assertEquals(0, ug.successor(5, 0));
        assertEquals(0, ug.successor(2, 0));
        assertEquals(4, ug.successor(3, 0));
        assertEquals(0, ug.successor(4, 0));
    }
```
h. An example for using vertices() method:
```
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int x : ug.vertices()) {
            result.add(x);
        }
        ...
```
i. A JUnit test sample for edgeSize()
```
    @Test
    public void testDedgesize() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 3);
        ug.add(3, 1);
        ug.add(2, 3);
        assertEquals(3, ug.edgeSize());
    }
```
j. A JUnit test that checks contains method:
```
    @Test
    public void utest() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add(1, 2);
        assertTrue(ug.contains(1, 2));
        assertFalse(ug.contains(1, 3));
        ug.add();
        ug.add(1, 3);
        assertTrue(ug.contains(1, 3));
        assertFalse(ug.contains(2, 3));
        ug.add();
        ug.add(2, 3);
        assertTrue(ug.contains(2, 3));
        ug.add(3, 4);
        assertTrue(ug.contains(3, 4));
        assertTrue(ug.contains(3, 1));
    }
```

### Practical examples with Classes

a. A class that generates the idea of BFS:
```
      public class BFSTest extends BreadthFirstTraversal {

        BFSTest(Graph G) {
            super(G);
            visitedData = new ArrayList<Integer>();
            postVisitData = new ArrayList<Integer>();
        }

        @Override
        protected boolean visit(int v) {
            visitedData.add(v);
            return true;
        }

        @Override
        protected boolean postVisit(int v) {
            postVisitData.add(v);
            return true;
        }

        protected ArrayList<Integer> getvisitedData() {
            return visitedData;
        }

        protected ArrayList<Integer> getpostVisitData() {
            return postVisitData;
        }

        private ArrayList<Integer> visitedData;
        private ArrayList<Integer> postVisitData;
    }
```
b. A class that generates the idea of BFS:
```
      public class DFSTest extends DepthFirstTraversal {
        DFSTest(Graph G) {
            super(G);
            visited = new ArrayList<Integer>();
            postVisited = new ArrayList<Integer>();
        }

        @Override
        protected boolean visit(int v) {
            visited.add(v);
            return true;
        }

        @Override
        protected boolean postVisit(int v) {
            postVisited.add(v);
            return true;
        }

        protected ArrayList<Integer> getVisited() {
            return visited;
        }

        protected ArrayList<Integer> getpostVisited() {
            return postVisited;
        }

        private ArrayList<Integer> visited;
        private ArrayList<Integer> postVisited;
    }
```
c. A class that generates the algorithm of Shortest Path.
```
      public class TestShortestPath  extends SimpleShortestPaths {

        public TestShortestPath(Graph G, int source, int dest) {
            super(G, source, dest);
            weightData = new HashMap<Integer, Integer>();
        }

        public void setWeight(int u, int v, int weight) {
            int id = _G.edgeId(u, v);
            weightData.put(id, weight);
        }

        @Override
        public double getWeight(int u, int v) {
            int id = _G.edgeId(u, v);
            return weightData.get(id);
        }


        private HashMap<Integer, Integer> weightData;
    }
```
### Like it / Hate it.

  This API has been written by [Rafayel Mkrtchyan] [profile] at University of California, Berkeley in December, 2014. I would like to thank my professors Paul Hilfinger and Josh Hug, who teach "Data Structures" course at UC Berkeley, for providing fundamental assistance in completing this project. For additional comments and suggestions you can contact rafamian@berkeley.edu. I don't claim to be perfect so if you find a bug in this library, please send me an email preferably with a test that revealed that error so that I know what I need to fix.
 
### Projects that used this API

   Here is the list of some open-source projects that used this API:

| **[Topographic Maps] [web1]**     | **[Your Repo Here] [setup]**     | **[Your Repo Here] [roadmap]**           | **[Your Repo Here] [contributing]**           | **[Your Repo Here] [web5link]**           |
|-------------------------------------|-------------------------------|-----------------------------------|---------------------------------------------|-------------------------------|
| [![i1] [techdocs-image]] [techdocs] | [![i2] [setup-image]] [setup] | [![i3] [roadmap-image]] [roadmap] | [![i4] [contributing-image]] [contributing] | [![i5] [image-5]] [web5] | 

### References

1. "Graph Theory" by Keijo Ruohonen - http://math.tut.fi/~ruohonen/GT_English.pdf
2. MIT Lecture 6: Graph Theory and Coloring - http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-042j-mathematics-for-computer-science-fall-2010/video-lectures/lecture-6-graph-theory-and-coloring/
3. Graph Theory - An Introduction! - https://www.youtube.com/watch?v=HmQR8Xy9DeM
4. Graphs and Graph Theory - http://www.ccs3.lanl.gov/mega-math/gloss/graph/gr.html
5. "Introduction to Graph Theory and Applications" by Tero Harju - http://cs.bme.hu/fcs/graphtheory.pdf
6. "Graph Theory and Applications" - http://www.hamilton.ie/ollie/Downloads/Graph.pdf
7. "Basic Concepts in Graph Theory" - http://cseweb.ucsd.edu/~gill/BWLectSite/Resources/C2U4GT.pdf
8. "Introduction to Graph Theory" - http://www.math.utah.edu/mathcircle/notes/MC_Graph_Theory.pdf
9. "Data Structures Into Java" by Paul Hilfinger - http://inst.eecs.berkeley.edu/~cs61b/fa07/book2/data-structures.pdf
10. "Lecture Notes on Expansion, Sparsest Cut, and Spectral Graph Theory" by Luca Trevisan - http://www.eecs.berkeley.edu/~luca/books/expanders.pdf


[website]: https://github.com/MicBrain/Graph-API
[website1]: http://en.wikipedia.org/wiki/Graph_theory
[website2]: http://mathworld.wolfram.com/UnlabeledGraph.html
[profile]: http://linkedin.com/in/rafayelmkrtchyan
[web1]: https://github.com/MicBrain/Topographic-Maps
[techdocs-image]: https://cloud.githubusercontent.com/assets/5885065/5610184/2ec4dad2-9467-11e4-85e9-e18245752fea.jpg
[techdocs]: https://github.com/MicBrain/Topographic-Maps
[setup-image]: https://cloud.githubusercontent.com/assets/5885065/5610258/ae3fdaea-9468-11e4-9e12-cca994f2a25f.jpg
[setup]: https://github.com/MicBrain
[roadmap-image]: https://cloud.githubusercontent.com/assets/5885065/5610293/a2980d2e-9469-11e4-8ff5-9e9783c8c072.jpg
[roadmap]: https://github.com/MicBrain 
[contributing-image]: https://cloud.githubusercontent.com/assets/5885065/5610315/15eeb728-946a-11e4-9251-a24e5bb10682.jpg
[contributing]: https://github.com/MicBrain
[web5link]: https://github.com/MicBrain  
[image-5]: https://cloud.githubusercontent.com/assets/5885065/5610484/2228bffe-946d-11e4-90ed-870e7d799e4c.jpg
[web5]: https://github.com/MicBrain 



