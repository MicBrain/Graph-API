package graph;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

/** Unit tests for the ShortestPah class.
 *  @author Rafayel Mkrtchyan
 */

public class ShortestPathTesting {


    @Test
    public void dginitTest() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add(2, 3);
        TestShortestPath test = new TestShortestPath(ug, 1, 3);
        test.setWeight(1, 2, 4);
        test.setWeight(2, 3, 7);
        test.setPaths();
        List<Integer> path = test.pathTo();
        assertArrayEquals(path.toArray(), new Integer[]{1, 2, 3});
    }

    @Test
    public void uginitTest() {
        UndirectedGraph ug = new UndirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add(2, 3);
        TestShortestPath test = new TestShortestPath(ug, 1, 3);
        test.setWeight(1, 2, 4);
        test.setWeight(2, 3, 7);
        test.setPaths();
        List<Integer> path = test.pathTo();
        assertArrayEquals(path.toArray(), new Integer[]{1, 2, 3});
    }

    @Test
    public void hugLecturedir() {
        DirectedGraph ug =  new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add(2, 4);
        ug.add(4, 7);
        ug.add(2, 3);
        ug.add(3, 7);
        ug.add(3, 4);
        ug.add(1, 8);
        ug.add(2, 8);
        ug.add(8, 3);
        ug.add(8, 6);
        ug.add(1, 5);
        ug.add(5, 8);
        ug.add(6, 3);
        ug.add(5, 6);
        ug.add(6, 7);
        ug.add(5, 7);
        TestShortestPath test = new TestShortestPath(ug, 1, 7);
        test.setWeight(1, 2, 5);
        test.setWeight(2, 4, 15);
        test.setWeight(4, 7, 9);
        test.setWeight(2, 3, 12);
        test.setWeight(3, 7, 11);
        test.setWeight(3, 4, 3);
        test.setWeight(1, 8, 8);
        test.setWeight(2, 8, 4);
        test.setWeight(8, 3, 7);
        test.setWeight(8, 6, 6);
        test.setWeight(1, 5, 9);
        test.setWeight(5, 8, 5);
        test.setWeight(6, 3, 1);
        test.setWeight(5, 6, 4);
        test.setWeight(6, 7, 13);
        test.setWeight(5, 7, 20);
        test.setPaths();
        List<Integer> path = test.pathTo();
        assertArrayEquals(path.toArray(), new Integer[]{1, 5, 6, 3, 7});
    }


    @Test
    public void dSampleTest() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add(1, 3);
        ug.add(3, 4);
        ug.add(4, 2);
        TestShortestPath test = new TestShortestPath(ug, 1, 2);
        test.setWeight(1, 2, 36);
        test.setWeight(1, 3, 5);
        test.setWeight(3, 4, 6);
        test.setWeight(4, 2, 3);
        test.setPaths();
        List<Integer> path = test.pathTo();
        assertArrayEquals(path.toArray(), new Integer[]{1, 3, 4, 2});
    }

    @Test
    public void cycle() {
        DirectedGraph ug = new DirectedGraph();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add();
        ug.add(1, 2);
        ug.add(2, 3);
        ug.add(3, 1);
        ug.add(3, 4);
        ug.add(4, 5);
        TestShortestPath test = new TestShortestPath(ug, 1, 5);
        test.setWeight(1, 2, 1);
        test.setWeight(2, 3, 1);
        test.setWeight(3, 1, 1);
        test.setWeight(3, 4, 4);
        test.setWeight(4, 5, 6);
        test.setPaths();
        List<Integer> path = test.pathTo();
        assertArrayEquals(path.toArray(), new Integer[]{1, 2, 3, 4, 5});
    }

    private class TestShortestPath  extends SimpleShortestPaths {

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
}
