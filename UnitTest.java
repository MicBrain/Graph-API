package graph;

import ucb.junit.textui;

/* You MAY add public @Test methods to this class.  You may also add
 * additional public classes containing "Testing" in their name. These
 * may not be part of your graph package per se (that is, it must be
 * possible to remove them and still have your package work). */

/** Unit tests for the graph package.  This class serves to dispatch
 *  other test classes, which are listed in the argument to runClasses.
 *  @author Rafayel Mkrtchyan
 */
public class UnitTest {

    /** Run all JUnit tests in the graph package. */
    public static void main(String[] ignored) {
        System.exit(textui.runClasses(
                    graph.GraphTesting.class,
                    graph.GraphObjTesting.class,
                    graph.TraversalTesting.class,
                    graph.ShortestPathTesting.class,
                    graph.PathsTesting.class));
    }

}
