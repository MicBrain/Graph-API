package graph;

import java.util.ArrayList;

/* See restrictions in Graph.java. */

/** Represents a general unlabeled directed graph whose vertices are denoted by
 *  positive integers. Graphs may have self edges.
 *
 *  @author Rafayel Mkrtchyan
 */
public class DirectedGraph extends GraphObj {

    @Override
    public boolean isDirected() {
        return true;
    }

    @Override
    public int inDegree(int v) {
        int count = 0;
        for (int key : getSuccessorData().keySet()) {
            if (getSuccessorData().get(key).contains(v)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int predecessor(int v, int k) {
        if (!contains(v)) {
            return 0;
        }
        if (k >= getPredecessorData().get(v).size() || k < 0) {
            return 0;
        }
        return getPredecessorData().get(v).get(k);
    }

    @Override
    public Iteration<Integer> predecessors(int v) {
        if (!contains(v)) {
            return Iteration.iteration(new ArrayList<Integer>());
        } else {
            return Iteration.iteration(getPredecessorData().get(v));
        }
    }
}
