package graph;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/** Unit tests for the Traversal class.
 *  @author Rafayel Mkrtchyan
 */

public class TraversalTesting {

    private class BFSTest extends BreadthFirstTraversal {

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

    private class DFSTest extends DepthFirstTraversal {
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

    @Test
    public void testTraversalfirst() {
        DirectedGraph dg = new DirectedGraph();
        dg.add();
        dg.add();
        dg.add();
        dg.add();
        dg.add();
        dg.add(5, 4);
        dg.add(5, 3);
        dg.add(4, 1);
        dg.add(3, 2);
        dg.add(1, 5);
        DFSTest current = new DFSTest(dg);
        ArrayList<Integer> compResultsfirst = new ArrayList<Integer>();
        ArrayList<Integer> compResultssecond = new ArrayList<Integer>();
        compResultsfirst.add(5);
        compResultsfirst.add(4);
        compResultsfirst.add(1);
        compResultsfirst.add(3);
        compResultsfirst.add(2);
        compResultssecond.add(5);
        compResultssecond.add(3);
        compResultssecond.add(2);
        compResultssecond.add(4);
        compResultssecond.add(1);
        current.traverse(5);
        ArrayList<Integer> curr = current.getVisited();
        assertTrue(curr.equals(compResultsfirst)
            || curr.equals(compResultssecond));
    }

    @Test
    public void testTraversalsecond() {
        DirectedGraph dg = new DirectedGraph();
        dg.add();
        dg.add();
        dg.add();
        dg.add();
        dg.add();
        dg.add(5, 4);
        dg.add(5, 3);
        dg.add(4, 1);
        dg.add(3, 2);
        dg.add(1, 5);
        DFSTest current = new DFSTest(dg);
        ArrayList<Integer> compResultsfirst = new ArrayList<Integer>();
        ArrayList<Integer> compResultssecond = new ArrayList<Integer>();
        compResultsfirst.add(1);
        compResultsfirst.add(4);
        compResultsfirst.add(2);
        compResultsfirst.add(3);
        compResultsfirst.add(5);
        compResultssecond.add(2);
        compResultssecond.add(3);
        compResultssecond.add(1);
        compResultssecond.add(4);
        compResultssecond.add(5);
        current.traverse(5);
        ArrayList<Integer> curr = current.getpostVisited();
        assertTrue(curr.equals(compResultsfirst)
            || curr.equals(compResultssecond));
    }

    @Test
    public void testTraversalthird() {
        DirectedGraph dg = new DirectedGraph();
        dg.add();
        dg.add();
        dg.add();
        dg.add();
        dg.add();
        dg.add(5, 4);
        dg.add(5, 3);
        dg.add(4, 1);
        dg.add(3, 2);
        dg.add(1, 5);
        BFSTest current = new BFSTest(dg);
        ArrayList<Integer> compResultsfirst = new ArrayList<Integer>();
        ArrayList<Integer> compResultssecond = new ArrayList<Integer>();
        ArrayList<Integer> compResultsthird = new ArrayList<Integer>();
        ArrayList<Integer> compResultforth = new ArrayList<Integer>();
        compResultsfirst.add(5);
        compResultsfirst.add(4);
        compResultsfirst.add(3);
        compResultsfirst.add(1);
        compResultsfirst.add(2);
        compResultssecond.add(5);
        compResultssecond.add(3);
        compResultssecond.add(4);
        compResultssecond.add(2);
        compResultssecond.add(1);
        compResultsthird.add(5);
        compResultsthird.add(4);
        compResultsthird.add(3);
        compResultsthird.add(2);
        compResultsthird.add(1);
        compResultforth.add(5);
        compResultforth.add(4);
        compResultforth.add(3);
        compResultforth.add(1);
        compResultforth.add(2);
        current.traverse(5);
        ArrayList<Integer> curr = current.getvisitedData();
        assertTrue(curr.equals(compResultsfirst)
            || curr.equals(compResultssecond)
            || curr.equals(compResultsthird)
            || curr.equals(compResultforth));
    }
}
