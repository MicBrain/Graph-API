package graph;

/* See restrictions in Graph.java. */

import java.util.Iterator;

/** An Iteration<TYPE> is an Iterator<TYPE> that may also be used in a foreach
 *  loop.  That is, it implements the Interable<TYPE> interface by simply
 *  returning itself.  For example, this allows one to write
 *      for (int[] e: G.edges()) {
 *           ...
 *      }
 *  @author P. N. Hilfinger
 */
public abstract class Iteration<Type>
    implements Iterator<Type>, Iterable<Type> {

    @Override
    public Iterator<Type> iterator() {
        return this;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }

    /** A wrapper class that turns an Iterator<TYPE> into an Iteration<TYPE>. */
    private static class SimpleIteration<Type> extends Iteration<Type> {
        /** ITER as an iteration. */
        SimpleIteration(Iterator<Type> iter) {
            _iter = iter;
        }

        @Override
        public boolean hasNext() {
            return _iter.hasNext();
        }

        @Override
        public Type next() {
            return _iter.next();
        }

        /** The iterator with which I was constructed. */
        private Iterator<Type> _iter;
    }

    /** Returns an Iteration<TYPE> that delegates to IT. */
    static <Type> Iteration<Type> iteration(Iterator<Type> it) {
        return new SimpleIteration<>(it);
    }

    /** Returns an Iteration<TYPE> that delegates to ITERABLE. */
    static <Type> Iteration<Type> iteration(Iterable<Type> iterable) {
        return new SimpleIteration<>(iterable.iterator());
    }

}
