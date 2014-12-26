package graph;

/* See restrictions in Graph.java. */

import java.util.ArrayList;

/** A Graph whose vertices are labeled with type VL and whose edges are
 *  labeled with type EL.
 *  @author P. N. Hilfinger
 */
public class LabeledGraph<VL, EL> extends GraphFilter {

    /** A labeling of the graph G.  Accessors and modifiers of the graph
     *  act upon G.  Attempts to modify the graph structure directly through
     *  G have undefined effects upon the labeled version created by this
     *  constructor. */
    public LabeledGraph(Graph G) {
        super(G);
    }

    /** Returns the label on vertex V, which must be one of my
     *  vertices. */
    public VL getLabel(int v) {
        checkMyVertex(v);
        return _vlabel.get(v);
    }

    /** Returns the label on the edge (U, V), which must be one of my edges. */
    public EL getLabel(int u, int v) {
        int e = edgeId(u, v);
        if (e == 0) {
            throw new IllegalArgumentException("no such edge");
        }
        return _elabel.get(e);
    }

    /** Set getVertexLabel(V) to LAB, returning V.  V must be one of
     *  my vertices. */
    public int setLabel(int v, VL lab) {
        checkMyVertex(v);
        _vlabel.set(v, lab);
        return v;
    }

    /** Set getEdgeLabel(U, V) to LAB, returning U. (U, V) must be one
     *  of my edges. */
    public int setLabel(int u, int v, EL lab) {
        int e = edgeId(u, v);
        if (e == 0) {
            throw new IllegalArgumentException("no such edge");
        }
        _elabel.set(e, lab);
        return u;
    }

    @Override
    public int add() {
        int v = super.add();
        while (v >= _vlabel.size()) {
            _vlabel.add(null);
        }
        return v;
    }

    @Override
    public int add(int u, int v) {
        super.add(u, v);
        int e = edgeId(u, v);
        while (e >= _elabel.size()) {
            _elabel.add(null);
        }
        return u;
    }

    /** Returns a new vertex labeled LAB, and adds it to me with no
     *  incident edges. */
    public int add(VL lab) {
        return setLabel(add(), lab);
    }

    /** Adds an edge incident on U and V, labeled with LAB and returns U.
     *  If I am directed, the edge is directed (leaves U and enters V). */
    public int add(int u, int v, EL lab) {
        add(u, v);
        return setLabel(u, v, lab);
    }

    @Override
    public void remove(int v) {
        super.remove(v);
        _vlabel.set(v, null);
    }

    @Override
    public void remove(int u, int v) {
        int e = edgeId(u, v);
        if (e != 0) {
            super.remove(u, v);
            _elabel.set(e, null);
        }
    }

    /** Mapping of vertex numbers to vertex labels. */
    private final ArrayList<VL> _vlabel = new ArrayList<>();
    /** Mapping of unique edge ids to edge labels. */
    private final ArrayList<EL> _elabel = new ArrayList<>();
}
