package graph;

/* See restrictions in Graph.java. */

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.PriorityQueue;

/** The shortest paths through an edge-weighted graph.
 *  By overrriding methods getWeight, setWeight, getPredecessor, and
 *  setPredecessor, the client can determine how to represent the weighting
 *  and the search results.  By overriding estimatedDistance, clients
 *  can search for paths to specific destinations using A* search.
 *  @author Rafayel Mkrtchyan
 */
public abstract class ShortestPaths {

    /** The shortest paths in G from SOURCE. */
    public ShortestPaths(Graph G, int source) {
        this(G, source, 0);
    }

    /** A shortest path in G from SOURCE to DEST. */
    public ShortestPaths(Graph G, int source, int dest) {
        _G = G;
        _source = source;
        _dest = dest;
        Comparator<Integer> compData = new ObjCompare();
        nextVertices = new PriorityQueue<Integer>(_G.vertexSize(), compData);
    }

    /** Initialize the shortest paths.  Must be called before using
     *  getWeight, getPredecessor, and pathTo. */
    public void setPaths() {
        setWeight(getSource(), 0);
        setPredecessor(getSource(), 0);
        for (int v : _G.vertices()) {
            nextVertices.add(v);
        }
        while (!nextVertices.isEmpty()) {
            int v = nextVertices.remove();
            if (v == _dest) {
                return;
            }
            for (int w : _G.successors(v)) {
                if (getWeight(v) + getWeight(v, w) < getWeight(w)) {
                    double newWeight = getWeight(v) + getWeight(v, w);
                    setWeight(w, newWeight);
                    setPredecessor(w, v);
                    nextVertices.remove(w);
                    nextVertices.add(w);
                }
            }
        }
    }

    /** Returns the starting vertex. */
    public int getSource() {
        return _source;
    }

    /** Returns the target vertex, or 0 if there is none. */
    public int getDest() {
        return _dest;
    }

    /** Returns the current weight of vertex V in the graph.  If V is
     *  not in the graph, returns positive infinity. */
    public abstract double getWeight(int v);

    /** Set getWeight(V) to W. Assumes V is in the graph. */
    protected abstract void setWeight(int v, double w);

    /** Returns the current predecessor vertex of vertex V in the graph, or 0 if
     *  V is not in the graph or has no predecessor. */
    public abstract int getPredecessor(int v);

    /** Set getPredecessor(V) to U. */
    protected abstract void setPredecessor(int v, int u);

    /** Returns an estimated heuristic weight of the shortest path from vertex
     *  V to the destination vertex (if any).  This is assumed to be less
     *  than the actual weight, and is 0 by default. */
    protected double estimatedDistance(int v) {
        return 0.0;
    }

    /** Returns the current weight of edge (U, V) in the graph.  If (U, V) is
     *  not in the graph, returns positive infinity. */
    protected abstract double getWeight(int u, int v);

    /** Returns a list of vertices starting at _source and ending
     *  at V that represents a shortest path to V.  Invalid if there is a
     *  destination vertex other than V. */
    public List<Integer> pathTo(int v) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int temp = v;
        result.add(temp);
        int destinationVertex = getSource();
        while (temp != destinationVertex) {
            result.add(getPredecessor(temp));
            temp = getPredecessor(temp);
        }
        Collections.reverse(result);
        return result;
    }

    /** Returns a list of vertices starting at the source and ending at the
     *  destination vertex. Invalid if the destination is not specified. */
    public List<Integer> pathTo() {
        return pathTo(getDest());
    }

    /** New comparator class. */
    class ObjCompare implements Comparator<Integer> {

        /** RETURNS compare method from Comparator Interface
         *  for Integers O1 and O2. */
        @Override
        public int compare(Integer o1, Integer o2) {
            double firstValue = getWeight(o1) + estimatedDistance(o1);
            double secondValue = getWeight(o2) + estimatedDistance(o2);
            if (firstValue  == secondValue) {
                return 0;
            }
            if (firstValue < secondValue) {
                return -1;
            }
            return 1;
        }
    }

    /** The graph being searched. */
    protected final Graph _G;
    /** The starting vertex. */
    private final int _source;
    /** The target vertex. */
    private final int _dest;

    /** RETURNS information about next vertices. */
    PriorityQueue<Integer> getnextVertices() {
        return nextVertices;
    }

    /** Provides information about next vertices. */
    private PriorityQueue<Integer> nextVertices;

}
