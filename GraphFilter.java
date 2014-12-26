package graph;

/** A Graph that delegates all its operations to another, preexisting
 *  Graph object.  This is intended to be extended, and selected methods
 *  overridden, as needed.
 *  @author P. N. Hilfinger */
public class GraphFilter extends Graph {

    /** A Graph that delegates all operations to G. */
    public GraphFilter(Graph G) {
        _G = G;
    }

    @Override
    public int add() {
        return _G.add();
    }

    @Override
    public int add(int u, int v) {
        return _G.add(u, v);
    }

    @Override
    public void remove(int v) {
        _G.remove(v);
    }

    @Override
    public void remove(int u, int v) {
        _G.remove(u, v);
    }

    @Override
    public int vertexSize() {
        return _G.vertexSize();
    }

    @Override
    public int maxVertex() {
        return _G.maxVertex();
    }

    @Override
    public int edgeSize() {
        return _G.edgeSize();
    }

    @Override
    public boolean isDirected() {
        return _G.isDirected();
    }

    @Override
    public int outDegree(int v) {
        return _G.outDegree(v);
    }

    @Override
    public int inDegree(int v) {
        return _G.inDegree(v);
    }

    @Override
    public boolean contains(int u) {
        return _G.contains(u);
    }

    @Override
    public boolean contains(int u, int v) {
        return _G.contains(u, v);
    }

    @Override
    public Iteration<Integer> vertices() {
        return _G.vertices();
    }

    @Override
    public Iteration<Integer> successors(int v) {
        return _G.successors(v);
    }

    @Override
    public int successor(int v, int k) {
        return _G.successor(v, k);
    }

    @Override
    public int predecessor(int v, int k) {
        return _G.predecessor(v, k);
    }

    @Override
    public Iteration<Integer> predecessors(int v) {
        return _G.predecessors(v);
    }

    @Override
    public Iteration<int[]> edges() {
        return _G.edges();
    }

    @Override
    protected boolean mine(int v) {
        return _G.mine(v);
    }

    @Override
    protected int edgeId(int u, int v) {
        return _G.edgeId(u, v);
    }

    @Override
    protected void checkMyVertex(int v) {
        _G.checkMyVertex(v);
    }

    /** My underlying graph. */
    private final Graph _G;
}


