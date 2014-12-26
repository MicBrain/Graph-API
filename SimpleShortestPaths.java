package graph;

import java.util.HashMap;

/* See restrictions in Graph.java. */

/** A partial implementation of ShortestPaths that contains the weights of
 *  the vertices and the predecessor edges.   The client needs to
 *  supply only the two-argument getWeight method.
 *  @author Rafayel Mkrtchyan
 */
public abstract class SimpleShortestPaths extends ShortestPaths {

    /** The shortest paths in G from SOURCE. */
    public SimpleShortestPaths(Graph G, int source) {
        this(G, source, 0);
        weightData = new HashMap<Integer, Double>();
        predecessorData = new HashMap<Integer, Integer>();
    }

    /** A shortest path in G from SOURCE to DEST. */
    public SimpleShortestPaths(Graph G, int source, int dest) {
        super(G, source, dest);
        weightData = new HashMap<Integer, Double>();
        predecessorData = new HashMap<Integer, Integer>();
    }

    @Override
    public double getWeight(int v) {
        if (weightData.containsKey(v)) {
            return weightData.get(v);
        }
        return Double.MAX_VALUE;
    }

    @Override
    protected void setWeight(int v, double w) {
        weightData.put(v, w);
    }

    @Override
    public int getPredecessor(int v) {
        if (predecessorData.containsKey(v)) {
            return predecessorData.get(v);
        }
        return Integer.MAX_VALUE;
    }

    @Override
    protected void setPredecessor(int v, int u) {
        predecessorData.put(v, u);
    }

    HashMap<Integer, Double> weightData;
    HashMap<Integer, Integer> predecessorData;
}
