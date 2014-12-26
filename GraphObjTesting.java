package graph;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/** Unit tests for the GraphObj class.
 *  @author Rafayel Mkrtchyan
 */

public class GraphObjTesting {

    @Test
    public void ugraphObjConst() {
        UndirectedGraph ug = new UndirectedGraph();
        assertTrue(ug.getSuccessorData().isEmpty());
        assertTrue(ug.getPredecessorData().isEmpty());
        assertTrue(ug.getNodes().isEmpty());
    }

    @Test
    public void dgraphObjConst() {
        DirectedGraph dg = new DirectedGraph();
        assertTrue(dg.getSuccessorData().isEmpty());
        assertTrue(dg.getPredecessorData().isEmpty());
        assertTrue(dg.getNodes().isEmpty());
    }

    @Test
    public void ugvertexSizeinit() {
        UndirectedGraph ug = new UndirectedGraph();
        assertEquals(0, ug.vertexSize());
    }

    @Test
    public void dgvertexSizeinit() {
        DirectedGraph dg = new DirectedGraph();
        assertEquals(0, dg.vertexSize());
    }

    @Test
    public void ugmaxVertexinit() {
        UndirectedGraph ug = new UndirectedGraph();
        assertEquals(0, ug.maxVertex());
    }

    @Test
    public void dgmaxVertexinit() {
        DirectedGraph dg = new DirectedGraph();
        assertEquals(0, dg.maxVertex());
    }

    @Test
    public void ugedgeSizeinit() {
        UndirectedGraph ug = new UndirectedGraph();
        assertEquals(0, ug.edgeSize());
    }

    @Test
    public void dgedgeSizeinit() {
        DirectedGraph dg = new DirectedGraph();
        assertEquals(0, dg.edgeSize());
    }

    @Test
    public void ugoutDegreeinit() {
        UndirectedGraph ug = new UndirectedGraph();
        assertEquals(0, ug.outDegree(5));
        assertEquals(0, ug.outDegree(1));
        assertEquals(0, ug.outDegree(100));
    }
    /** 10 */
    @Test
    public void dgoutDegreeinit() {
        DirectedGraph dg = new DirectedGraph();
        assertEquals(0, dg.outDegree(5));
        assertEquals(0, dg.outDegree(1));
        assertEquals(0, dg.outDegree(100));
    }

    @Test
    public void uginDegreeinit() {
        UndirectedGraph ug = new UndirectedGraph();
        assertEquals(0, ug.inDegree(5));
        assertEquals(0, ug.inDegree(10));
        assertEquals(0, ug.inDegree(1));
    }

    @Test
    public void dginDegreeinit() {
        DirectedGraph dg = new DirectedGraph();
        assertEquals(0, dg.inDegree(5));
        assertEquals(0, dg.inDegree(1));
        assertEquals(0, dg.inDegree(10));
    }

    @Test
    public void ugcontainsinit() {
        UndirectedGraph ug = new UndirectedGraph();
        assertFalse(ug.contains(1));
        assertFalse(ug.contains(0));
        assertFalse(ug.contains(2));
    }

    @Test
    public void dgcontainsinit() {
        DirectedGraph dg = new DirectedGraph();
        assertFalse(dg.contains(1));
        assertFalse(dg.contains(2));
        assertFalse(dg.contains(0));
    }

    @Test
    public void ugcontaininit() {
        UndirectedGraph ug = new UndirectedGraph();
        assertFalse(ug.contains(1, 2));
        assertFalse(ug.contains(2, 32));
        assertFalse(ug.contains(4, 7));
        assertFalse(ug.contains(1, 6));
        assertFalse(ug.contains(8, 2));
    }

    @Test
    public void dgcontaininit() {
        DirectedGraph dg = new DirectedGraph();
        assertFalse(dg.contains(1, 3));
        assertFalse(dg.contains(3, 4));
        assertFalse(dg.contains(5, 32));
        assertFalse(dg.contains(4, 6));
    }

    @Test
    public void testsortlist() {
        UndirectedGraph ug = new UndirectedGraph();
        ArrayList<Integer> test = new ArrayList<Integer>();
        ug.sortlist(test);
        assertEquals(0, test.size());
        ArrayList<Integer> current = new ArrayList<Integer>();
        current.add(5);
        current.add(3);
        current.add(1);
        current.add(5);
        current.add(12);
        current.add(0);
        current.add(34);
        current.add(9);
        current.add(6);
        ug.sortlist(current);
        assertEquals(9, current.size());
        int first = current.get(0);
        assertEquals(0, first);
        int second = current.get(1);
        assertEquals(1, second);
    }

    @Test
    public void untestaddinit() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        assertTrue(ug.getSuccessorData().containsKey(1));
        assertTrue(ug.getSuccessorData().get(1).isEmpty());
        UndirectedGraph g = new UndirectedGraph();
        g.add();
        g.add();
        g.add();
        assertTrue(g.getSuccessorData().containsKey(1));
        assertTrue(g.getSuccessorData().get(1).isEmpty());
        assertTrue(g.getSuccessorData().containsKey(2));
        assertTrue(g.getSuccessorData().get(2).isEmpty());
        assertTrue(g.getSuccessorData().containsKey(3));
        assertTrue(g.getSuccessorData().get(3).isEmpty());
        assertFalse(g.getSuccessorData().containsKey(4));
        g.add();
        assertTrue(g.getSuccessorData().containsKey(4));
        assertTrue(g.getSuccessorData().get(4).isEmpty());
    }

    @Test
    public void dntestaddinit() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        assertTrue(ug.getSuccessorData().containsKey(1));
        assertTrue(ug.getSuccessorData().get(1).isEmpty());
        DirectedGraph g = new DirectedGraph();
        g.add();
        g.add();
        g.add();
        assertTrue(g.getSuccessorData().containsKey(1));
        assertTrue(g.getSuccessorData().get(1).isEmpty());
        assertTrue(g.getSuccessorData().containsKey(2));
        assertTrue(g.getSuccessorData().get(2).isEmpty());
        assertTrue(g.getSuccessorData().containsKey(3));
        assertTrue(g.getSuccessorData().get(3).isEmpty());
        assertFalse(g.getSuccessorData().containsKey(4));
        g.add();
        assertTrue(g.getSuccessorData().containsKey(4));
        assertTrue(g.getSuccessorData().get(4).isEmpty());
    }

    @Test
    public void ugextensiveadd() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        assertEquals(1, ug.vertexSize());
        assertEquals(1, ug.maxVertex());
        assertEquals(0, ug.edgeSize());
        assertEquals(0, ug.inDegree(1));
        assertEquals(0, ug.inDegree(3));
        assertTrue(ug.contains(1));
        assertFalse(ug.contains(1, 3));
        UndirectedGraph g = new UndirectedGraph();
        g.add();
        g.add();
        g.add();
        assertEquals(3, g.vertexSize());
        assertEquals(3, g.maxVertex());
        assertEquals(0, g.edgeSize());
        assertEquals(0, g.inDegree(1));
        assertEquals(0, g.inDegree(3));
        assertTrue(g.contains(1));
        assertFalse(g.contains(1, 3));
        assertTrue(g.contains(2));
        assertTrue(g.contains(3));
        assertFalse(g.contains(4));
        g.add();
        assertEquals(4, g.vertexSize());
        assertEquals(4, g.maxVertex());
        assertEquals(0, g.edgeSize());
        assertEquals(0, g.inDegree(1));
        assertEquals(0, g.inDegree(3));
        assertTrue(g.contains(1));
        assertFalse(g.contains(1, 3));
        assertTrue(g.contains(2));
        assertTrue(g.contains(3));
        assertTrue(g.contains(4));
    }

    @Test
    public void dgextensiveadd() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        assertEquals(1, ug.vertexSize());
        assertEquals(1, ug.maxVertex());
        assertEquals(0, ug.edgeSize());
        assertEquals(0, ug.inDegree(1));
        assertEquals(0, ug.inDegree(3));
        assertTrue(ug.contains(1));
        assertFalse(ug.contains(1, 3));
        DirectedGraph g = new DirectedGraph();
        g.add();
        g.add();
        g.add();
        assertEquals(3, g.vertexSize());
        assertEquals(3, g.maxVertex());
        assertEquals(0, g.edgeSize());
        assertEquals(0, g.inDegree(1));
        assertEquals(0, g.inDegree(3));
        assertTrue(g.contains(1));
        assertFalse(g.contains(1, 3));
        assertTrue(g.contains(2));
        assertTrue(g.contains(3));
        assertFalse(g.contains(4));
        g.add();
        assertEquals(4, g.vertexSize());
        assertEquals(4, g.maxVertex());
        assertEquals(0, g.edgeSize());
        assertEquals(0, g.inDegree(1));
        assertEquals(0, g.inDegree(3));
        assertTrue(g.contains(1));
        assertFalse(g.contains(1, 3));
        assertTrue(g.contains(2));
        assertTrue(g.contains(3));
        assertTrue(g.contains(4));
    }


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
        assertTrue(ug.getSuccessorData().containsKey(1));
        assertTrue(ug.getSuccessorData().containsKey(2));
        assertTrue(ug.getSuccessorData().containsKey(3));
        assertTrue(ug.getSuccessorData().containsKey(4));
        assertEquals(2, ug.getSuccessorData().get(1).size());
        assertEquals(2, ug.getSuccessorData().get(2).size());
        assertEquals(3, ug.getSuccessorData().get(3).size());
        assertEquals(1, ug.getSuccessorData().get(4).size());
        int afirst = ug.getSuccessorData().get(1).get(0);
        int asecond = ug.getSuccessorData().get(1).get(1);
        assertEquals(2, afirst);
        assertEquals(3, asecond);
        int bfirst = ug.getSuccessorData().get(2).get(0);
        int bsecond = ug.getSuccessorData().get(2).get(1);
        assertEquals(1, bfirst);
        assertEquals(3, bsecond);
        int cfirst = ug.getSuccessorData().get(3).get(0);
        int csecond = ug.getSuccessorData().get(3).get(1);
        int cthird = ug.getSuccessorData().get(3).get(2);
        assertEquals(1, cfirst);
        assertEquals(2, csecond);
        assertEquals(4, cthird);
        int dfirst = ug.getSuccessorData().get(4).get(0);
        assertEquals(3, dfirst);
    }

    @Test
    public void dtestfirst() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add(1, 2);
        assertTrue(ug.contains(1, 2));
        assertFalse(ug.contains(2, 1));
        assertFalse(ug.contains(1, 3));
        ug.add();
        ug.add(1, 3);
        assertTrue(ug.contains(1, 3));
        ug.add();
        ug.add(2, 3);
        assertTrue(ug.contains(2, 3));
        assertFalse(ug.contains(3, 2));
        ug.add(3, 4);
        assertTrue(ug.contains(3, 4));
        assertTrue(ug.getSuccessorData().containsKey(1));
        assertTrue(ug.getSuccessorData().containsKey(2));
        assertTrue(ug.getSuccessorData().containsKey(3));
        assertTrue(ug.getSuccessorData().containsKey(4));
        assertEquals(2, ug.getSuccessorData().get(1).size());
        assertEquals(1, ug.getSuccessorData().get(2).size());
        assertEquals(1, ug.getSuccessorData().get(3).size());
        assertEquals(0, ug.getSuccessorData().get(4).size());
        int afirst = ug.getSuccessorData().get(1).get(0);
        int asecond = ug.getSuccessorData().get(1).get(1);
        assertEquals(2, afirst);
        assertEquals(3, asecond);
        int bfirst = ug.getSuccessorData().get(2).get(0);
        assertEquals(3, bfirst);
        int cfirst = ug.getSuccessorData().get(3).get(0);
        assertEquals(4, cfirst);
    }

    @Test
    public void dtestsecond() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add();
        ug.add(1, 3);
        ug.add();
        ug.add(2, 3);
        ug.add(3, 4);
        assertEquals(0, ug.getPredecessorData().get(1).size());
        assertEquals(1, ug.getPredecessorData().get(2).size());
        assertEquals(2, ug.getPredecessorData().get(3).size());
        assertEquals(1, ug.getPredecessorData().get(4).size());
        int bfirst = ug.getPredecessorData().get(2).get(0);
        assertEquals(1, bfirst);
        int cfirst = ug.getPredecessorData().get(3).get(0);
        int csecond = ug.getPredecessorData().get(3).get(1);
        assertEquals(1, cfirst);
        assertEquals(2, csecond);
        int dfirst = ug.getPredecessorData().get(4).get(0);
        assertEquals(3, dfirst);
    }

    @Test
    public void uremoveone() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        assertTrue(ug.contains(3));
        ug.remove(3);
        assertFalse(ug.contains(3));
        assertTrue(ug.contains(2));
        ug.remove(2);
        assertFalse(ug.contains(2));
        ug.add();
        assertTrue(ug.contains(2));
        ug.remove(2);
        assertFalse(ug.contains(2));
    }

    @Test
    public void dremoveone() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        assertTrue(ug.contains(3));
        ug.remove(3);
        assertFalse(ug.contains(3));
        assertTrue(ug.contains(2));
        ug.remove(2);
        assertFalse(ug.contains(2));
        ug.add();
        assertTrue(ug.contains(2));
        ug.remove(2);
        assertFalse(ug.contains(2));
    }

    @Test
    public void uremovetwo() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add();
        ug.add(1, 3);
        ug.add();
        ug.add(2, 3);
        ug.add(3, 4);
        assertTrue(ug.contains(3));
        ug.remove(3);
        assertFalse(ug.contains(3));
        ug.add();
        assertTrue(ug.contains(3));
        assertTrue(ug.contains(1, 2));
        assertTrue(ug.contains(2, 1));
        assertFalse(ug.contains(1, 3));
        assertFalse(ug.contains(2, 3));
        assertFalse(ug.contains(3, 4));
    }

    @Test
    public void dremovetwo() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add();
        ug.add(1, 3);
        ug.add();
        ug.add(2, 3);
        ug.add(3, 4);
        assertTrue(ug.contains(3));
        ug.remove(3);
        assertFalse(ug.contains(3));
        ug.add();
        assertTrue(ug.contains(3));
        assertTrue(ug.contains(1, 2));
        assertFalse(ug.contains(1, 3));
        assertFalse(ug.contains(2, 3));
        assertFalse(ug.contains(3, 4));
        assertFalse(ug.contains(2, 1));
    }

    @Test
    public void utestSuccessor() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add(1, 3);
        ug.add(1, 4);
        ug.add(4, 3);
        assertEquals(2, ug.successor(1, 0));
        assertEquals(0, ug.successor(5, 0));
        assertEquals(3, ug.successor(1, 1));
        assertEquals(4, ug.successor(1, 2));
        assertEquals(0, ug.successor(1, 3));
        assertEquals(0, ug.successor(1, 4));
        assertEquals(1, ug.successor(2, 0));
        assertEquals(0, ug.successor(2, 1));
        assertEquals(1, ug.successor(3, 0));
        assertEquals(4, ug.successor(3, 1));
        assertEquals(0, ug.successor(3, 2));
        assertEquals(1, ug.successor(4, 0));
        assertEquals(3, ug.successor(4, 1));
        assertEquals(0, ug.successor(4, 2));
        assertEquals(0, ug.successor(6, 0));
    }

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

    @Test
    public void utestdobleadd() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add(1, 2);
        assertEquals(1, ug.getSuccessorData().get(1).size());
        int firstitem = ug.getSuccessorData().get(1).get(0);
        assertEquals(2, firstitem);
        assertEquals(1, ug.getSuccessorData().get(2).size());
        int seconditem = ug.getSuccessorData().get(2).get(0);
        assertEquals(1, seconditem);
    }

    @Test
    public void dtestdobleadd() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add(1, 2);
        assertEquals(1, ug.getSuccessorData().get(1).size());
        assertEquals(0, ug.getSuccessorData().get(2).size());
        int itemfirst = ug.getSuccessorData().get(1).get(0);
        assertEquals(2, itemfirst);
        assertEquals(0, ug.getPredecessorData().get(1).size());
        assertEquals(1, ug.getPredecessorData().get(2).size());
        int seconditem = ug.getPredecessorData().get(2).get(0);
        assertEquals(1, seconditem);
    }

    @Test
    public void dpredecessor() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add(2, 3);
        ug.add(1, 4);
        ug.add(4, 2);
        assertEquals(0, ug.getPredecessorData().get(1).size());
        assertEquals(2, ug.getPredecessorData().get(2).size());
        assertEquals(1, ug.getPredecessorData().get(3).size());
        assertEquals(1, ug.getPredecessorData().get(4).size());
        assertEquals(0, ug.predecessor(1, 0));
        assertEquals(1, ug.predecessor(2, 0));
        assertEquals(4, ug.predecessor(2, 1));
        assertEquals(0, ug.predecessor(2, 2));
        assertEquals(2, ug.predecessor(3, 0));
        assertEquals(0, ug.predecessor(3, 1));
        assertEquals(1, ug.predecessor(4, 0));
        assertEquals(0, ug.predecessor(4, 1));
    }

    @Test
    public void testvertices() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int x : ug.vertices()) {
            result.add(x);
        }
        int first = result.get(0);
        int second = result.get(1);
        int third = result.get(2);
        int forth = result.get(3);
        assertEquals(1, first);
        assertEquals(2, second);
        assertEquals(3, third);
        assertEquals(4, forth);
    }

    @Test
    public void usuccessors() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ArrayList<Integer> result = new ArrayList<Integer>();
        ug.add(1, 2);
        ug.add(2, 3);
        ug.add(1, 4);
        ug.add(4, 2);
        for (int x : ug.successors(1)) {
            result.add(x);
        }
        int first = result.get(0);
        int second = result.get(1);
        assertEquals(2, result.size());
        assertEquals(2, first);
        assertEquals(4, second);
    }

    @Test
    public void dsuccessors() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ArrayList<Integer> result = new ArrayList<Integer>();
        ug.add(1, 2);
        ug.add(2, 3);
        ug.add(1, 4);
        ug.add(4, 2);
        ArrayList<Integer> newresult = new ArrayList<Integer>();
        for (int x : ug.successors(3)) {
            newresult.add(x);
        }
        assertEquals(0, newresult.size());

        for (int x : ug.successors(1)) {
            result.add(x);
        }
        int first = result.get(0);
        int second = result.get(1);
        assertEquals(2, result.size());
        assertEquals(2, first);
        assertEquals(4, second);
    }

    @Test
    public void usuccessorsnew() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ArrayList<Integer> result = new ArrayList<Integer>();
        ug.add(1, 2);
        ug.add(2, 3);
        ug.add(1, 4);
        ug.add(4, 2);
        for (int x : ug.successors(5)) {
            result.add(x);
        }
        assertEquals(0, result.size());
    }


    @Test
    public void uremovevertexTest() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(2, 3);
        ug.add(2, 4);
        ug.add(2, 5);
        assertEquals(3, ug.getSuccessorData().get(2).size());
        ug.remove(4);
        assertFalse(ug.contains(4));
        assertEquals(2, ug.getSuccessorData().get(2).size());
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int x : ug.successors(2)) {
            result.add(x);
        }
        assertEquals(2, result.size());
        int first = ug.successor(2, 0);
        int second = ug.successor(2, 1);
        assertEquals(3, first);
        assertEquals(5, second);
        int third = result.get(0);
        int forth = result.get(1);
        assertEquals(3, third);
        assertEquals(5, forth);
    }

    @Test
    public void dremovevertexTest() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(2, 3);
        ug.add(2, 4);
        ug.add(2, 5);
        assertEquals(3, ug.getSuccessorData().get(2).size());
        ug.remove(4);
        assertFalse(ug.contains(4));
        assertEquals(2, ug.getSuccessorData().get(2).size());
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int x : ug.successors(2)) {
            result.add(x);
        }
        assertEquals(2, result.size());
        int first = ug.successor(2, 0);
        int second = ug.successor(2, 1);
        assertEquals(3, first);
        assertEquals(5, second);
        int third = result.get(0);
        int forth = result.get(1);
        assertEquals(3, third);
        assertEquals(5, forth);
    }

    @Test
    public void utestsucpred() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        assertEquals(0, ug.predecessor(0, 0));
    }

    @Test
    public void dtestsucpred() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        assertEquals(0, ug.predecessor(0, 0));
    }

    @Test
    public void testUedgesize() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 3);
        ug.add(3, 1);
        ug.add(2, 3);
        assertEquals(2, ug.edgeSize());
    }


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

    @Test
    public void testadd() {
        DirectedGraph dg = new DirectedGraph();
        dg.add();
        dg.add();
        dg.add();
        assertEquals(5, dg.add(5, 6));
    }

    @Test
    public void testOutgoing() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 1);
        ug.add(1, 2);
        ug.add(1, 3);
        ug.add(1, 4);
        assertEquals(4, ug.outDegree(1));
    }

    @Test
    public void uselfedges() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 1);
        ug.add(1, 2);
        ug.add(1, 3);
        ug.add(1, 4);
        ug.remove(1, 1);
        assertEquals(3, ug.outDegree(1));
        ug.add(1, 1);
        ug.remove(1);
        assertEquals(0, ug.outDegree(1));
        assertEquals(0, ug.outDegree(2));
    }

    @Test
    public void testaddlast() {
        DirectedGraph dg =  new DirectedGraph();
        dg.add();
        dg.add(1, 1);
        dg.add(1, 1);
        assertTrue(dg.getSuccessorData().get(1).contains(1));
        assertTrue(dg.getPredecessorData().get(1).contains(1));
    }

    @Test
    public void addremove() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.remove(1);
        assertFalse(ug.getNodes().contains(1));
        ug.add();
        assertTrue(ug.getNodes().contains(1));
        ug.remove(1);
        ug.remove(2);
        assertFalse(ug.getNodes().contains(1));
        assertFalse(ug.getNodes().contains(2));
        ug.add();
        assertTrue(ug.getNodes().contains(1));
        assertFalse(ug.getNodes().contains(2));
    }

    @Test
    public void checkEdgeCount() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add(1, 3);
        int count = 0;
        for (int[] lst : ug.edges()) {
            count++;
        }
        assertEquals(2, count);
        ug.add(2, 2);
        ug.add(34, 35);
        int newCount = 0;
        for (int[] lst : ug.edges()) {
            newCount++;
        }
        assertEquals(3, newCount);
    }

    @Test
    public void checedge() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add(1, 1);
        assertEquals(1, ug.edgeSize());
    }


    @Test
    public void dchecedge() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add(1, 1);
        assertEquals(1, ug.edgeSize());
    }

    @Test
    public void newedgesize() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 1);
        ug.add(2, 2);
        ug.add(3, 3);
        ug.add(4, 4);
        ug.add(1, 2);
        ug.add(2, 4);
        ug.add(3, 4);
        ug.add(3, 2);
        ug.add(1, 3);
        assertEquals(9, ug.edgeSize());
    }

    @Test
    public void newedgesizeDir() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 1);
        ug.add(2, 2);
        ug.add(3, 3);
        ug.add(1, 2);
        ug.add(1, 3);
        ug.add(2, 3);
        ug.add(3, 2);
        ug.add(2, 4);
        ug.add(4, 2);
        ug.add(4, 3);
        ug.add(3, 4);
        assertEquals(11, ug.edgeSize());
    }

    @Test
    public void nedgesizeDir() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 1);
        ug.add(2, 2);
        ug.add(3, 3);
        ug.add(1, 2);
        ug.add(1, 3);
        ug.add(2, 3);
        ug.add(3, 2);
        ug.add(2, 4);
        ug.add(4, 2);
        ug.add(4, 3);
        ug.add(3, 4);
        ug.remove(1);
        assertEquals(8, ug.edgeSize());
        ug.remove(3);
        assertEquals(3, ug.edgeSize());
    }


    @Test
    public void unedgesizeDir() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 1);
        ug.add(2, 2);
        ug.add(3, 3);
        ug.add(1, 2);
        ug.add(1, 3);
        ug.add(2, 3);
        ug.add(3, 2);
        ug.add(2, 4);
        ug.add(4, 2);
        ug.add(4, 3);
        ug.add(3, 4);
        assertEquals(8, ug.edgeSize());
        ug.remove(1);
        assertEquals(5, ug.edgeSize());
        ug.remove(3);
        assertEquals(2, ug.edgeSize());
        ug.remove(4);
        assertEquals(1, ug.edgeSize());
    }
}
